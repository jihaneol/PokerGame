package main.java;

import java.util.*;
public class CardMaker {
    public static  List<Card>  make() {
        List<Card> deck = new ArrayList<>();
        for(int i=1; i<=4; i++){
            for(int j=1; j<14; j++){
                deck.add(new Card(j,Shape.get(i)));
            }
        }
        return deck;
    }

}
