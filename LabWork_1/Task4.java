package LabWork_1;

import java.util.Scanner;

public class Task4 {
   public static void main(String[] args) {
      String input = enterValue();
      countCharacters(input);
   }

   public static String enterValue() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter an value: ");
      String expression = scanner.nextLine().trim();
      scanner.close();
      return expression;
   }

   public static void countCharacters(String input) {
      int[] counts = new int[128];

      for (char c : input.toCharArray()) {
         if (c < 128) {
            counts[c]++;
         }
      }

      for (int i = 0; i < counts.length; i++) {
         if (counts[i] > 0) {
            CharCount cc = new CharCount((char) i, counts[i]);
            System.out.println(cc);
         }
      }
   }
}

class CharCount {
   char character;
   int count;

   public CharCount(char character, int count) {
      this.character = character;
      this.count = count;
   }

   public String toString() {
      return character + ": " + count;
   }
}
