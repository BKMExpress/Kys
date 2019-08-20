package com.bkm.kys.mobile;

import com.bkm.kys.core.parser.EmvQrParser;
import com.bkm.kys.core.parser.KkfQrParser;
import com.bkm.kys.core.parser.QrParser;
import com.bkm.kys.core.qr.EmvQr;
import com.bkm.kys.core.qr.KkfQr;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.model.dto.*;
import com.bkm.kys.service.RestService;
import com.bkm.kys.service.QrService;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mobile")
public class KysMobileController {

    @Autowired
    QrService qrService;

    private Map<String, String> qrIdTokenMap = new HashMap<>();

    @RequestMapping(value = {"/getMerchantDetails"}, method= RequestMethod.POST)
    public @ResponseBody
    MerchantInfoResponse getMerchantDetails(@RequestBody MerchantInfoRequest request ){

        MerchantInfoResponse response = new MerchantInfoResponse();
        String qrId = null;
        if ( request.getQrText().substring(0,2) .equals("99") ) {
            KkfResponse kkfResponse = qrService.getShortQrInfo(request.getQrText());
            response.setAmount(kkfResponse.getAmount());
            response.setMerchantName(kkfResponse.getMerchantName());

            QrParser parser = new KkfQrParser();
            KkfQr qr = (KkfQr) parser.parse(request.getQrText());
            qrId = qr.getQrId();
        }
        else {
            QrParser parser = new EmvQrParser();
            EmvQr qr = (EmvQr) parser.parse(request.getQrText());
            response.setAmount(qr.getAmount());
            response.setMerchantName(qr.getMerchantName());
            qrId = qr.getQrId();
        }
        response.setCardList(Util.getRandomCardList());
        String token = Util.generateUUID();
        qrIdTokenMap.put(token, qrId);
        response.setToken(qrId);

        return response;
    }

    @RequestMapping(value = {"/doPayment"}, method= RequestMethod.POST)
    public @ResponseBody
    PaymentResponse doPayment(@RequestBody PaymentRequest request ){

        PaymentResponse response = qrService.startQrTransaction(request);

        return response;
    }

}


