package main.java;

public class Card {
    private final int NUMBER;
    private final Shape KIND;

    Card(int number, Shape shape){
        this.NUMBER = number;
        this.KIND = shape;
    }

    @Override
    public String toString() {
        return "Card{" +
                "NUMBER=" + NUMBER +
                ", KIND=" + KIND +
                '}';
    }
}
