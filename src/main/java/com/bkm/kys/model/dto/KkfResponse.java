package com.bkm.kys.model.dto;

public class KkfResponse {
    private String messageReferenceNumber;
    private String date;
    private String countryCode;
    private int amountAvailable;
    private int transactionType;
    private int terminalType;
    private String supportedSchema;
    private String supportedBrand;
    private int installmentNumber;
    private String rnn;
    private String amount;
    private int mcc;
    private int currencyCode;
    private String merchantName;
    private String merchantCity;
    private String postalCode;
    private String responseMac;
    private int resultCode;
    private String resultDescription;

    public String getMessageReferenceNumber() {
        return messageReferenceNumber;
    }

    public void setMessageReferenceNumber(String messageReferenceNumber) {
        this.messageReferenceNumber = messageReferenceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public int getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(int terminalType) {
        this.terminalType = terminalType;
    }

    public String getSupportedSchema() {
        return supportedSchema;
    }

    public void setSupportedSchema(String supportedSchema) {
        this.supportedSchema = supportedSchema;
    }

    public String getSupportedBrand() {
        return supportedBrand;
    }

    public void setSupportedBrand(String supportedBrand) {
        this.supportedBrand = supportedBrand;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public String getRnn() {
        return rnn;
    }

    public void setRnn(String rnn) {
        this.rnn = rnn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
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

    public String getResponseMac() {
        return responseMac;
    }

    public void setResponseMac(String responseMac) {
        this.responseMac = responseMac;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }
}
