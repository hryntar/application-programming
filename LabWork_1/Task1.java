package LabWork_1;

import java.util.Scanner;

public class Task1 {
   public static void main(String[] args) {
      int number = enterNumber();
      String result = convertToBinary(number);
      System.out.println("Binary representation of " + number + " is " + result);
   }

   public static int enterNumber() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = scanner.nextInt();
      scanner.close();
      return number;
   }

   public static String convertToBinary(int number) {
      return Integer.toBinaryString(number);
   }
}