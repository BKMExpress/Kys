package com.bkm.kys.util;

import com.bkm.kys.model.dto.Card;
import com.google.common.hash.Hashing;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Util {
    public static String generateUUID() {

        return UUID.randomUUID().toString();
    }

    public static String now() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");

        return now.format(formatter);
    }

    public static String formatDate(Date date) {
        return date.toString();
    }

    public static String generateQrId() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");

        return now.format(formatter);
    }

    public static String hash(String qrId) {
        String sha256hex = Hashing.sha256().hashString(qrId, StandardCharsets.UTF_8).toString();

        return sha256hex;
    }

    public static boolean isEmptyString(String str) {
        if ( str == null || str.length() == 0)
            return true;

        return false;
    }

    public static String getRandomMerchantName(){

        return Constant.merchantMap.get( (int) ( Math.random() * Constant.merchantMap.size()));
    }

    public static List<Card> getRandomCardList() {
        List<Card> cardList = new ArrayList<>();
        for (Map.Entry<String, Card> cardEntry : Constant.cardMap.entrySet() ) {
            Card card = cardEntry.getValue();
            cardList.add(card);
        }

        return cardList;
    }


    public static BigDecimal getRandomAmount(){
        double random = Math.random() * 100 ;
        BigDecimal amount = new BigDecimal(random).setScale(2,BigDecimal.ROUND_DOWN);
        return amount;
    }

}
