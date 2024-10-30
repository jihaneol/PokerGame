import main.java.model.Card;
import main.java.model.PokerRank;
import main.java.model.Shape;
import main.java.service.Dealer;
import main.java.service.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static main.java.model.PokerRank.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Dealer dealer;
    private Player player1, player2;


    @BeforeEach
    void init() {
        player1 = new Player("테스터1");
        player2 = new Player("테스터2");

    }




    @Nested
    @DisplayName("족보 랭크 잘 반환되었나 확인 테스 묶음")
    class RankTest
    {
        @Test
        @DisplayName("로얄 스트리트 플러쉬 반환 잘되는 지확인")
        void 랭크_반환_테스트_royal_s_f_1() throws Exception {
            List<Card> cards = List.of(new Card(1, Shape.SPADE)
                    , new Card(10, Shape.SPADE)
                    , new Card(11, Shape.SPADE)
                    , new Card(12, Shape.SPADE)
                    , new Card(13, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), ROYAL_STRAIHGT_FLUSH);
        }

        @Test
        void 랭크_반환_테스트_back_straight_flush_2() throws Exception {
            List<Card> cards = List.of(new Card(1, Shape.SPADE)
                    , new Card(2, Shape.SPADE)
                    , new Card(3, Shape.SPADE)
                    , new Card(5, Shape.SPADE)
                    , new Card(4, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.BACK_STRAIGHT_FLUSH);
        }

        @Test
        void 랭크_반환_테스트_straight_flush_3() throws Exception {
            List<Card> cards = List.of(new Card(6, Shape.SPADE)
                    , new Card(2, Shape.SPADE)
                    , new Card(3, Shape.SPADE)
                    , new Card(5, Shape.SPADE)
                    , new Card(4, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.STRAIGHT_FLUSH);
        }

        @Test
        void 랭크_반환_테스트_four_4() throws Exception {
            List<Card> cards = List.of(new Card(1, Shape.SPADE)
                    , new Card(1, Shape.DIAMOND)
                    , new Card(1, Shape.HEART)
                    , new Card(1, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.FOUR_OF_A_KIND);
        }

        @Test
        void 랭크_반환_테스트_full_5() throws Exception {
            List<Card> cards = List.of(new Card(3, Shape.SPADE)
                    , new Card(3, Shape.DIAMOND)
                    , new Card(3, Shape.HEART)
                    , new Card(1, Shape.DIAMOND)
                    , new Card(1, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), FULL_HOUSE);
        }

        @Test
        void 랭크_반환_테스트_flush_6() throws Exception {
            List<Card> cards = List.of(new Card(2, Shape.SPADE)
                    , new Card(3, Shape.SPADE)
                    , new Card(4, Shape.SPADE)
                    , new Card(1, Shape.SPADE)
                    , new Card(7, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), FLUSH);
        }

        @Test
        void 랭크_반환_테스트_mountin_7() throws Exception {
            List<Card> cards = List.of(new Card(10, Shape.SPADE)
                    , new Card(11, Shape.DIAMOND)
                    , new Card(12, Shape.HEART)
                    , new Card(13, Shape.DIAMOND)
                    , new Card(1, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), MOUNTIN);
        }

        @Test
        void 랭크_반환_테스트_back_straight_8() throws Exception {
            List<Card> cards = List.of(new Card(1, Shape.SPADE)
                    , new Card(2, Shape.DIAMOND)
                    , new Card(3, Shape.HEART)
                    , new Card(4, Shape.DIAMOND)
                    , new Card(5, Shape.SPADE));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), BACK_STRAIGHT);
        }

        @Test
        void 랭크_반환_테스트_straight_9() throws Exception {
            List<Card> cards = List.of(new Card(6, Shape.SPADE)
                    , new Card(2, Shape.DIAMOND)
                    , new Card(3, Shape.HEART)
                    , new Card(5, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.STRAIGHT);
        }

        @Test
        void 랭크_반환_테스트_three_10() throws Exception {
            List<Card> cards = List.of(new Card(5, Shape.SPADE)
                    , new Card(1, Shape.DIAMOND)
                    , new Card(1, Shape.HEART)
                    , new Card(1, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.THREE_OF_A_KIND);
        }

        @Test
        void 랭크_반환_테스트_two_11() throws Exception {
            List<Card> cards = List.of(new Card(5, Shape.SPADE)
                    , new Card(5, Shape.DIAMOND)
                    , new Card(1, Shape.HEART)
                    , new Card(1, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), PokerRank.TWO_PAIR);
        }

        @Test
        void 랭크_반환_테스트_one_12() throws Exception {
            List<Card> cards = List.of(new Card(2, Shape.SPADE)
                    , new Card(5, Shape.DIAMOND)
                    , new Card(4, Shape.HEART)
                    , new Card(3, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), ONE_PAIR);
        }

        @Test
        void 랭크_반환_테스트_high_13() throws Exception {
            List<Card> cards = List.of(new Card(2, Shape.SPADE)
                    , new Card(5, Shape.DIAMOND)
                    , new Card(1, Shape.HEART)
                    , new Card(9, Shape.CLOVA)
                    , new Card(4, Shape.DIAMOND));
            player1.setCard(new ArrayList<>(cards));

            assertEquals(player1.getRank(), HIGH_CARD);
        }

    }

    @Nested
    @DisplayName("노 페어일 때--")
    class highCardTest{
        @Nested
        @DisplayName("첫번째 탑 카드 확인")
        class first_top{
            @Test
            @DisplayName("탑 카드가 동일하다면 두번쨰 탑 카드 확인 - 값이 다를 시 숫자 큰 쪽이 이긴다.")
            void highCard2(){
                highPlayersFixture_2();
                PokerRank rank = player1.getRank();
                //when
                Player compare = rank.compare(player1, player2);
                //then
                assertEquals(compare, player2);

            }
            @Test
            @DisplayName("탑 카드가 다르면 큰 숫자인 플레이어가 이긴다.")
            void highCard1(){
                highPlayersFixture_1();
                PokerRank rank = player1.getRank();
                //when
                Player compare = rank.compare(player1, player2);
                //then
                assertEquals(compare, player2);
            }
        }

        @Test
        @DisplayName("가장 높은 탑 카드 모양 확인")
        void highCard5(){
            //given
            highPlayersFixture_5();
            PokerRank rank = player1.getRank();
            //when
            Player compare = rank.compare(player1, player2);
            //then
            assertEquals(compare, player2);
        }

    }


    @Test
    @DisplayName("같고있는 손패 확인")
    void print(){
       royalPlayersFixture_1();
        System.out.println(player1);
    }

    @Nested
    @DisplayName("원 페어일 때--")
    class OnePairCardTest{
        @Test
        @DisplayName("모든 탑 페어가 같으면 가장 큰 탑 페어의 모양으로 결정해서 플레이어 승")
        void 원페어_테스트_모두같아서_탑의모양을확인() throws Exception {
            //given
            onePairPlayersFixture_5();
            PokerRank rank = player1.getRank();
            //when
            Player compare = rank.compare(player1, player2);
            //then
            assertEquals(compare, player2);

        }

        @Test
        @DisplayName("탑페어가 다르면 숫자가 큰 플레이어 승")
        void 원페어_테스트_탑페어_확인() throws Exception {
            //given
            onePairPlayersFixture_1();
            PokerRank rank = player1.getRank();
            //when
            Player compare = rank.compare(player1, player2);
            //then
            assertEquals(compare, player1);

        }

    }


    @Test
    void 투페어_테스트() throws Exception {

        TwoPairPlayersFixture_1();
        PokerRank rank = player1.getRank();
        //when
        Player compare = rank.compare(player1, player2);
        //then
        assertEquals(compare, player2);
    }
    private void highPlayersFixture_1() {
        List<Card> cards1 = List.of(new Card(5, Shape.HEART)
                , new Card(2, Shape.DIAMOND)
                , new Card(6, Shape.CLOVA)
                , new Card(7, Shape.HEART)
                , new Card(8, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(1, Shape.SPADE)
                , new Card(3, Shape.CLOVA)
                , new Card(4, Shape.HEART)
                , new Card(6, Shape.CLOVA)
                , new Card(9, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }
    private void highPlayersFixture_2() {
        List<Card> cards1 = List.of(new Card(1, Shape.HEART)
                , new Card(2, Shape.DIAMOND)
           , new Card(6, Shape.CLOVA)
                , new Card(7, Shape.HEART)
                , new Card(8, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(1, Shape.SPADE)
                , new Card(3, Shape.CLOVA)
                , new Card(4, Shape.HEART)
                , new Card(6, Shape.CLOVA)
                , new Card(9, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }

    private void highPlayersFixture_5() {
        List<Card> cards1 = List.of(new Card(1, Shape.HEART)
                , new Card(3, Shape.DIAMOND)
                , new Card(4, Shape.CLOVA)
                , new Card(6, Shape.HEART)
                , new Card(9, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(1, Shape.SPADE)
                , new Card(3, Shape.CLOVA)
                , new Card(4, Shape.HEART)
                , new Card(6, Shape.CLOVA)
                , new Card(9, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }

    void onePairPlayersFixture_5() {
        List<Card> cards1 = List.of(new Card(1, Shape.HEART)
                , new Card(1, Shape.DIAMOND)
                , new Card(4, Shape.CLOVA)
                , new Card(6, Shape.HEART)
                , new Card(9, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(1, Shape.SPADE)
                , new Card(1, Shape.CLOVA)
                , new Card(4, Shape.HEART)
                , new Card(6, Shape.CLOVA)
                , new Card(9, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }
    void royalPlayersFixture_1() {
        List<Card> cards1 = List.of(new Card(1, Shape.HEART)
                , new Card(10, Shape.HEART)
                , new Card(11, Shape.HEART)
                , new Card(12, Shape.HEART)
                , new Card(13, Shape.HEART));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(1, Shape.SPADE)
                , new Card(10, Shape.SPADE)
                , new Card(11, Shape.SPADE)
                , new Card(12, Shape.SPADE)
                , new Card(13, Shape.SPADE));
        player2.setCard(new ArrayList<>(cards2));
    }

    void onePairPlayersFixture_1() {
        List<Card> cards1 = List.of(new Card(2, Shape.HEART)
                , new Card(2, Shape.DIAMOND)
                , new Card(3, Shape.CLOVA)
                , new Card(6, Shape.HEART)
                , new Card(1, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(2, Shape.SPADE)
                , new Card(2, Shape.CLOVA)
                , new Card(4, Shape.HEART)
                , new Card(5, Shape.CLOVA)
                , new Card(1, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }

    private void TwoPairPlayersFixture_1() {
        List<Card> cards1 = List.of(new Card(2, Shape.HEART)
                , new Card(2, Shape.DIAMOND)
                , new Card(1, Shape.SPADE)
                , new Card(1, Shape.HEART)
                , new Card(9, Shape.DIAMOND));
        player1.setCard(new ArrayList<>(cards1));

        List<Card> cards2 = List.of(new Card(2, Shape.SPADE)
                , new Card(2, Shape.CLOVA)
                , new Card(1, Shape.DIAMOND)
                , new Card(1, Shape.CLOVA)
                , new Card(9, Shape.CLOVA));
        player2.setCard(new ArrayList<>(cards2));
    }
}
