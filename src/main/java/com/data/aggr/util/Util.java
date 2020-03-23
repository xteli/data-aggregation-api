/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.util;

import com.data.aggr.entity.ClientInfo;
import com.data.aggr.repository.ClientInfoRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 *
 * @author chineduojiteli
 */
@Component
public class Util {

    /**
     * *
     *
     * Special encryption method
     */
   // public static final String COMMA = ",", FULL_COLON = ":", ALGORITHM = "AES/CBC/PKCS5Padding", AES = "AES";

    Logger logger = LoggerFactory.getLogger(Util.class);
    ClientInfoRepository clientInfoRepository;

    @Autowired
    public Util(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    public static String doRandomPassword(int len) {
        String resp = "";
        try {
            final String alphabet = "1234567890!@$%^&*()~ASQWERTYUOPDFGHJKZXVBNM?qwertyuopasdfghjkzxcvbnm";
            final int N = alphabet.length();
            Random rd = new Random();
            int iLength = len;
            StringBuilder sb = new StringBuilder(iLength);
            for (int i = 0; i < iLength; i++) {
                sb.append(alphabet.charAt(rd.nextInt(N)));
            }
            resp = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    public List<String> doHeaderValidation(HttpHeaders headers) throws IOException {
        logger.info(" ..: inside doHeaderValidation() :.. ");
        List<String> errorList = new ArrayList<>();
        String encodedUsername = headers.getFirst("USERNAME");
        String authorization = headers.getFirst("Authorization");
        String signature = headers.getFirst("SIGNATURE");
        String signatureMethod = headers.getFirst("SIGNATURE_METH");

        logger.info("Encoded Client Username : " + encodedUsername);
        try {
            if (encodedUsername == null || "".equals(encodedUsername)) {
                errorList.add("Missing client username");
            }
            if (authorization == null || "".equals(authorization)) {
                errorList.add("Missing client authorization string");
            }
            if (signature == null || "".equals(signature)) {
                errorList.add("Missing client signature");
            }
            if (signatureMethod == null || "".equals(signatureMethod)) {
                errorList.add("Missing client signature method");
            }
            if (signatureMethod == null && !signatureMethod.equals("SHA256")) {
                errorList.add("Invalid signaure method.Valid Signature Method [SHA256] must be provided");
            }
            logger.info(" ..: About to validate header information :.. ");
            String username = new String(Base64.getDecoder().decode(encodedUsername));
            ClientInfo clientInfo = clientInfoRepository.findByUsername(username);

            if (clientInfo != null) {
                if (!validateAuthString(authorization, clientInfo)) {
                    errorList.add(authorization + " is not a valid authorization string.");
                }
                if (!validateSignature(signature, clientInfo)) {
                    errorList.add(signature + " is not a valid signature.");
                }
            } else {
                errorList.add("Client " + username + " not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorList;
    }

    boolean validateAuthString(String authorization, ClientInfo client) {
        boolean valid = false;
        String encodedAuthString = Base64.getEncoder().encodeToString((client.getUsername() + ":" + client.getPassword() + ":" + client.getToken()).getBytes());
        valid = encodedAuthString.equals(authorization);
        return valid;
    }

    boolean validateSignature(String signature, ClientInfo client) {
        boolean valid = false;
        String signatureHash = EncryptionUtil.generateSha256(client.getUsername() + new SimpleDateFormat("yyyyMMdd").format(new Date()) + client.getPassword() + client.getToken());
        valid = signatureHash.equals(signature);
        return valid;
    }
    
     public static <T> T toPOJO(String requestStr, Class<T> entityClass) throws JsonMappingException, JsonGenerationException, IOException, UnrecognizedPropertyException {
        T entity = null;
        ObjectMapper om = new ObjectMapper();
        entity = (T) om.readValue(requestStr, entityClass);
        return entity;
    }

}
