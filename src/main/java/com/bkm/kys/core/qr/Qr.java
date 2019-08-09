package com.bkm.kys.core.qr;

import com.bkm.kys.core.type.QrType;

public abstract class Qr {

    protected QrType type;

    public abstract String getQrText();

    public abstract String getQrId();
}
