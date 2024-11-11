package main.java.service;

import main.java.model.Card;
import main.java.model.PokerRank;
import main.java.model.Shape;

import java.util.*;

import static main.java.model.PokerRank.*;

public class PlayerCardDeck extends CardDeck{
    private Map<Integer, Integer> map;
    private Set<Shape> set;
    private PokerRank pokerRank;
    public PlayerCardDeck(List<Card> cards) {
        super(cards);
        set = new HashSet<>();
        map = new HashMap<>();

        for (Card c : cards) {
            set.add(c.getKIND());
            map.put(c.getNUMBER(), map.getOrDefault(c.getNUMBER(), 0) + 1);
        }
        Collections.sort(super.cards);
    }

    public PokerRank getRank() {

        if(this.pokerRank != null) return this.pokerRank;

        // 로티플 = 플러쉬 + 마운틴
        pokerRank =  getPokerRank();

        return pokerRank;
    }
    private PokerRank getPokerRank(){
        boolean straight = true;
        boolean flush = false;
        boolean back = false;
        boolean mountin = true;

        int[] mountinArr = {1, 10, 11, 12, 13};

        for (int i = 0; i < cards.size(); i++) {
            if (mountinArr[i] != cards.get(i).getNUMBER()) {
                mountin = false;
            }
        }

        int pair = map.values().stream()
                .filter((value) -> value > 1)
                .mapToInt(i -> i)
                .sum();

        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i - 1).getNUMBER() + 1 != cards.get(i).getNUMBER()) {
                straight = false;
            }
        }

        if (straight && cards.get(0).getNUMBER() == 1) {
            back = true;
        }

        if (set.size() == 1) {
            flush = true;
        }
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

    public Card getTopCard() {
        Card card = cards.get(0);

        if (card.getNUMBER() == 1) return new Card(14, card.getKIND());

        return cards.get(4);
    }

    public CardDeck topShapeCompare(CardDeck p) {
        return this.cards.get(0).getKIND().getNum() < p.cards.get(0).getKIND().getNum() ? p : this;
    }

    public int getMaxPairNumber() {
        int key = map.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .mapToInt(e -> e.getKey())
                .findFirst().getAsInt();
        return key == 1 ? 14 : key;
    }

    public CardDeck pairCompareTO(CardDeck p) {

        List<Map.Entry<Integer, Integer>> p1 = sorted();
        List<Map.Entry<Integer, Integer>> p2 = p.sorted();
        for (int i = 0; i < p1.size(); i++) {
            int key1 = p1.get(i).getKey() == 1 ? 14 : p1.get(i).getKey();
            int key2 = p2.get(i).getKey() == 1 ? 14 : p2.get(i).getKey();

            if (key1 < key2) return p;
            else if (key1 > key2) return this;

        }

        Shape shape = maxShape(p1.get(0).getKey());
        Shape shape1 = p.maxShape(p2.get(0).getKey());

        return shape.getNum() < shape1.getNum() ? p : this;
    }

    protected Shape maxShape(int key) {
        Shape result = Shape.CLOVA;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getNUMBER() == key && result.getNum() < card.getKIND().getNum()) result = card.getKIND();
        }
        return result;
    }

    protected List<Map.Entry<Integer, Integer>> sorted() {
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
        return String.format("%s",cards);
    }
}
