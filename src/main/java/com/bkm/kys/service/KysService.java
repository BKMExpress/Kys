package com.bkm.kys.service;

import com.bkm.kys.core.parser.EmvQrParser;
import com.bkm.kys.core.parser.KkfQrParser;
import com.bkm.kys.core.parser.QrParser;
import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.KkfQr;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.domain.KysQr;
import com.bkm.kys.domain.KysQrDetail;
import com.bkm.kys.model.dto.KkfRequest;
import com.bkm.kys.model.dto.KkfResponse;
import com.bkm.kys.model.dto.QrTrxRequest;
import com.bkm.kys.model.dto.QrTrxResponse;
import com.bkm.kys.repo.KysQrDao;
import com.bkm.kys.repo.KysQrDetailDao;
import com.bkm.kys.types.Terminal;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KysService {

    @Autowired
    private KysQrDao kysQrDao;

    @Autowired
    private KysQrDetailDao kysQrDetailDao;

    // Acquirer ın oluşturduğu KKFQR için detay dönülen acquirer ın BKM ye açacağı servisin alt detay örneği
    public KkfResponse getShortQrInfo(KkfRequest request){
        KkfResponse kkfResponse = new KkfResponse();
        QrParser parser = new KkfQrParser();
        Qr qr = parser.parse(request.getKkfData());

        KysQr kysQr = kysQrDao.findByQrId(qr.getQrId());
        kkfResponse.setMessageReferenceNumber(Util.generateUUID());
        kkfResponse.setDate(Util.formatDate(kysQr.getCreatedDate()));
        kkfResponse.setCountryCode("TR");
        kkfResponse.setAmountAvailable(1);
        kkfResponse.setTransactionType(1);
        kkfResponse.setTerminalType(Terminal.POS.getTerminalType(kysQr.getTerminalType()));
        kkfResponse.setSupportedSchema("TDVMAUJ000");
        kkfResponse.setSupportedBrand("N");
        kkfResponse.setInstallmentNumber(null);
        kkfResponse.setRnn(kysQr.getRnn());
        kkfResponse.setMcc(5411);
        kkfResponse.setCurrencyCode(949);
        kkfResponse.setAmount(kysQr.getAmount().toString());
        kkfResponse.setMerchantName(kysQr.getMerchantName());
        kkfResponse.setMerchantCity(kysQr.getMerchantCity());
        kkfResponse.setPostalCode("34300");
        kkfResponse.setResultCode(0);
        kkfResponse.setResultDescription("SUCCESS");

        // TODO
        kkfResponse.setResponseMac("");


        return kkfResponse;
    }

    // Acquirer ın oluşturduğu EMVQR veya KKFQR için issuerın 16 hane kart bilgisi ve SKT gibi kart bilgilerini
    // acquirer a iletmek için acquirer ın BKM ye açacağı servisin alt detay örneği
    public QrTrxResponse startQrTransaction(QrTrxRequest request){
        QrTrxResponse qrTrxResponse = new QrTrxResponse();
        // acquirer işlem tipini anlamalı
        String qrId;
        if ( request.getQrData().substring(0,2) .equals("99") ) {
            QrParser parser = new KkfQrParser();
            KkfQr qr = (KkfQr) parser.parse(request.getQrData());
            qrId = qr.getQrId();
        }
        else {
            QrParser parser = new EmvQrParser();
            EmvQr qr = (EmvQr) parser.parse(request.getQrData());
            qrId = qr.getQrId();
        }

        // TODO
        /*
        işlem bitirdi
        tablodan işlem check edilecek

        tablo update yada insert edilecek

        private String messageReferenceNumber;
        private String issuerId;
        private String acquirerId;
        private String date;
        private String channelCode;
        private String qrData;
        private String encryptedCardData;
        private String cvm;
        private String amount;
        private String pointAmount;
        private String installmentNumber;
        private String eci;
        private String walletId;
        private String assignedId;
        private Map<String, String> issuerSpecific;
        private String locationData;
        private String requestMac;

        */

        return null;
    }


}
