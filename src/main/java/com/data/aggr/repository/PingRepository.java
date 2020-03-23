/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.repository;

import com.data.aggr.entity.Ping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chineduojiteli
 */
@Repository
public interface PingRepository extends JpaRepository<Ping, Long>{
    
}
