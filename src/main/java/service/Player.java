package main.java.service;

import java.util.Objects;


public class Player implements Comparable<Player> {

    private int money;
    private String nickname;
    private CardDeck cardDeck;
    private int win;
    private int lose;


    public Player(String nickname) {
        this.money = 10000;
        this.nickname = nickname;
    }

    public void setCard(CardDeck cards) {
        this.cardDeck = cards;
    }

    public CardDeck getCardDeck(){
        return cardDeck;
    }

    @Override
    public String toString() {
        return String.format("%-20s  %-22s 카드덱 %-40s 우승 횟수: %s", nickname, cardDeck.getRank(), cardDeck, win);
    }


    public void win() {
        win++;
        money += 100;
    }

    public void lose() {
        lose++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return money == player.money && win == player.win && lose == player.lose && Objects.equals(nickname, player.nickname) && Objects.equals(cardDeck, player.cardDeck) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, nickname, cardDeck, win, lose);
    }

    @Override
    public int compareTo(Player o) {
        return this.win == o.win ? this.nickname.compareTo(o.nickname) : Integer.compare(o.win, this.win);
    }
}
