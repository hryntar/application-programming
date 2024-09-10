package LabWork_1.Task6_7;

import java.util.ArrayList;
import java.util.List;

public class User {
   private final String name;
   private final List<BankAccount> accounts = new ArrayList<>();

   public User(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void addAccount(BankAccount account) {
      accounts.add(account);
   }

   public List<BankAccount> getAccounts() {
      return accounts;
   }
}