package LabWork_1.Task6_7;

import java.util.HashMap;
import java.util.Map;

public class Bank {
   private final String name;
   private final String currency;
   private final Map<String, BankAccount> accounts = new HashMap<>();

   public Bank(String name, String currency) {
      this.name = name;
      this.currency = currency;
   }

   public String getCurrency() {
      return currency;
   }

   public void addAccount(BankAccount account) {
      accounts.put(account.getAccountId(), account);
   }

   public BankAccount getAccount(String accountId) {
      return accounts.get(accountId);
   }

   public String getName() {
      return name;
   }
}