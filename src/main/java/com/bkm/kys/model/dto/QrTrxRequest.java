package com.bkm.kys.model.dto;

import java.util.Map;

public class QrTrxRequest {

    private String messageReferenceNumber;
    private String issuerId;
    private String acquirerId;
    private String date;
    private String channelCode;
    private String qrData;
    private String encryptedCardData;
    private String cvm;
    private String amount;
    private String pointAmount;
    private String installmentNumber;
    private String eci;
    private String walletId;
    private String assignedId;
    private Map<String, String> issuerSpecific;
    private String locationData;
    private String requestMac;

    public String getMessageReferenceNumber() {
        return messageReferenceNumber;
    }

    public void setMessageReferenceNumber(String messageReferenceNumber) {
        this.messageReferenceNumber = messageReferenceNumber;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }

    public String getEncryptedCardData() {
        return encryptedCardData;
    }

    public void setEncryptedCardData(String encryptedCardData) {
        this.encryptedCardData = encryptedCardData;
    }

    public String getCvm() {
        return cvm;
    }

    public void setCvm(String cvm) {
        this.cvm = cvm;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(String pointAmount) {
        this.pointAmount = pointAmount;
    }

    public String getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(String installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public Map<String, String> getIssuerSpecific() {
        return issuerSpecific;
    }

    public void setIssuerSpecific(Map<String, String> issuerSpecific) {
        this.issuerSpecific = issuerSpecific;
    }

    public String getLocationData() {
        return locationData;
    }

    public void setLocationData(String locationData) {
        this.locationData = locationData;
    }

    public String getRequestMac() {
        return requestMac;
    }

    public void setRequestMac(String requestMac) {
        this.requestMac = requestMac;
    }
}
