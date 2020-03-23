/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.service;

import com.data.aggr.dto.ServiceResponse;
import com.data.aggr.entity.Ping;
import com.data.aggr.repository.PingRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chineduojiteli
 */
@Service
public class PingService {

    ServiceResponse serviceResponse = new ServiceResponse();
    Logger logger = LoggerFactory.getLogger(PingService.class);
    PingRepository pingRepository;

    @Autowired
    public PingService(PingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }
    
    public ServiceResponse pingService() {

        try {
            Optional<Ping> findById = pingRepository.findById(1L);
            if (findById != null && findById.get() != null) {
                Ping ping = findById.get();
                serviceResponse.setStatus(ping.getStatus());
                serviceResponse.setMessage(ping.getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return serviceResponse;
    }
}
