package main.java.model;

public enum Shape {
    SPADE(4,"\u2660"),
    HEART(3, "\u2665"),
    DIAMOND(2,"\u2666"),
    CLOVA(1,"\u2663");


    private String code;

    @Override
    public String toString() {
        return "[" + code +"]";
    }

    private int num;

    Shape(int num, String code){
        this.num = num;
        this.code = code;
    }

    public int getNum(){
        return this.num;
    }
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
