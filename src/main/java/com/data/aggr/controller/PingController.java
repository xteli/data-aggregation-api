/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.controller;

import com.data.aggr.dto.ServiceResponse;
import com.data.aggr.service.PingService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chineduojiteli
 */
@RestController
@RequestMapping("nibss/dataaggr")
@NoArgsConstructor
public class PingController {
    
    PingService pingService;

    @Autowired
    public PingController(PingService pingService) {
        this.pingService = pingService;
    }
    
    /**
     * Ping the service
     *
     * @return
     */
    @RequestMapping(value = "/ping",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ServiceResponse> ping() {
        return ResponseEntity.ok(pingService.pingService());
    }
}
