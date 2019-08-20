package com.bkm.kys.acquirer;

import com.bkm.kys.model.dto.*;
import com.bkm.kys.service.KysService;
import com.bkm.kys.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kys")
public class KysController {

    @Autowired
    KysService kysService;

    @Autowired
    QrService qrService;

    @RequestMapping(value = {"/getShortQrInfo"}, method = RequestMethod.POST)
    public @ResponseBody
    KkfResponse getShortQrInfo(@RequestBody KkfRequest request) {

        return kysService.getShortQrInfo(request);
    }

    @RequestMapping(value = {"/startQrTransaction"}, method = RequestMethod.POST)
    public @ResponseBody
    QrTrxResponse startQrTransaction(@RequestBody QrTrxRequest request) {

        return kysService.startQrTransaction(request);
    }

    // Bu iki servis ile acquirer kendi ürettiği qr ı simulatore iletebilir

    @RequestMapping(value = {"/getShortQrText"}, method = RequestMethod.GET)
    public @ResponseBody
    String getShortQrText() {

        return qrService.generateKkfQr();
    }

    @RequestMapping(value = {"/getEmvQrText"}, method = RequestMethod.GET)
    public @ResponseBody
    String getEmvQrText() {
        return qrService.generateEmvQr();
    }


}
