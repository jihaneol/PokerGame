package main.java.view;

import main.java.Message;
import main.java.service.Player;

import java.util.List;

public class OutPutView {
    public static void print(Message m){
        System.out.print(m.getmessage());
    }
    public static void print(String s){
        System.out.println(s);
    }

    public static void printEndGameMessage(List<Player> sortedPlayer) {
        for(int i=1; i<=sortedPlayer.size(); i++){
            System.out.printf("%d등 player%s\n",i,sortedPlayer.get(i-1));
        }
    }

    public static void printRoundWinnerMessage(int round, Player winner) {
        System.out.printf("============= 이번 %d라운드 우승자 ============= \n", round);
        System.out.println(winner);
        System.out.println();
    }
}
