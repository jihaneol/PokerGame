package main.java;

import java.util.HashMap;

public enum Shape {
    SPADE,
    HEART,
    DIAMOND,
    CLOVA;


    public static Shape get(int i) {
        return switch (i){
            case 1 -> SPADE;
            case 2 -> DIAMOND;
            case 3 -> HEART;
            case 4 -> CLOVA;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }
}
