package main.java.service;

import main.java.model.Card;
import main.java.model.PokerRank;
import main.java.model.Shape;

import java.util.*;

import static main.java.model.PokerRank.*;

public abstract class CardDeck {

    protected List<Card> cards;

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public abstract PokerRank getRank();

    public abstract Card getTopCard();


    public abstract  CardDeck topShapeCompare(CardDeck p);
    // 가장 큰 모양

    public abstract int getMaxPairNumber();
    // 가장큰

    public abstract CardDeck pairCompareTO(CardDeck p);

    protected abstract Shape maxShape(int key);

    protected abstract List<Map.Entry<Integer, Integer>> sorted();

}
