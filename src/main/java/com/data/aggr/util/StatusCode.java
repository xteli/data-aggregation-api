/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.util;

/**
 *
 * @author cojiteli
 */
public interface StatusCode {

    public final String SUCCESSFUL = "00";
    public final String EMPTY_REQUEST = "01";
    public final String FAILED = "02";

    //error codes due to json related exceptions
    public final String JSON_GENERATION_EXCEPTION = "10";
    public final String JSON_MAPPING_EXCEPTION = "11";

    //error codes due to invalid parameters
    public final String MISSING_PARAMETERS = "30";
    public final String INVALID_USER = "32";

    //error codes due to record not found
    public final String NO_RECORD_FOUND = "40";

    //error codes due to general exceptions
    public final String DATABASE_EXCEPTION = "50";
    public final String GENERAL_EXCEPTION = "51";
    public final String NOTIFICATION_EXCEPTION = "52";
    public final String DUPLICATE_EXCEPTION = "53";

    //error codes due to violations
    public final String CONSTRAINT_VIOLATION = "60";
    public final String SECURITY_VIOLATION = "61";


}
