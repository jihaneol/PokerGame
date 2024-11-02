package main.java.service;

import main.java.model.Card;
import main.java.model.PokerRank;

import java.util.*;

public class Dealer {
    private List<Card> cardDeck;
    private int size = 51;

    public Dealer(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public void suffle() {
        this.size = 51;
        Collections.shuffle(cardDeck);
    }

    public static CardDeck  comparePlayer(CardDeck p1, CardDeck p2){
        PokerRank rank1 = p1.getRank();
        PokerRank rank2 = p2.getRank();

        return rank1.isHigherThan(rank2)? p2 : rank1.getRank() == rank2.getRank() ? rank1.compare(p1,p2) : p1;
    }

    public CardDeck handOut(){
        List<Card> result = new ArrayList<>();
        for(int i=0; i<5; i++) result.add(cardDeck.get(size--));
        return new PlayerCardDeck(result);
    }
}
