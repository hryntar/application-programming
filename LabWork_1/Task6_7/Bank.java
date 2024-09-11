package LabWork_1.Task6_7;

import java.util.HashMap;
import java.util.Map;

public class Bank {
   private final String name;
   private final Map<String, BankAccount> accounts = new HashMap<>();

   public Bank(String name) {
      this.name = name;
   }

   public void addAccount(BankAccount account) {
      if (!accounts.containsKey(account.getAccountId())) {
         accounts.put(account.getAccountId(), account);
      } else {
         System.out.println("Account with ID " + account.getAccountId() + " already exists.");
      }
   }

   public BankAccount getAccount(String accountId) {
      return accounts.get(accountId);
   }

   public String getName() {
      return name;
   }
}
