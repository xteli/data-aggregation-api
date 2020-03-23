/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xteli
 */
public class Enum {

    public enum LifespanType {

        Second(0),
        Minute(1),
        Hour(2),
        Day(3),
        Month(4),
        Year(5);

        private int enumValue;

        LifespanType(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {

            return enumValue;
        }

    }

    public enum InstitutionType {

        Nil(0),
        Individual(1),
        Corporate(2),
        MobileWallet(3);

        private int enumValue;

        InstitutionType(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, InstitutionType> iTypeMap = new HashMap<>();

        static {
            for (InstitutionType iType : InstitutionType.values()) {
                iTypeMap.put(iType.enumValue, iType);
            }
        }

        public static InstitutionType toEnum(int i) {
            InstitutionType iType = iTypeMap.get(i);
            return iType;
        }

    }

    public enum PaymentType {

        NIL(0),
        CARD(1),
        CASH(2),
        EFT(3),
        CHEQUE(4),
        OTHERS(5);

        private int enumValue;

        PaymentType(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, PaymentType> pTypeMap = new HashMap<>();

        static {
            for (PaymentType pType : PaymentType.values()) {
                pTypeMap.put(pType.enumValue, pType);
            }
        }

        public static PaymentType toEnum(int i) {
            PaymentType pType = pTypeMap.get(i);
            return pType;
        }

    }

    public enum AccountType {

        NIL(0),
        CURRENT(1),
        SAVINGS(2),
        DOMICIALIARY(3),
        INTERNAL(4);

        private int enumValue;

        AccountType(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, AccountType> aTypeMap = new HashMap<>();

        static {
            for (AccountType aType : AccountType.values()) {
                aTypeMap.put(aType.enumValue, aType);
            }
        }

        public static AccountType toEnum(int i) {
            AccountType aType = aTypeMap.get(i);
            return aType;
        }

    }

    public enum AccountClass {

        NIL(0),
        DIPLOMATICCORPS(1),
        COLLECTION(2),
        FTZE(3),
        SALARY(4),
        OTHERS(5);

        private int enumValue;

        AccountClass(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, AccountClass> aClassMap = new HashMap<>();

        static {
            for (AccountClass aClass : AccountClass.values()) {
                aClassMap.put(aClass.enumValue, aClass);
            }
        }

        public static AccountClass toEnum(int i) {
            AccountClass aClass = aClassMap.get(i);
            return aClass;
        }

    }

    public enum Currency {

        NIL(0),
        Naira(1),
        Dollars(2),
        Euro(3),
        GBP(4),
        Yuan(5),
        Others(6);

        private int enumValue;

        Currency(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, Currency> currencyMap = new HashMap<>();

        static {
            for (Currency cur : Currency.values()) {
                currencyMap.put(cur.enumValue, cur);
            }
        }

        public static Currency toEnum(int i) {
            Currency cur = currencyMap.get(i);
            return cur;
        }

    }

    public enum AccountDesignation {

        NIL(0),
        Individual(1),
        Corporate(2),
        Joint(3),
        Juvenile(4),
        Others(5);

        private int enumValue;

        AccountDesignation(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, AccountDesignation> designationMap = new HashMap<>();

        static {
            for (AccountDesignation ds : AccountDesignation.values()) {
                designationMap.put(ds.enumValue, ds);
            }
        }

        public static AccountDesignation toEnum(int i) {
            AccountDesignation ds = designationMap.get(i);
            return ds;
        }

    }

    public enum Channel {

        NIL(0),
        BankBranch(1),
        ATM(2),
        POS(3),
        Agent(4),
        Web(5),
        MobileApp(6),
        USSD(7),
        Kiosk(8);

        private int enumValue;

        Channel(int enumValue) {
            this.enumValue = enumValue;
        }

        public int getEnumValue() {
            return enumValue;
        }

        private static final Map<Integer, Channel> channelMap = new HashMap<>();

        static {
            for (Channel channel : Channel.values()) {
                channelMap.put(channel.enumValue, channel);
            }
        }

        public static Channel toEnum(int i) {
            Channel channel = channelMap.get(i);
            return channel;
        }

    }

}
