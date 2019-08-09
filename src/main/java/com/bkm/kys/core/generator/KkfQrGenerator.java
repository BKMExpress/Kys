package com.bkm.kys.core.generator;

import com.bkm.kys.core.qr.KkfQr;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.core.qr.QrTagMap;

import java.util.Map;

public class KkfQrGenerator implements QrGenerator {

    @Override
    public Qr generate(Map<String, Object> map) {
        KkfQr kkfQr = new KkfQr();
        kkfQr.setPayloadIndicator((String) map.get(QrTagMap.kkfQrMap.get("00")));
        kkfQr.setMemberNo((String) map.get(QrTagMap.kkfQrMap.get("01")));
        kkfQr.setQrId((String) map.get(QrTagMap.kkfQrMap.get("02")));
        kkfQr.setHash((String) map.get(QrTagMap.kkfQrMap.get("03")));
        kkfQr.setCrc((String) map.get(QrTagMap.kkfQrMap.get("04")));

        return kkfQr;
    }



}
