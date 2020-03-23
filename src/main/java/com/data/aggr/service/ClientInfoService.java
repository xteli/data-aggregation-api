/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.service;

import com.data.aggr.dto.ServiceResponse;
import com.data.aggr.dto.request.ResetRequest;
import com.data.aggr.dto.response.ResetResponse;
import com.data.aggr.entity.ClientInfo;
import com.data.aggr.repository.ClientInfoRepository;
import com.data.aggr.util.StatusCode;
import com.data.aggr.util.Util;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chineduojiteli
 */
@Service
public class ClientInfoService {

    ServiceResponse serviceResponse = new ServiceResponse();
    Logger logger = LoggerFactory.getLogger(ClientInfoService.class);
    ClientInfoRepository clientInfoRepository;
    StringBuilder builder = null;

    @Autowired
    public ClientInfoService(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    public ResetResponse reset(ResetRequest resetRequest) {
        logger.info(".. inside reset()");
        ResetResponse resetResponse = new ResetResponse();
        String status = "", message = "";
        String iv = "", key = "";
        builder = new StringBuilder();
        try {
            if (resetRequest != null) {
                if (null == resetRequest.getUsername() || "".equals(resetRequest.getUsername())) {
                    status = StatusCode.MISSING_PARAMETERS;
                    message = "MISSING CLIENT USERNAME";
                } else {
                    System.out.println("About reseting user credentials");
                    ClientInfo clientInfo = clientInfoRepository.findByUsername(resetRequest.getUsername());
                    if (clientInfo != null) {
                        //generate token via Universally Unique ID
                        key = UUID.randomUUID().toString().replace("-", "").substring(16);
                        iv = Util.doRandomPassword(16);
                        clientInfo.setToken(key);
                        clientInfo.setPassword(iv);
                        clientInfo.setDateModified(new Date());
                        ClientInfo client = clientInfoRepository.save(clientInfo);
                        if (client != null) {
                            status = StatusCode.SUCCESSFUL;
                            message = "RESET SUCCESSFUL.USE THE NEW CREDENTIALS SUBSEQUENTLY.";
                        } else {
                            status = StatusCode.GENERAL_EXCEPTION;
                            message = "ERROR RESETING CREDENTIALS";
                        }
                    } else {
                        status = StatusCode.NO_RECORD_FOUND;
                        message = "USER NOT FOUND";
                    }
                }
            } else {
                status = StatusCode.EMPTY_REQUEST;
                message = "EMPTY REQUEST";
            }
        } catch (Exception ex) {
            status = StatusCode.GENERAL_EXCEPTION;
            message = ex.getMessage();
            ex.printStackTrace();
        } finally {
            resetResponse.setStatus(status);
            resetResponse.setMessage(message);
            if (status.equals(StatusCode.SUCCESSFUL)) {
                resetResponse.setIv(iv);
                resetResponse.setKey(key);
            }
        }
        logger.info(".. leaving reset()");
        return resetResponse;
    }

}
