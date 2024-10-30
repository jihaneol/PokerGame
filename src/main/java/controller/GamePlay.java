package main.java.controller;

import main.java.InitSetting;
import main.java.Message;
import main.java.service.Dealer;
import main.java.service.Player;
import main.java.util.CardMaker;
import main.java.validator.Validator;
import main.java.view.Inputview;
import main.java.view.OutPutView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static main.java.InitSetting.GAME_ROUND;

public class GamePlay {
    private List<Player> playerList = new ArrayList<>();
    private Dealer dealer;

    public void run() {
        System.out.println("게임을 시작합니다.");

        String re;
        // 몇명이서 할거냐..
        do {
            re = Inputview.readNumber();
        } while (Validator.PlayerNumCheck(re));

        makePlayer(Integer.valueOf(re));
        dealer = new Dealer(CardMaker.make());

        for (int i = 1; i <= GAME_ROUND; i++) {

            System.out.printf("%d라운드 \n", i);
            // 카드 서플하고 플레이어에게 5개씩 나눠주기..
            dealer.suffle();
            for (Player p : playerList) {
                p.setCard(dealer.handOut());
            }
            play(i);
        }

        endGame();
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
        System.out.println();
    }

    private void play(int round) {

        Player p1 = playerList.get(0);
        for (int i = 1; i < playerList.size(); i++) {
            Player p2 = playerList.get(i);
            p1 = Dealer.comparePlayer(p1, p2);
        }

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            if (player.equals(p1)) {
                player.win();
            } else {
                player.lose();
                System.out.println(player);
            }
        }
        System.out.printf("============= 이번 %d라운드 우승자 ============= \n",round);
        System.out.println(p1);
        System.out.println();
    }
}
