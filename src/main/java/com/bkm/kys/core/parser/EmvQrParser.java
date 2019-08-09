package com.bkm.kys.core.parser;

import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.core.qr.QrEmvTag;

public class EmvQrParser implements QrParser{

    @Override
    public Qr parse(String qrText) {
        EmvQr emvQr = new EmvQr();

        QrTextIterator iterator = new EmvQrTextIterator(qrText);
        while ( iterator.hasNext() ) {
            QrEmvTag qrEmvTag = iterator.next();
            System.out.println(qrEmvTag);
            emvQr.setField(qrEmvTag);
        }

        return emvQr;
    }

}
