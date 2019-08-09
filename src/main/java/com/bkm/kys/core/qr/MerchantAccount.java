package com.bkm.kys.core.qr;

import com.bkm.kys.util.Util;

import java.lang.reflect.Field;
import java.util.List;

public class MerchantAccount {
    private String qrId;
    private String bitmap26;
    private String serialNo;
    private String dateTime;
    private String qrGenerator;
    private String requestAmount;
    private String qrType;
    private String terminalType;
    private String bitmap27;
    private String hash;
    private String schemas;
    private String brand;
    private String instCount;
    private String location;
    private String rrn;
    private String acquirerSpecific;
    private String baftSpecific;

    public void setField(QrEmvTag qrEmvTag){
        List<QrEmvTag> list = qrEmvTag.getSubTagList();

        for ( int i = 0 ; i < list.size() ; i ++ ) {
            QrEmvTag subTag = list.get(i);
            String fieldName ;
            if ( subTag.getTagNo().equals("00"))
               fieldName = QrTagMap.merchantAccountMap.get(qrEmvTag.getTagNo());
            else
               fieldName = QrTagMap.merchantAccountMap.get(subTag.getTagNo());

            try {
                Field field = MerchantAccount.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, subTag.getValue());
            } catch(Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        return;
    }

    public String getBitmap26() {
        return bitmap26;
    }

    public void setBitmap26() {

        int bitmap = 0;
        if ( ! Util.isEmptyString(this.serialNo) )
            bitmap |= 128 ;
        if ( ! Util.isEmptyString(this.dateTime ))
            bitmap |=  64 ;
        if ( ! Util.isEmptyString(this.qrId ))
            bitmap |=  32 ;
        if ( ! Util.isEmptyString(this.qrGenerator ))
            bitmap |=  16 ;
        if ( ! Util.isEmptyString(this.requestAmount ))
            bitmap |=  8 ;
        if ( ! Util.isEmptyString(this.qrType ))
            bitmap |=  4 ;
        if ( ! Util.isEmptyString(this.terminalType ))
            bitmap |= 2 ;
        String rightHalfBitmap = "00";
        this.bitmap26 = Integer.toHexString(bitmap).toUpperCase() + rightHalfBitmap;

        return;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getQrGenerator() {
        return qrGenerator;
    }

    public void setQrGenerator(String qrGenerator) {
        this.qrGenerator = qrGenerator;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getQrType() {
        return qrType;
    }

    public void setQrType(String qrType) {
        this.qrType = qrType;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getBitmap27() {
        return bitmap27;
    }

    public void setBitmap27() {

        int bitmap = 0;
        if ( ! Util.isEmptyString(this.schemas) )
            bitmap |= 128 ;
        if ( ! Util.isEmptyString(this.brand ))
            bitmap |=  64 ;
        if ( ! Util.isEmptyString(this.instCount ))
            bitmap |=  32 ;
        if ( ! Util.isEmptyString(this.location ))
            bitmap |=  16 ;
        if ( ! Util.isEmptyString(this.rrn))
            bitmap |=  8 ;

        String leftHalfBitmap = Util.isEmptyString(this.hash) ? "00" : "01";
        this.bitmap27 = leftHalfBitmap + Integer.toHexString(bitmap).toUpperCase() ;

        return;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSchemas() {
        return schemas;
    }

    public void setSchemas(String schemas) {
        this.schemas = schemas;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInstCount() {
        return instCount;
    }

    public void setInstCount(String instCount) {
        this.instCount = instCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getAcquirerSpecific() {
        return acquirerSpecific;
    }

    public void setAcquirerSpecific(String acquirerSpecific) {
        this.acquirerSpecific = acquirerSpecific;
    }

    public String getBaftSpecific() {
        return baftSpecific;
    }

    public void setBaftSpecific(String baftSpecific) {
        this.baftSpecific = baftSpecific;
    }
}
