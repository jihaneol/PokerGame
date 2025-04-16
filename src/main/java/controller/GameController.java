package main.java.controller;

import main.java.service.Dealer;
import main.java.service.Player;
import main.java.view.OutPutView;

import static main.java.InitSetting.GAME_ROUND;

public class GameController {
    private final PlayerManager playerManager = new PlayerManager();
    private final RoundManager roundManager = new RoundManager();

    public void run() {
        init();
        play();
        endGame();
    }

    private void init() {
        System.out.println("게임을 시작합니다.");
        playerManager.makePlayer();
    }
    private void play() {

        for (int round = 0; round <= GAME_ROUND; round++) {
            System.out.printf("%d라운드 \n", round);
            // 카드 서플하고 플레이어에게 5개씩 나눠주기..
            playerManager.distributeCards();

            Player winner = roundManager.determineRoundWinner(playerManager.getPlayerList());
            OutPutView.printRoundWinnerMessage(round, winner);
        }
    }

    private void endGame() {
        System.out.println("=========== 게임 종료 플레이어 결과 리스트 ===========");
        OutPutView.printEndGameMessage(playerManager.getSortedPlayer());
    }


}
