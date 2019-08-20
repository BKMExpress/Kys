package com.bkm.kys.util;

import com.bkm.kys.model.dto.Card;
import com.bkm.kys.model.dto.CardInfo;

import java.util.*;

public class Constant {

    public static final String bkmGetShortQrInfoUrl = "http://localhost:8080/kys/getShortQrInfo";
    public static final String bkmStartTransactionUrl = "http://localhost:8080/kys/startQrTransaction";

    public static Map<Integer, String> merchantMap = new HashMap<>();
    public static Map<String, Card> cardMap = new HashMap<>();
    public static Map<String, CardInfo> cardInfoMap = new LinkedHashMap<>();
    static {
        merchantMap.put(0, "Thy");
        merchantMap.put(1, "n11");
        merchantMap.put(2, "Getir");
        merchantMap.put(3, "BiTaksi");
        merchantMap.put(4, "Morphipo");
        merchantMap.put(5, "Gitti Gidiyor");
    }

    static {
        Card card1 = new Card(Util.generateUUID(),"537058","1456");
        card1.setCardImageUrl("https://img-bkmexpress.mncdn.com/BexpLogos/banks/mobil/53705800_CFM&SClassicMaster.png");
        cardMap.put(card1.getCardId(), card1);
        CardInfo cardInfo1 = new CardInfo( "5370582852121456", "1125");
        cardInfoMap.put(card1.getCardId(), cardInfo1);

        Card card2 = new Card(Util.generateUUID(),"428220","2016");
        card2.setCardImageUrl("https://img-bkmexpress.mncdn.com/BexpLogos/banks/mobil/AkbankAxessPlatinum.png");
        cardMap.put(card2.getCardId(), card2);
        CardInfo cardInfo2 = new CardInfo( "4282209027132016", "0520");
        cardInfoMap.put(card2.getCardId(), cardInfo2);

        Card card3 = new Card(Util.generateUUID(),"528939","0033");
        card3.setCardImageUrl("https://img-bkmexpress.mncdn.com/BexpLogos/banks/mobil/halkbank/01.png");
        cardMap.put(card3.getCardId(), card3);
        CardInfo cardInfo3 = new CardInfo("5289396531020033", "1120");
        cardInfoMap.put(card3.getCardId(), cardInfo3);

        Card card4 = new Card(Util.generateUUID(),"428945","0423");
        card4.setCardImageUrl("https://img-bkmexpress.mncdn.com/BexpLogos/banks/mobil/sin_PLATINUM_MC.png");
        cardMap.put(card4.getCardId(), card4);
        CardInfo cardInfo4 = new CardInfo("4289450187923330", "0423");
        cardInfoMap.put(card4.getCardId(), cardInfo4);

        Card card5 = new Card(Util.generateUUID(),"409070","3514");
        card5.setCardImageUrl("https://img-bkmexpress.mncdn.com/BexpLogos/banks/mobil/DenizbankBonus.png");
        cardMap.put(card4.getCardId(), card4);
        CardInfo cardInfo5 = new CardInfo("4090700102323514", "1121" );
        cardInfoMap.put(card5.getCardId(), cardInfo4);

    }


}
