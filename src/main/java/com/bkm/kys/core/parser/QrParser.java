package com.bkm.kys.core.parser;

import com.bkm.kys.core.qr.Qr;

public interface QrParser {

    Qr parse(String qrText);

}
