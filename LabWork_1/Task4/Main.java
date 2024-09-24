package LabWork_1.Task4;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a string: ");
      String input = scan.nextLine().trim();

      CharCounter charCounter = new CharCounter(input);
      charCounter.countCharacters();
      charCounter.displayResults();
   }
}
