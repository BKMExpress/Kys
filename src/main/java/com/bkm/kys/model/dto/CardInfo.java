package com.bkm.kys.model.dto;

public class CardInfo {
    private String pan;
    private String lastUsageDate;
    private String encryptedCardData;

    public CardInfo(String pan, String lastUsageDate) {
        this.pan = pan;
        this.lastUsageDate = lastUsageDate;
        // this.encryptedCardData = encrypt();
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getLastUsageDate() {
        return lastUsageDate;
    }

    public void setLastUsageDate(String lastUsageDate) {
        this.lastUsageDate = lastUsageDate;
    }

    public String getEncryptedCardData() {
        return encryptedCardData;
    }

    public void setEncryptedCardData(String encryptedCardData) {
        this.encryptedCardData = encryptedCardData;
    }
}
