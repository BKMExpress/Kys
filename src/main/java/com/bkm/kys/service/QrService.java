package com.bkm.kys.service;

import com.bkm.kys.core.generator.EmvQrGenerator;
import com.bkm.kys.core.generator.KkfQrGenerator;
import com.bkm.kys.core.generator.QrGenerator;
import com.bkm.kys.core.parser.EmvQrParser;
import com.bkm.kys.core.parser.KkfQrParser;
import com.bkm.kys.core.parser.QrParser;
import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.KkfQr;
import com.bkm.kys.core.qr.MerchantAccount;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.core.type.QrType;
import com.bkm.kys.domain.KysQr;
import com.bkm.kys.model.dto.*;
import com.bkm.kys.repo.KysQrDao;
import com.bkm.kys.types.Terminal;
import com.bkm.kys.util.Constant;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
        String qrText = paymentRequest.getQrText();
        if ( qrText.substring(0,2) .equals("99") ) { // KKF
            QrParser parser = new KkfQrParser();
            KkfQr qr = (KkfQr) parser.parse(qrText);
            qrTrxRequest.setAcquirerId(qr.getMemberNo());
        }
        else { // EMV
            QrParser parser = new EmvQrParser();
            EmvQr qr = (EmvQr) parser.parse(qrText);
            qrTrxRequest.setAcquirerId(qr.getMerchantAccount().getQrGenerator());
        }
        // TODO burada qrTrxRequest alanları setlenmeli
        CardInfo cardInfo = Constant.cardInfoMap.get( paymentRequest.getCardId() );
        qrTrxRequest.setMessageReferenceNumber(Util.generateUUID());
        qrTrxRequest.setIssuerId(paymentRequest.getIssuerId() == null ? "0099" : paymentRequest.getIssuerId());
        qrTrxRequest.setDate(Util.now());
        qrTrxRequest.setQrData(paymentRequest.getQrText());
        qrTrxRequest.setEncryptedCardData(Util.getEncryptedData(cardInfo));
        qrTrxRequest.setCvm("31");
        qrTrxRequest.setAmount(paymentRequest.getAmount());
        qrTrxRequest.setPointAmount(null);
        qrTrxRequest.setInstallmentNumber(null);
        qrTrxRequest.setEci("412");
        // TODO bunlar değişebilir
        qrTrxRequest.setWalletId("001");
        qrTrxRequest.setAssignedId("000001");
        qrTrxRequest.setIssuerSpecific(null);
        qrTrxRequest.setLocationData(paymentRequest.getLocationData() != null ? paymentRequest.getLocationData() : "410774290266");

        // TODO
        qrTrxRequest.setRequestMac("");

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

        String payloadIndicator = "01";
        String pointOfInitiation = "01";
        MerchantAccount merchantAccount;
        String acquirerSpecific = "acquirer ozel bilgi";
        String baftSpecific = "baft";
        String categoryCode = "12";
        String currencyCode = "949";
        BigDecimal amount  = Util.getRandomAmount();
        String indicator = "1234";
        String convenienceFixedFee = null;
        String conveniencePercentageFee = null;
        String countryCode = "949";
        String merchantName = Util.getRandomMerchantName();
        String merchantCity = "İSTANBUL";
        String postalCode = "34500";
        String additionalData = "additional";
        String merchantInfo = "commercial";
        String crc = "ABCD";

        merchantAccount = new MerchantAccount();
        String qrId = Util.generateQrId();
        merchantAccount.setQrId(qrId);
        merchantAccount.setSerialNo("12");
        merchantAccount.setDateTime(Util.now());
        merchantAccount.setQrGenerator("11");
        merchantAccount.setRequestAmount(amount.toString());
        merchantAccount.setQrType("1");
        merchantAccount.setTerminalType(Terminal.POS.toString());
        merchantAccount.setBitmap26(); // automatically sets bitmap

        merchantAccount.setSchemas("TDVMAUJ000");
        merchantAccount.setBrand("N");
        merchantAccount.setInstCount(null);
        merchantAccount.setLocation("26451820");
        merchantAccount.setRrn(null);
        merchantAccount.setHash(Util.hash(qrId));
        merchantAccount.setBitmap27();// automatically sets bitmap checks not empty fields




        QrGenerator emvQrGenerator = new EmvQrGenerator();
        Map<String, Object> map = new HashMap<>();
        map.put("payloadIndicator", payloadIndicator);
        map.put("pointOfInitiation", pointOfInitiation);
        map.put("merchantAccount", merchantAccount);
        map.put("acquirerSpecific", acquirerSpecific);
        map.put("baftSpecific", baftSpecific);
        map.put("categoryCode", categoryCode);
        map.put("currencyCode", currencyCode);
        map.put("amount", amount.toString());
        map.put("indicator", indicator);
        map.put("countryCode", countryCode);
        map.put("convenienceFixedFee", convenienceFixedFee);
        map.put("conveniencePercentageFee", conveniencePercentageFee);
        map.put("merchantName", merchantName);
        map.put("merchantCity", merchantCity);
        map.put("postalCode", postalCode);
        map.put("additionalData", additionalData);
        map.put("merchantInfo", merchantInfo);

        map.put("crc", crc);

        Qr generatedKkfQr = emvQrGenerator.generate(map);

        KysQr kysQr = new KysQr();
        kysQr.setQrId(merchantAccount.getQrId());
        kysQr.setQrType(QrType.EMV_QR.toString());
        kysQr.setQrText(generatedKkfQr.getQrText());
        kysQr.setMerchantName(merchantName);
        kysQr.setMerchantCity(merchantCity);
        kysQr.setAmount(amount);
        kysQr.setTerminalType(merchantAccount.getTerminalType());
        kysQr.setInstallmentNumber(merchantAccount.getInstCount() == null ? 0 : Integer.valueOf(merchantAccount.getInstCount()));
        kysQr.setRnn(merchantAccount.getRrn());
        kysQr.setCreatedDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        qrDao.save(kysQr);

        return generatedKkfQr.getQrText();
    }


}
