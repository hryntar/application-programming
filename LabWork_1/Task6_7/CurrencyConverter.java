package LabWork_1.Task6_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
   private final Map<String, Double> exchangeRates;

   public CurrencyConverter() {
      exchangeRates = new HashMap<>();
      exchangeRates.put("UAHtoUSD", 0.024);
      exchangeRates.put("UAHtoCAD", 0.033);
      exchangeRates.put("UAHtoEUR", 0.022);

      exchangeRates.put("USDtoUAH", 41.20);
      exchangeRates.put("USDtoCAD", 1.36);
      exchangeRates.put("USDtoEUR", 0.91);

      exchangeRates.put("CADtoUAH", 30.33);
      exchangeRates.put("CADtoUSD", 0.74);
      exchangeRates.put("CADtoEUR", 0.67);

      exchangeRates.put("EURtoUAH", 45.47);
      exchangeRates.put("EURtoUSD", 1.10);
      exchangeRates.put("EURtoCAD", 1.50);
   }

   public static void main(String[] args) {
      try {
         CurrencyConverter converter = new CurrencyConverter();

         Scanner scanner = new Scanner(System.in);
         System.out.print("Convert: ");
         String input = scanner.nextLine();
         double result = converter.processConversion(input);
         System.out.println(result);
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }

   public double convert(String fromCurrency, String toCurrency, double amount) {
      String key = fromCurrency + "to" + toCurrency;
      if (exchangeRates.containsKey(key)) {
         return amount * exchangeRates.get(key);
      } else {
         throw new IllegalArgumentException("Unable to convert " + fromCurrency + " into " + toCurrency);
      }
   }

   public double processConversion(String input) {
      if (input.isBlank()) {
         throw new IllegalArgumentException("Input is empty");
      }
      try {
         String[] parts = input.split(" ");
         final double amount = Double.parseDouble(parts[0]);
         final String fromCurrency = parts[1].toUpperCase();
         final String toCurrency = parts[3].toUpperCase();
         return convert(fromCurrency, toCurrency, amount);
      } catch (IllegalArgumentException e) {
         throw new IllegalArgumentException(e.getMessage());
      } catch (ArrayIndexOutOfBoundsException e) {
         throw new ArrayIndexOutOfBoundsException("Invalid input format");
      }
   }
}