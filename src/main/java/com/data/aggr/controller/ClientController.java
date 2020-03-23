/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.controller;

import com.data.aggr.dto.request.ResetRequest;
import com.data.aggr.dto.response.ResetResponse;
import com.data.aggr.service.ClientInfoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chineduojiteli
 */
@RestController
@RequestMapping("nibss/dataaggr/api/v1")
@NoArgsConstructor
public class ClientController {

    ClientInfoService clientInfoService;

    @Autowired
    public ClientController(ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResetResponse> reset(@RequestBody ResetRequest resetRequest) {
        
        return ResponseEntity.ok(clientInfoService.reset(resetRequest));
    }
    
   
}
