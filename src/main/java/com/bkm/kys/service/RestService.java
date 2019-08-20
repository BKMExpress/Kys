package com.bkm.kys.service;

import com.bkm.kys.model.dto.*;
import com.bkm.kys.util.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestService {

    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

    public KkfResponse getShortQrInfo(KkfRequest kkfRequest) {

        RestTemplate restTemplate = new RestTemplate();

        KkfResponse response = restTemplate.postForObject(Constant.bkmGetShortQrInfoUrl, kkfRequest, KkfResponse.class);

        return response;

    }

    public QrTrxResponse startQrTransaction(QrTrxRequest qrTrxRequest) {

        RestTemplate restTemplate = new RestTemplate();

        QrTrxResponse response = restTemplate.postForObject(Constant.bkmStartTransactionUrl, qrTrxRequest, QrTrxResponse.class);

        return response;

    }
/*
    public static HttpEntity<String> getEntityForRestTemplate(Object request) {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        String requestJson = gson.toJson(request);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        return entity;
    }
*/

}
