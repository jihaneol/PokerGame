package main.java.model;

public class Card implements Comparable<Card>{
    private final int NUMBER;
    private final Shape KIND;

    public Card(int number, Shape shape){
        this.NUMBER = number;
        this.KIND = shape;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public Shape getKIND() {
        return KIND;
    }

    @Override
    public String toString() {
        return String.format("%s %-2s",KIND,NUMBER);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.NUMBER, o.NUMBER);
    }
}
