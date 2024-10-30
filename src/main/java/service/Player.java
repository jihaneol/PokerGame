package main.java.service;

import main.java.model.Card;
import main.java.model.PokerRank;
import main.java.model.Shape;

import java.util.*;

import static main.java.model.PokerRank.*;

public class Player implements Comparable<Player> {

    private int money;
    private String nickname;
    private List<Card> cardDeck;
    private Map<Integer, Integer> map;
    private Set<Shape> set;
    private int win;
    private int lose;


    public Player(String nickname) {
        this.money = 10000;
        this.nickname = nickname;
    }

    public void setCard(List<Card> cards) {
        cardDeck = cards;
        set = new HashSet<>();
        map = new HashMap<>();

        for (Card c : cardDeck) {
            set.add(c.getKIND());
            map.put(c.getNUMBER(), map.getOrDefault(c.getNUMBER(), 0) + 1);
        }
        Collections.sort(cardDeck);
    }

    public PokerRank getRank() {
        boolean straight = true;
        boolean flush = false;
        boolean back = false;
        boolean mountin = true;

        int[] mountinArr = {1, 10, 11, 12, 13};

        for (int i = 0; i < cardDeck.size(); i++) {
            if (mountinArr[i] != cardDeck.get(i).getNUMBER()) {
                mountin = false;
            }
        }

        int pair = map.values().stream()
                .filter((value) -> value > 1)
                .mapToInt(i -> i)
                .sum();

        for (int i = 1; i < cardDeck.size(); i++) {
            if (cardDeck.get(i - 1).getNUMBER() + 1 != cardDeck.get(i).getNUMBER()) {
                straight = false;
            }
        }

        if (straight && cardDeck.get(0).getNUMBER() == 1) {
            back = true;
        }

        if (set.size() == 1) {
            flush = true;
        }
        // 로티플 = 플러쉬 + 마운틴
        if (flush && mountin) return ROYAL_STRAIHGT_FLUSH;
        // 백 + 스트레이트 + 플러쉬
        if (back && straight && flush) return BACK_STRAIGHT_FLUSH;
        if (straight && flush) return STRAIGHT_FLUSH;
        // 포커 4
        if (pair == 4 && map.size() == 2) return FOUR_OF_A_KIND;
        //풀하우스  3,2
        if (pair == 5) return FULL_HOUSE;
        //플러쉬 = 무늬 같음
        if (flush) return FLUSH;
        // 마운틴
        if (mountin) return MOUNTIN;
        // 백 + 스트레이트
        if (back && straight) return BACK_STRAIGHT;
        // 스트레이트
        if (straight) return STRAIGHT;
        //트리플, 투페어, 원페어, 하이 카드
        return switch (pair) {
            case 3 -> THREE_OF_A_KIND;
            case 4 -> TWO_PAIR;
            case 2 -> ONE_PAIR;
            default -> HIGH_CARD;
        };
    }

    // 제일 큰 카드 확인
    public Card getTopCard() {
        Card card = cardDeck.get(0);

        if (card.getNUMBER() == 1) return new Card(14, card.getKIND());

        return cardDeck.get(4);
    }

    // 가장 큰 모양
    public Player topShapeCompare(Player p) {
        return this.cardDeck.get(0).getKIND().getNum() < p.cardDeck.get(0).getKIND().getNum() ? p : this;
    }

    // 가장큰
    public int getMaxPairNumber() {
        int key = map.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .mapToInt(e -> e.getKey())
                .findFirst().getAsInt();
        return key == 1 ? 14 : key;
    }

    public Player pairCompareTO(Player p) {

        List<Map.Entry<Integer, Integer>> p1 = sorted();
        List<Map.Entry<Integer, Integer>> p2 = p.sorted();
        for (int i = 0; i < p1.size(); i++) {
            int key1 = p1.get(i).getKey() == 1 ? 14 : p1.get(i).getKey();
            int key2 = p2.get(i).getKey() == 1 ? 14 : p2.get(i).getKey();

            if (key1 < key2) return p;
            else if (key1 > key2) return this;

        }

        // 문양 보기......
        int idx = 0;
        int max = 0;
        Shape shape = maxShape(p1.get(0).getKey());
        Shape shape1 = p.maxShape(p2.get(0).getKey());

        return shape.getNum() < shape1.getNum() ? p : this;
    }

    private Shape maxShape(int key) {
        Shape result = Shape.CLOVA;
        for (int i = 0; i < cardDeck.size(); i++) {
            Card card = cardDeck.get(i);
            if (card.getNUMBER() == key && result.getNum() < card.getKIND().getNum()) result = card.getKIND();
        }
        return result;
    }

    private List<Map.Entry<Integer, Integer>> sorted() {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> {
            // 값 기준으로 비교
            int valueCompare = e2.getValue().compareTo(e1.getValue());

            if (valueCompare != 0) {
                return valueCompare;
            }

            if (e1.getKey().equals(1)) {
                return -1;
            } else if (e2.getKey().equals(1)) {
                return 1;
            }

            return e2.getKey().compareTo(e1.getKey());

        });

        return entryList;
    }

    @Override
    public String toString() {
        return String.format("플레이어 %-21s %-20s  카드덱 %-40s 우승 횟수: %s", nickname, getRank(), cardDeck, win);
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
        return money == player.money && win == player.win && lose == player.lose && Objects.equals(nickname, player.nickname) && Objects.equals(cardDeck, player.cardDeck) && Objects.equals(map, player.map) && Objects.equals(set, player.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, nickname, cardDeck, map, set, win, lose);
    }

    @Override
    public int compareTo(Player o) {
        return this.win == o.win ? this.nickname.compareTo(o.nickname) : Integer.compare(o.win, this.win);
    }
}
