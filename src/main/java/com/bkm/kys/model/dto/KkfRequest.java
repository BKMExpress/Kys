package com.bkm.kys.model.dto;

public class KkfRequest {
    private String kkfData;
    private String messageReferenceNumber;
    private String issuerId;
    private String date;
    private String requestMac;

    public String getKkfData() {
        return kkfData;
    }

    public void setKkfData(String kkfData) {
        this.kkfData = kkfData;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequestMac() {
        return requestMac;
    }

    public void setRequestMac(String requestMac) {
        this.requestMac = requestMac;
    }
}
