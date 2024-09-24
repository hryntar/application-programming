package LabWork_1.Task6_7;

public class Main {
   public static void main(String[] args) {
      CurrencyConverter converter = new CurrencyConverter();

      Bank bank1 = new Bank("Bank 1", converter);
      Bank bank2 = new Bank("Bank 2", converter);

      User user1 = new User("User 1");
      User user2 = new User("User 2");

      try {
         BankAccount usdAcc_u1 = bank1.createAccount(user1, "USD", 1000);
         BankAccount eurAcc_u1 = bank2.createAccount(user1, "EUR", 500);
         BankAccount usdAcc_u2 = bank1.createAccount(user2, "USD", 200);

         user1.addAccount(usdAcc_u1);
         user1.addAccount(eurAcc_u1);
         user2.addAccount(usdAcc_u2);

         usdAcc_u1.transfer(eurAcc_u1, 100);
         usdAcc_u1.transfer(usdAcc_u2, 50);

         System.out.println("usdAcc_u1 balance: " + usdAcc_u1.getBalance());
         System.out.println("eurAcc_u1 balance: " + eurAcc_u1.getBalance());
         System.out.println("usdAcc_u2 balance: " + usdAcc_u2.getBalance());
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}
