package com.bkm.kys.acquirer;


import com.bkm.kys.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qr")
public class QrController {

    @Autowired
    QrService qrService;

    @RequestMapping(value = {"/generateKkfQr"}, method= RequestMethod.POST)
    public @ResponseBody String generateKkfQr( ){

        String kkfQrText = qrService.generateKkfQr();

        return kkfQrText;
    }

    @RequestMapping(value = {"/generateEmvQr"}, method= RequestMethod.POST)
    public @ResponseBody String generateEmvQr( ){

        String emvQrText = qrService.generateEmvQr();

        return emvQrText;

    }

}
