package com.bkm.kys.service;

import com.bkm.kys.core.parser.KkfQrParser;
import com.bkm.kys.core.parser.QrParser;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.domain.KysQr;
import com.bkm.kys.model.dto.KkfRequest;
import com.bkm.kys.model.dto.KkfResponse;
import com.bkm.kys.model.dto.QrTrxRequest;
import com.bkm.kys.model.dto.QrTrxResponse;
import com.bkm.kys.repo.KysQrDao;
import com.bkm.kys.types.Terminal;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KysService {

    @Autowired
    private KysQrDao kysQrDao;

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
        kkfResponse.setInstallmentNumber(0);
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

    public QrTrxResponse startQrTransaction(QrTrxRequest request){

        //restTemplate.callBkm;

        return null;
    }


}
