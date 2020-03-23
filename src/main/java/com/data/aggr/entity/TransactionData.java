/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.entity;

import com.data.aggr.util.DateJsonUtil;
import com.data.aggr.util.Enum.AccountClass;
import com.data.aggr.util.Enum.AccountDesignation;
import com.data.aggr.util.Enum.AccountType;
import com.data.aggr.util.Enum.Channel;
import com.data.aggr.util.Enum.Currency;
import com.data.aggr.util.Enum.InstitutionType;
import com.data.aggr.util.Enum.PaymentType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "transactiondata")
@Getter
@Setter
public class TransactionData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "request_id", nullable = false)
    private String requestID;
    @Column(name = "transaction_id", nullable = false)
    private String transactionID;

    //sender institution information
    @Column(name = "sender_account_number", nullable = false)
    private String senderAccountNumber;
    @Column(name = "sender_institution_code", nullable = false)
    private String senderInstCode;
    @Column(name = "sender_institution_branch_code", nullable = false)
    private String senderInstBranchCode;
    @Column(name = "sender_institution_type", nullable = false)
    private InstitutionType senderInstitutionType;
    @Column(name = "sender_institution_unique_id", nullable = false)
    private String senderInstitutionUniqueID;

    //receiving institution information
    @Column(name = "receiving_account_number", nullable = false)
    private String receivingAccountNumber;
    @Column(name = "receiving_institution_code", nullable = false)
    private String receivingInstCode;
    @Column(name = "receiving_institution_branch_code", nullable = false)
    private String receivingInstBranchCode;
    @Column(name = "receiving_institution_type", nullable = false)
    private InstitutionType receivingInstitutionType;
    @Column(name = "receiving_institution_unique_id", nullable = false)
    private String receivingInstitutionUniqueID;

    //other parameters
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;
    @Column(name = "transaction_date", nullable = false, columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonSerialize(using = DateJsonUtil.class)
    private Date transactionDate;
    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;
    @Column(name = "transaction_fee", nullable = true)
    private BigDecimal transactionFee;
    @Column(name = "transaction_vat", nullable = true)
    private BigDecimal transactionVAT;
    @Column(name = "actual_bank_income", nullable = true)
    private BigDecimal actualBankIncome;
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;
    @Column(name = "account_class", nullable = false)
    private AccountClass accountClass;
    @Column(name = "shared_pssp_party", nullable = false)
    private String sharedPSSPParty;
    @Column(name = "account_desgination", nullable = false)
    private AccountDesignation accountDesignation;
    @Column(name = "currency", nullable = false)
    private Currency currency;
    @Column(name = "channel", nullable = false)
    private Channel channel;

    //system date
    @Column(name = "system_date", nullable = false, columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonSerialize(using = DateJsonUtil.class)
    private Date systemDate;
}
