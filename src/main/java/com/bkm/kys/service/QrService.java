package com.bkm.kys.service;

import com.bkm.kys.core.generator.KkfQrGenerator;
import com.bkm.kys.core.generator.QrGenerator;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.core.type.QrType;
import com.bkm.kys.domain.KysQr;
import com.bkm.kys.model.dto.*;
import com.bkm.kys.repo.KysQrDao;
import com.bkm.kys.types.Terminal;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class QrService {

    @Autowired
    private KysQrDao qrDao;

    @Autowired
    private RestService restService;


    public KkfResponse getShortQrInfo(String qrText){

        KkfRequest kkfRequest = new KkfRequest();
        kkfRequest.setKkfData(qrText);
        kkfRequest.setMessageReferenceNumber(Util.generateUUID());
        kkfRequest.setIssuerId("0099");
        kkfRequest.setDate(Util.now());
        // TODO
        kkfRequest.setRequestMac("");

        KkfResponse response = restService.getShortQrInfo(kkfRequest);

        return response;
    }

    public PaymentResponse startQrTransaction(PaymentRequest paymentRequest){

        QrTrxRequest qrTrxRequest = new QrTrxRequest();

        QrTrxResponse qrTrxResponse = restService.startQrTransaction(qrTrxRequest);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setResultCode(qrTrxResponse.getResultCode());
        paymentResponse.setResultDesc(qrTrxResponse.getResultDesc());

        return paymentResponse;
    }

    public String generateKkfQr(){

        QrGenerator kkfQrGenerator = new KkfQrGenerator();
        Map<String, Object> map = new HashMap<>();
        map.put("payloadIndicator", "99");
        map.put("memberNo", "0099");
        String qrId = Util.generateQrId();
        map.put("qrId", qrId);
        map.put("hash", Util.hash(qrId));
        map.put("crc", "ABCD");
        Qr generatedKkfQr = kkfQrGenerator.generate(map);

        KysQr kysQr = new KysQr();
        kysQr.setQrId(generatedKkfQr.getQrId());
        kysQr.setQrType(QrType.KKF_QR.toString());
        kysQr.setQrText(generatedKkfQr.getQrText());
        kysQr.setMerchantName(Util.getRandomMerchantName());
        kysQr.setMerchantCity("İSTANBUL");
        kysQr.setAmount(Util.getRandomAmount());
        kysQr.setTerminalType(Terminal.POS.toString());
        kysQr.setInstallmentNumber(0);
        kysQr.setRnn("");
        kysQr.setCreatedDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        qrDao.save(kysQr);

        return generatedKkfQr.getQrText();
    }

    public String generateEmvQr(){

        return null;
    }


}
