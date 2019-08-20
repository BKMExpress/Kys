package com.bkm.kys.core.generator;

import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.MerchantAccount;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.core.qr.QrTagMap;
import com.bkm.kys.core.type.QrType;

import java.util.Map;

public class EmvQrGenerator implements QrGenerator {

    @Override
    public Qr generate(Map<String, Object> map) {
        EmvQr emvQr = new EmvQr();
        emvQr.setPayloadIndicator((String) map.get(QrTagMap.emvQrMap.get("00")));
        emvQr.setPointOfInitiation((String) map.get(QrTagMap.emvQrMap.get("01")));
        emvQr.setMerchantAccount((MerchantAccount) map.get(QrTagMap.emvQrMap.get("26")));
        emvQr.setAcquirerSpecific((String) map.get(QrTagMap.emvQrMap.get("28")));
        emvQr.setBaftSpecific((String) map.get(QrTagMap.emvQrMap.get("29")));
        emvQr.setCategoryCode((String) map.get(QrTagMap.emvQrMap.get("52")));
        emvQr.setCurrencyCode((String) map.get(QrTagMap.emvQrMap.get("53")));
        emvQr.setAmount((String) map.get(QrTagMap.emvQrMap.get("54")));
        emvQr.setIndicator((String) map.get(QrTagMap.emvQrMap.get("55")));
        emvQr.setConvenienceFixedFee((String) map.get(QrTagMap.emvQrMap.get("56")));
        emvQr.setConveniencePercentageFee((String) map.get(QrTagMap.emvQrMap.get("57")));
        emvQr.setCountryCode((String) map.get(QrTagMap.emvQrMap.get("58")));
        emvQr.setMerchantName((String) map.get(QrTagMap.emvQrMap.get("59")));
        emvQr.setMerchantCity((String) map.get(QrTagMap.emvQrMap.get("60")));
        emvQr.setPostalCode((String) map.get(QrTagMap.emvQrMap.get("61")));
        emvQr.setAdditionalData((String) map.get(QrTagMap.emvQrMap.get("62")));
        emvQr.setMerchantInfo((String) map.get(QrTagMap.emvQrMap.get("64")));
        emvQr.setCrc((String) map.get(QrTagMap.emvQrMap.get("63")));

        return  emvQr;
    }

}
