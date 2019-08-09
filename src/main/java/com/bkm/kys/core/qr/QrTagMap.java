package com.bkm.kys.core.qr;

import java.util.LinkedHashMap;
import java.util.Map;

public class QrTagMap {

    public static Map<String, String> emvQrMap;
    public static Map<String, String> kkfQrMap;
    public static Map<String, String> merchantAccountMap;

    static {
        emvQrMap = new LinkedHashMap<>();
        emvQrMap.put("00","payloadIndicator");
        emvQrMap.put("01","pointOfInitiation");

        emvQrMap.put("26","merchantAccount");
        emvQrMap.put("27","merchantAccount");
        emvQrMap.put("28","merchantAccount");

        emvQrMap.put("52","categoryCode");
        emvQrMap.put("53","currencyCode");
        emvQrMap.put("54","amount");
        emvQrMap.put("55","indicator");
        emvQrMap.put("56","convenienceFixedFee");
        emvQrMap.put("57","conveniencePercentageFee");
        emvQrMap.put("58","countryCode");
        emvQrMap.put("59","merchantName");
        emvQrMap.put("60","merchantCity");
        emvQrMap.put("61","postalCode");
        emvQrMap.put("62","additionalData");
        emvQrMap.put("64","merchantInfo");
        emvQrMap.put("63","crc");

        merchantAccountMap = new LinkedHashMap<>();
        merchantAccountMap.put("26","bitmap26");
        merchantAccountMap.put("01","serialNo");
        merchantAccountMap.put("02","dateTime");
        merchantAccountMap.put("03","qrId");
        merchantAccountMap.put("04","qrGenerator");
        merchantAccountMap.put("05","requestAmount");
        merchantAccountMap.put("06","qrType");
        merchantAccountMap.put("07","terminalType");
        merchantAccountMap.put("27","bitmap27");
        merchantAccountMap.put("08","hash");
        merchantAccountMap.put("09","schemas");
        merchantAccountMap.put("10","brand");
        merchantAccountMap.put("11","instCount");
        merchantAccountMap.put("12","location");
        merchantAccountMap.put("13","rrn");


        kkfQrMap = new LinkedHashMap<>();
        kkfQrMap.put("00","payloadIndicator");
        kkfQrMap.put("01","memberNo");
        kkfQrMap.put("02","qrId");
        kkfQrMap.put("03","hash");
        kkfQrMap.put("04","crc");
    }

    public static String getEmvQrTagNoByName(String tagName) {

        for ( Map.Entry<String, String> entry : emvQrMap.entrySet() ) {
            if ( entry.getValue().equals(tagName) )
                return entry.getKey();
        }

        return null;
    }
}
