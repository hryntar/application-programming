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
      StringBuilder binary = new StringBuilder();

      if (number == 0) {
         return "0";
      }

      while (number > 0) {
         binary.insert(0, number % 2);
         number = number / 2;
      }

      return binary.toString();
   }
}