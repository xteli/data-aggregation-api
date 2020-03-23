/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.repository;

import com.data.aggr.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chineduojiteli
 */
@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {

    @Query("SELECT client FROM ClientInfo client WHERE client.username = ?1")
    ClientInfo findByUsername(String username);

}
