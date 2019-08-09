package com.bkm.kys.core.qr;

import com.bkm.kys.core.type.QrType;

public class KkfQr extends Qr {

    private String payloadIndicator;
    private String memberNo;
    private String qrId;
    private String hash;
    private String crc;

    public KkfQr() {
        type = QrType.KKF_QR;
    }

    @Override
    public String getQrId(){
        return qrId;
    }


    public String getQrText() {
        StringBuffer sb = new StringBuffer();
        sb.append(payloadIndicator).append(memberNo).append(qrId).append(hash).append(crc);

        return sb.toString();
    }

    public String getPayloadIndicator() {
        return payloadIndicator;
    }

    public void setPayloadIndicator(String payloadIndicator) {
        this.payloadIndicator = payloadIndicator;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }
}
