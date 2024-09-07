package LabWork_1;

import java.util.Scanner;

public class Task2 {
   public static void main(String[] args) {
      String expression = enterExpression();

      try {
         double result = evaluateExpression(expression);
         System.out.println("Result: " + result);
      } catch (IllegalArgumentException e) {
         System.out.println("Error: " + e.getMessage());
      } catch (ArithmeticException e) {
         System.out.println("Math Error: " + e.getMessage());
      }
   }

   public static String enterExpression() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter an expression: ");
      String expression = scanner.nextLine().trim();
      scanner.close();
      return expression;
   }

   public static double evaluateExpression(String expression) {
      char operator = ' ';
      if (expression.contains("+")) {
         operator = '+';
      } else if (expression.contains("-")) {
         operator = '-';
      } else if (expression.contains("*")) {
         operator = '*';
      } else if (expression.contains("/")) {
         operator = '/';
      } else {
         throw new IllegalArgumentException("Unsupported operation");
      }

      String[] parts = expression.split("\\s*\\" + operator + "\\s*");

      if (parts.length != 2) {
         throw new IllegalArgumentException("Invalid expression format");
      }

      double num1, num2;
      try {
         num1 = Double.parseDouble(parts[0]);
         num2 = Double.parseDouble(parts[1]);
      } catch (NumberFormatException e) {
         throw new IllegalArgumentException("Invalid numbers");
      }

      switch (operator) {
         case '+':
            return num1 + num2;
         case '-':
            return num1 - num2;
         case '*':
            return num1 * num2;
         case '/':
            if (num2 == 0) {
               throw new ArithmeticException("Division by zero");
            }
            return num1 / num2;
         default:
            throw new IllegalArgumentException("Unknown operator");
      }
   }
}
