package LabWork_1.Task6_7;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
   private final String userId;
   private final String name;
   private final List<BankAccount> accounts;

   public User(String name) {
      this.name = name;
      this.userId = UUID.randomUUID().toString();
      this.accounts = new ArrayList<>();
   }

   public String getName() {
      return name;
   }

   public String getUserId() {
      return userId;
   }

   public void addAccount(BankAccount account) {
      accounts.add(account);
   }

   public List<BankAccount> getAccounts() {
      return accounts;
   }
}
