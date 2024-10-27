package main.java;

import java.util.List;

public class Player {
    private String nickname;
    private int money;
    private Long playerId;
    private List<Card> cardDeck;

    Player(String nickname, Long playerId){
        this.money = 10000;
        this.nickname = nickname;
        this.playerId = playerId;
    }

    public Long getPlayerId(){
        return playerId;
    }

    public void setCard(List<Card> cards) {
        cardDeck = cards;
    }

    @Override
    public String toString() {
        return "Player"+playerId+"{" +
                "cardDeck=" + cardDeck +
                '}';
    }
}
