package LabWork_1;

import java.util.Scanner;

public class Task1 {
   public static void main(String[] args) {
      try {
         Scanner scan = new Scanner(System.in);
         System.out.print("Enter number to convert: ");
         int number = scan.nextInt();
         String result = convertToBinary(number);
         System.out.println(result);
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }

   public static String convertToBinary(int number) {
      if (number < 0) {
         throw new IllegalArgumentException("Cannot convert negative numbers");
      }
      if (number == 0) {
         return "0";
      }

      StringBuilder binary = new StringBuilder();

      while (number > 0) {
         binary.append(number % 2);
         number = number / 2;
      }

      return binary.reverse().toString();
   }
}