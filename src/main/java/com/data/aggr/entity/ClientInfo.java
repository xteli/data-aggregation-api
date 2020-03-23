/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chineduojiteli
 */
@Entity
@Table(name = "clientinfo")
@Getter
@Setter
//@NamedQueries({
//    @NamedQuery(name = "ClientInfo.findByUsername", query = "SELECT client FROM ClientInfo client where client.username=?1")
//})
public class ClientInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = true)
    private String email;
    @Column(name = "client_name", nullable = true)
    private String clientName;
    @Column(name = "active", nullable = false)
    private boolean active = true;
   // @JsonProperty("iv")
    @Column(name = "password", nullable = true)
    private String password;
   // @JsonProperty("key")
    @Column(name = "token", nullable = true)
    private String token;
//    @Column(name = "lifespan", nullable = false)
//    private int lifespan;
//    @Column(name = "lifespantype", nullable = false)
//    private LifespanType lifespanType;
    @Column(name = "date_created", nullable = false, columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "date_modified", nullable = true, columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateModified;

   
}
