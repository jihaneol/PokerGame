package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    private List<Player> playerList = new ArrayList<>();
    private Dealer dealer;
    public void run(){
        System.out.println("게임을 시작합니다.");

        String re;
        do{
            re = Inputview.readNumber();
        }while (Validator.PlayerNumCheck(re));

        // player 생성
        makePlayer(Integer.valueOf(re));
        //딜러 생성
        dealer = new Dealer(CardMaker.make());

        for(int i=1; i<101; i++){
            System.out.printf("%d라운드 \n",i);
            // 카드 서플하고 플레이어에게 5개씩 나눠주기..
            dealer.suffle();
            for(Player p : playerList){
                p.setCard(dealer.handOut());
            }
            play();
        }


    }

    private void makePlayer(int total){
        Long id = 1L;
        while(total>0){
            String nickname = Inputview.readNickname(id);
            if(!Validator.PlayerNicknameCheck(nickname)){
                System.out.println("다시 제대로 입력해라..");
                continue;
            }
            playerList.add(new Player(nickname,id));
            total--;
            id++;
        }
    }
    private void play(){


    }
}
