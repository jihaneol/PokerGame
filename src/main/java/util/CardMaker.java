package main.java.util;

import main.java.model.Card;
import main.java.model.DealerCardDeck;
import main.java.model.Shape;
import main.java.service.CardDeck;

import java.util.ArrayList;
import java.util.List;
public class CardMaker {
    public static  List<Card>  make() {
        List<Card> deck = new ArrayList<>();
        for(int num=1; num<=4; num++){
            for(int emb=1; emb<14; emb++){
                deck.add(new Card(emb, Shape.get(num)));
            }
        }
        return deck;
    }

}
