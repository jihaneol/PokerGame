package main.java.model;

import main.java.service.CardDeck;
import main.java.service.CardDeck;

public enum PokerRank {
    HIGH_CARD(1, "High Card"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            return p1.pairCompareTO(p2);
        }
    },
    ONE_PAIR(2, "One Pair"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            return p1.pairCompareTO(p2);
        }
    },
    TWO_PAIR(3, "Two Pair"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            return p1.pairCompareTO(p2);
        }
    },
    THREE_OF_A_KIND(4, "Three of a Kind"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            int pair1 = p1.getMaxPairNumber();
            int pair2 = p2.getMaxPairNumber();

            return pair1<pair2?p2 : p1;
        }
    },
    STRAIGHT(5, "Straight"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            Card card1 = p1.getTopCard();
            Card card2 = p2.getTopCard();
            // 카드 비교
            if(card1.getNUMBER()<card2.getNUMBER()) return p2;
            else if(card1.getNUMBER()>card2.getNUMBER()) return p1;
            // 카드 문양 비교
            if(card1.getKIND().getNum()<card2.getKIND().getNum()) return p2;

            return p1;
        }
    },
    BACK_STRAIGHT(6, "Back Straight"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            Card card1 = p1.getTopCard();
            Card card2 = p2.getTopCard();
            // 카드 비교
            if(card1.getNUMBER()<card2.getNUMBER()) return p2;
            else if(card1.getNUMBER()>card2.getNUMBER()) return p1;
            // 카드 문양 비교
            if(card1.getKIND().getNum()<card2.getKIND().getNum()) return p2;

            return p1;
        }
    },
    MOUNTIN(7, "Mountin"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            Card card1 = p1.getTopCard();
            Card card2 = p2.getTopCard();

            // 카드 문양 비교
            if(card1.getKIND().getNum()<card2.getKIND().getNum()) return p2;

            return p1;
        }
    },
    FLUSH(8, "Flush"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            return p1.pairCompareTO(p2);
        }
    },
    FULL_HOUSE(9, "Full House"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            int pair1 = p1.getMaxPairNumber();
            int pair2 = p2.getMaxPairNumber();

            return pair1<pair2?p2 : p1;
        }
    },
    FOUR_OF_A_KIND(10, "Four of a Kind"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            int pair1 = p1.getMaxPairNumber();
            int pair2 = p2.getMaxPairNumber();

            return pair1<pair2?p2 : p1;
        }
    },
    STRAIGHT_FLUSH(11, "Straight Flush"){
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            Card card1 = p1.getTopCard();
            Card card2 = p2.getTopCard();
            // 카드 비교
            if(card1.getNUMBER()<card2.getNUMBER()) return p2;
            else if(card1.getNUMBER()>card2.getNUMBER()) return p1;
            // 카드 문양 비교
            if(card1.getKIND().getNum()<card2.getKIND().getNum()) return p2;

            return p1;
        }
    },
    BACK_STRAIGHT_FLUSH(12, "Back Straight Flush"){

        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            Card card1 = p1.getTopCard();
            Card card2 = p2.getTopCard();
            // 카드 비교
            if(card1.getNUMBER()<card2.getNUMBER()) return p2;
            else if(card1.getNUMBER()>card2.getNUMBER()) return p1;
            // 카드 문양 비교
            if(card1.getKIND().getNum()<card2.getKIND().getNum()) return p2;

            return p1;
        }
    },
    ROYAL_STRAIHGT_FLUSH(13, "Royal Straight Flush"){
        //무늬 비교
        @Override
        public CardDeck compare(CardDeck p1, CardDeck p2) {
            return p1.topShapeCompare(p2);
        }
    };

    private final int rank;
    private final String name;

    PokerRank(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isHigherThan(PokerRank rank2) {
        return this.rank<rank2.rank;
    }

    public abstract CardDeck compare(CardDeck p1, CardDeck p2);
}