package com.bkm.kys.core.generator;

import com.bkm.kys.core.qr.Qr;

import java.util.Map;

public interface QrGenerator {

    Qr generate(Map<String, Object> map);

}
