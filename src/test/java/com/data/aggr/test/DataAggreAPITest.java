/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.test;

import com.data.aggr.dto.request.DataRequest;
import com.data.aggr.dto.request.ResetRequest;
import com.data.aggr.entity.ClientInfo;
import com.data.aggr.repository.ClientInfoRepository;
import com.data.aggr.util.EncryptionUtil;
import com.data.aggr.util.Enum.AccountClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author cojiteli
 */
public class DataAggreAPITest {

    private final String BASE_URL = "http://localhost:8000/nibss/dataaggr/api/v1/";
    ObjectMapper objectMapper = new ObjectMapper();
    private Client client;
    private WebTarget pingTarget, resetTarget, sendTarget;
    Invocation.Builder requestBuilder = null;
    String clientUsername = "testuser";

    @Autowired
    ClientInfoRepository clientInfoRepository;

    @Before
    public void doInit() {
        this.client = ClientBuilder.newClient();
        this.pingTarget = client.target("http://localhost:8000/nibss/dataaggr/ping");
        this.resetTarget = client.target(BASE_URL + "reset");
        this.sendTarget = client.target(BASE_URL + "send");
        requestBuilder = sendTarget.request();
    }

    @Test
    public void doPing() {
        Response pingResp = pingTarget.request().get();
        assertEquals(200, pingResp.getStatus());
        System.out.println("Data Aggregation Ping Response = " + pingResp.readEntity(String.class));
    }

    @Test
    public void doReset() throws JsonProcessingException {
        ResetRequest resetRequest = new ResetRequest();
        resetRequest.setUsername(clientUsername);
        Response resetResponse = resetTarget.request().post(Entity.json(objectMapper.writeValueAsString(resetRequest)));
        assertEquals(200, resetResponse.getStatus());
        System.out.println("Reset Response = " + resetResponse.readEntity(String.class));

    }

    @Test
    public void sendData() throws JsonProcessingException, Exception {

        String authorization = "", clearSignature = "", encodedUsername = "";
        DataRequest dataRequest = new DataRequest();

        ClientInfo findByUsername = clientInfoRepository.findByUsername(clientUsername);
        if (findByUsername != null) {
            //security headers
            encodedUsername = Base64.getEncoder().encodeToString(clientUsername.getBytes());
            requestBuilder = requestBuilder.header("USERNAME", encodedUsername);
            authorization = Base64.getEncoder().encodeToString((findByUsername.getUsername() + ":" + findByUsername.getPassword() + ":" + findByUsername.getToken()).getBytes());
            requestBuilder = requestBuilder.header("Authorization", authorization);
            clearSignature = findByUsername.getUsername() + new SimpleDateFormat("yyyyMMdd").format(new Date()) + findByUsername.getPassword() + findByUsername.getToken();
            System.out.println("Clear Signature for Data Request : " + clearSignature);
            String hashSignature = EncryptionUtil.generateSha256(clearSignature);
            System.out.println("Hash Signature [ Hex] for Data Request : " + hashSignature);
            requestBuilder = requestBuilder.header("SIGNATURE", hashSignature);
            requestBuilder = requestBuilder.header("SIGNATURE_METH", "SHA256");
        }
        dataRequest.setAccountClass(AccountClass.COLLECTION.getEnumValue());
        Response dataResponse = requestBuilder.post(Entity.json(objectMapper.writeValueAsString(dataRequest)));
        assertEquals(200, dataResponse.getStatus());
        System.out.println("Data Response = " + dataResponse.readEntity(String.class));

    }

}
