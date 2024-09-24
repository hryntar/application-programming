package LabWork_1.Task6_7;

import java.util.HashMap;
import java.util.Map;

public class Bank {
   private static final Map<String, BankAccount> accountRegistry = new HashMap<>();
   private final String name;
   private final CurrencyConverter currencyConverter;

   public Bank(String name, CurrencyConverter currencyConverter) {
      this.name = name;
      this.currencyConverter = currencyConverter;
   }

   public String getName() {
      return name;
   }

   public CurrencyConverter getCurrencyConverter() {
      return currencyConverter;
   }

   public BankAccount createAccount(User owner, String currency, double initialBalance) {
      String accountKey = generateAccountKey(owner, currency);
      if (accountRegistry.containsKey(accountKey)) {
         throw new IllegalArgumentException("account already exists " + owner.getName() + " in currency " + currency);
      }

      BankAccount account = new BankAccount(owner, currency, initialBalance, this);
      accountRegistry.put(accountKey, account);
      return account;
   }

   private String generateAccountKey(User owner, String currency) {
      return owner.getUserId() + "-" + currency;
   }

   public static Map<String, BankAccount> getAccountRegistry() {
      return accountRegistry;
   }
}
