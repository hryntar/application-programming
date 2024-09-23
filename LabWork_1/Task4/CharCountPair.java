package LabWork_1.Task4;

public class CharCountPair {
    private final char symbol;
    private int count;

    public CharCountPair(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }
}