package com.bkm.kys.model.dto;

public class Card {
    private String cardId;
    private String first6;
    private String last4;
    private String pan;
    private String owner;
    private String cardImageUrl;


    public Card(String cardId, String first6, String last4) {
        this.cardId = cardId;
        this.first6 = first6;
        this.last4 = last4;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getFirst6() {
        return first6;
    }

    public void setFirst6(String first6) {
        this.first6 = first6;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }


}
