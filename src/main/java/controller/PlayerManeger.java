package main.java.controller;

import main.java.Message;
import main.java.service.CardDeck;
import main.java.service.Dealer;
import main.java.service.Player;
import main.java.validator.Validator;
import main.java.view.Inputview;
import main.java.view.OutPutView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PlayerManeger {
    private final List<Player> playerList = new ArrayList<>();

    public void makePlayer() {
        int total = getPlayerNumber();
        // 닉네임 중복 처리
        HashSet<String> nickNameSet = new HashSet<>();
        while (total > 0) {
            String nickname = Inputview.readNickname();
            if (nickNameSet.contains(nickname)) {
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

    private int getPlayerNumber() {
        String input;
        // 몇명이서 할거냐..
        do {
            input = Inputview.readNumber();
        } while (Validator.PlayerNumCheck(input));

        return Integer.valueOf(input);
    }

    public List<Player> getSortedPlayer() {
        Collections.sort(playerList);
        return this.playerList;
    }

    public void distributeCards(Dealer dealer) {
        for (Player p : playerList) {
            CardDeck cardDeck = dealer.handOut();
            p.setCard(cardDeck);
        }
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }
}
