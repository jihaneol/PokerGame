package main.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DealerCardDeck {
    private List<Card> cardDeck;
    private int size = 51;
    public DealerCardDeck(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }
    public void shuffle() {
        Collections.shuffle(cardDeck);
        this.size = 51;
    }
    public List<Card> handOut() {
        List<Card> result = new ArrayList<>();
        for(int i=0; i<5; i++) result.add(cardDeck.get(size--));

        return result;
    }
}
