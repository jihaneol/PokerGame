package main.java.controller;

import main.java.service.CardDeck;
import main.java.service.Dealer;
import main.java.service.Player;

import java.util.List;

public class RoundManager {

    public Player determineRoundWinner(List<Player> playerList) {
        CardDeck winnerDeck = getWinnerDeck(playerList);
        return getWinner(playerList, winnerDeck);
    }

    private Player getWinner(List<Player> playerList,CardDeck winnerDeck) {
        Player winner = null;
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            if (player.getCardDeck().equals(winnerDeck)) {
                player.win();
                winner = player;
            } else {
                player.lose();
                System.out.println(player);
            }
        }
        return winner;
    }

    private CardDeck getWinnerDeck(List<Player> playerList) {
        CardDeck deck1 = playerList.get(0).getCardDeck();
        for (int i = 1; i < playerList.size(); i++) {
            CardDeck deck2 = playerList.get(i).getCardDeck();
            deck1 = Dealer.comparePlayer(deck1, deck2);
        }
        return deck1;
    }
}
