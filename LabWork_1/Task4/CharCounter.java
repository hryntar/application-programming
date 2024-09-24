package LabWork_1.Task4;

public class CharCounter {
    private final String input;
    private final CharCountPair[] charCountPairs;
    private int uniqueCount;

    public CharCounter(String input) {
        this.input = input;
        this.charCountPairs = new CharCountPair[input.length()];
        this.uniqueCount = 0;
    }

    public void countCharacters() {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            boolean found = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (charCountPairs[j].getSymbol() == currentChar) {
                    charCountPairs[j].incrementCount();
                    found = true;
                    break;
                }
            }

            if (!found) {
                charCountPairs[uniqueCount] = new CharCountPair(currentChar, 1);
                uniqueCount++;
            }
        }
    }

    public void displayResults() {
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(charCountPairs[i].getSymbol() + ": " + charCountPairs[i].getCount());
        }
    }
}