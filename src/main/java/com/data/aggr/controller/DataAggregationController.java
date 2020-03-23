/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.controller;

import com.data.aggr.dto.request.DataRequest;
import com.data.aggr.dto.response.DataResponse;
import com.data.aggr.service.DataAggregationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author chineduojiteli
 */
@RestController
@RequestMapping("nibss/dataaggr/api/v1")
@NoArgsConstructor
public class DataAggregationController {
    
    
    DataAggregationService dataAggrService;

    @Autowired
    public DataAggregationController(DataAggregationService dataAggrService) {
        this.dataAggrService = dataAggrService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<String> sendData(@RequestBody String req,@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok(dataAggrService.sendData(req,headers));
    }
    
    
    
}
