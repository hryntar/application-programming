package LabWork_1;

import java.util.Scanner;

public class Task2 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter expression: ");
      final String expression = scan.nextLine().trim();

      try {
         final double result = calcExpression(expression);
         System.out.println(result);
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }

   public static double calcExpression(final String expression) {
      final String[] parts = expression.split(" ");
      final double a = Double.parseDouble(parts[0]);
      final double b = Double.parseDouble(parts[2]);
      final String operator = parts[1];

      return switch (operator) {
         case "+" -> a + b;
         case "-" -> a - b;
         case "*" -> a * b;
         case "/" -> {
            if (b == 0) {
               throw new IllegalArgumentException("Division by zero");
            }
            yield a / b;
         }
         default -> throw new IllegalArgumentException("Invalid operator");
      };
   }
}
