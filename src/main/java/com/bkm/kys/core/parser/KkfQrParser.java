package com.bkm.kys.core.parser;

import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.KkfQr;
import com.bkm.kys.core.qr.Qr;

public class KkfQrParser  implements  QrParser {

    @Override
    public Qr parse(String qrText) {
        KkfQr kkfQr = new KkfQr();

        kkfQr.setPayloadIndicator(qrText.substring(0, 2));
        kkfQr.setMemberNo(qrText.substring(2, 6));
        kkfQr.setQrId(qrText.substring(6, 18));
        kkfQr.setHash(qrText.substring(18, 50));
        kkfQr.setCrc(qrText.substring(50, 54));

        return kkfQr;
    }
}
