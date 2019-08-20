package com.bkm.kys.core.qr;

import com.bkm.kys.core.type.QrType;
import com.bkm.kys.util.Util;

import java.lang.reflect.Field;

public class EmvQr extends Qr {
    private String payloadIndicator;
    private String pointOfInitiation;
    private MerchantAccount merchantAccount;
    private String acquirerSpecific;
    private String baftSpecific;
    private String categoryCode;
    private String currencyCode;
    private String amount;
    private String indicator;
    private String convenienceFixedFee;
    private String conveniencePercentageFee;
    private String countryCode;
    private String merchantName;
    private String merchantCity;
    private String postalCode;
    private String additionalData;
    private String merchantInfo;
    private String crc;

    public EmvQr() {
        type = QrType.EMV_QR;
        merchantAccount = new MerchantAccount();
    }

    @Override
    public String getQrId(){
        return merchantAccount.getQrId();
    }


    private String emvQrDataObject(String tag, String value) {
        if (Util.isEmptyString(value) )
            return "";

        StringBuffer sb = new StringBuffer();
        String tagNo = QrTagMap.getEmvQrTagNoByName(tag);

        sb.append(tagNo);
        sb.append(value.length());
        sb.append(value);

        String res = sb.toString() ;

        return res != null ? res : "";
    }

    public String getQrText() {
        StringBuffer sb = new StringBuffer();

        sb.append(emvQrDataObject("payloadIndicator", payloadIndicator));
        sb.append(emvQrDataObject("pointOfInitiation", pointOfInitiation));
        sb.append(emvQrDataObject("merchantAccount", merchantAccount.toString()));
        sb.append(emvQrDataObject("acquirerSpecific", acquirerSpecific));
        sb.append(emvQrDataObject("baftSpecific", baftSpecific));
        sb.append(emvQrDataObject("categoryCode", categoryCode));
        sb.append(emvQrDataObject("currencyCode", currencyCode));
        sb.append(emvQrDataObject("amount", amount));
        sb.append(emvQrDataObject("indicator", indicator));
        sb.append(emvQrDataObject("convenienceFixedFee", convenienceFixedFee));
        sb.append(emvQrDataObject("conveniencePercentageFee", conveniencePercentageFee));
        sb.append(emvQrDataObject("countryCode", countryCode));
        sb.append(emvQrDataObject("merchantName", merchantName));
        sb.append(emvQrDataObject("merchantCity", merchantCity));
        sb.append(emvQrDataObject("postalCode", postalCode));
        sb.append(emvQrDataObject("merchantInfo", merchantInfo));
        sb.append(emvQrDataObject("crc", crc));

        return sb.toString();
    }

    public void setField(QrEmvTag qrEmvTag) {
        String fieldName = QrTagMap.emvQrMap.get(qrEmvTag.getTagNo());
        try {
            Field field = EmvQr.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            if (  Integer.valueOf(qrEmvTag.getTagNo()) >= 26 && Integer.valueOf(qrEmvTag.getTagNo()) <= 27 )
                merchantAccount.setField(qrEmvTag);
            else
                field.set(this, qrEmvTag.getValue());

        } catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return;

    }

    public String getPayloadIndicator() {
        return payloadIndicator;
    }

    public void setPayloadIndicator(String payloadIndicator) {
        this.payloadIndicator = payloadIndicator;
    }

    public String getPointOfInitiation() {
        return pointOfInitiation;
    }

    public void setPointOfInitiation(String pointOfInitiation) {
        this.pointOfInitiation = pointOfInitiation;
    }

    public MerchantAccount getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(MerchantAccount merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getConvenienceFixedFee() {
        return convenienceFixedFee;
    }

    public void setConvenienceFixedFee(String convenienceFixedFee) {
        this.convenienceFixedFee = convenienceFixedFee;
    }

    public String getConveniencePercentageFee() {
        return conveniencePercentageFee;
    }

    public void setConveniencePercentageFee(String conveniencePercentageFee) {
        this.conveniencePercentageFee = conveniencePercentageFee;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCity() {
        return merchantCity;
    }

    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(String merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
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
