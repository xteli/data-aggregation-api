/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chineduojiteli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class DataRequest {

   // @NotNull(message = "Missing Transaction ID")
    private String transID;
   // @NotNull(message = "Missing Source Account Number")
    private String srcAcctNo;
  //  @NotNull(message = "Missing Source Institution Code")
    private String srcInstCode;
//    @NotNull(message = "Missing Source Institution Branch Code")
    private String srcInstBranchCode;
  //  @NotBlank(message = "Missing Source Institution Type")
  //  @Min(value = 1, message = "Valid values : 1 - Individual, 2 - Corporate, 3 - MobileWallet")
 //   @Max(value = 3, message = "Valid values : 1 - Individual, 2 - Corporate, 3 - MobileWallet")
    private int srcInstType;
  //  @NotNull(message = "Missing Source Institution Unique ID")
    private String srcInstUniqueID;
  //  @NotNull(message = "Missing Destination Account Number")
    private String destAcctNo;
  //  @NotNull(message = "Missing Destination Institution Code")
    private String destInstCode;
  //  @NotNull(message = "Missing Destination Institution Branch Code")
    private String destInstBranchCode;
  //  @NotBlank(message = "Missing Destination Institution Type")
  //  @Min(value = 1, message = "Valid values : 1 - Individual, 2 - Corporate, 3 - MobileWallet")
  //  @Max(value = 3, message = "Valid values : 1 - Individual, 2 - Corporate, 3 - MobileWallet")
    private int destInstType;
  //  @NotNull(message = "Missing Destinstion Institution Unique ID")
    private String destInstUniqueID;
 //   @NotBlank(message = "Missing Payment Type")
 //   @Min(value = 1, message = "Valid values : 1 - Card, 2 - Cash, 3 - EFT, 4 - Cheque, 5 -  Others")
 //   @Max(value = 5, message = "Valid values : 1 - Card, 2 - Cash, 3 - EFT, 4 - Cheque, 5 -  Others")
    private int paymentType;
  //  @NotNull(message = "Missing Transaction Date")
    private String transDate;
  //  @NotNull(message = "Missing Amount")
    private String amount;
  //  @NotNull(message = "Missing Fee")
    private String fee;
   // @NotNull(message = "Missing VAT")
    private String vat;
  //  @NotNull(message = "Missing Bank Income")
    private String bankIncome;
  //  @NotNull(message = "Missing PSSP Party")
    private String psspParty;
    private int accountType;
    private int accountClass;
    private int accountDesignation;
    private int currency;
    private int channel;
}
