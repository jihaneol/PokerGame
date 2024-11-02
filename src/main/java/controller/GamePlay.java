package main.java.controller;

import main.java.Message;
import main.java.service.CardDeck;
import main.java.service.Dealer;
import main.java.service.Player;
import main.java.util.CardMaker;
import main.java.validator.Validator;
import main.java.view.Inputview;
import main.java.view.OutPutView;

import java.util.*;

import static main.java.InitSetting.GAME_ROUND;

public class GamePlay {
    private List<Player> playerList = new ArrayList<>();
    private Dealer dealer;

    public void run() {
        System.out.println("게임을 시작합니다.");

        makePlayer(getPlayerNumber());
        dealer = new Dealer(CardMaker.make());

        for (int i = 1; i <= GAME_ROUND; i++) {
            System.out.printf("%d라운드 \n", i);
            // 카드 서플하고 플레이어에게 5개씩 나눠주기..
            dealer.suffle();
            for (Player p : playerList) {
                CardDeck cardDeck = dealer.handOut();
                p.setCard(cardDeck);
            }
            play(i);
        }

        endGame();
    }

    private int getPlayerNumber() {
        String re;
        // 몇명이서 할거냐..
        do {
            re = Inputview.readNumber();
        } while (Validator.PlayerNumCheck(re));

        return Integer.valueOf(re);
    }

    private void endGame() {
        System.out.println("=========== 게임 종료 플레이어 결과 리스트 ===========");
        Collections.sort(playerList);
        for (Player p : playerList) {
            System.out.println(p);
        }
    }

    private void makePlayer(int total) {
        // 닉네임 중복 처리
        HashSet<String> nickNameSet = new HashSet<>();
        while (total > 0) {
            String nickname = Inputview.readNickname();
             if(nickNameSet.contains(nickname)){
                 System.out.println("닉네임 중복되었습니다. 다시 입력하세요");
                 continue;
             }

             nickNameSet.add(nickname);
            if (!Validator.PlayerNicknameCheck(nickname)) {
                OutPutView.print(Message.RE_INPUT_NICKNAME_MESSAGE);
                OutPutView.print(Message.EXEMPLE_NICKNAME_MESSAGE);
                continue;
            }
            playerList.add(new Player(nickname));
            total--;
        }
    }

    private void play(int round) {
        CardDeck winnerDeck = getWinnerDeck();
        Player winner = getWinner(winnerDeck);

        System.out.printf("============= 이번 %d라운드 우승자 ============= \n",round);
        System.out.println(winner);
        System.out.println();
    }

    private Player getWinner(CardDeck winnerDeck) {
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

    private CardDeck getWinnerDeck() {
        CardDeck deck1 = playerList.get(0).getCardDeck();
        for (int i = 1; i < playerList.size(); i++) {
            CardDeck deck2 = playerList.get(i).getCardDeck();
            deck1 = Dealer.comparePlayer(deck1, deck2);
        }
        return deck1;
    }
}
