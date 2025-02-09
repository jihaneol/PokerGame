package main.java.controller;

import main.java.service.Dealer;
import main.java.service.Player;
import main.java.util.CardMaker;
import main.java.view.OutPutView;

import static main.java.InitSetting.GAME_ROUND;

public class GameController {
    private final Dealer dealer = new Dealer(CardMaker.make());
    private final PlayerManager playerManager = new PlayerManager();
    private final RoundManager roundManager = new RoundManager();

    public void run() {
        init();
        for (int i = 1; i <= GAME_ROUND; i++) {
            play(i);
        }
        endGame();
    }

    private void init() {
        System.out.println("게임을 시작합니다.");
        playerManager.makePlayer();
    }

    private void endGame() {
        System.out.println("=========== 게임 종료 플레이어 결과 리스트 ===========");
        OutPutView.printEndGameMessage(playerManager.getSortedPlayer());
    }

    private void play(int round) {
        System.out.printf("%d라운드 \n", round);
        // 카드 서플하고 플레이어에게 5개씩 나눠주기..
        dealer.shuffle();
        playerManager.distributeCards(dealer);

        Player winner = roundManager.determineRoundWinner(playerManager.getPlayerList());
        OutPutView.printRoundWinnerMessage(round,winner);
    }

}
