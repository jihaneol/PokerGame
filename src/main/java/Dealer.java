package main.java;

import java.util.*;

public class Dealer {
    private List<Card> cardDeck;
    private int size = 51;

    Dealer(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }


    public void suffle() {
        this.size = 51;
        Collections.shuffle(cardDeck);
    }

    public List<Card> handOut(){
        List<Card> result = new ArrayList<>();
        for(int i=0; i<5; i++){
            result.add(cardDeck.get(size--));
        }
        return result;
    }



}
