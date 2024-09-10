package LabWork_1.Task6_7;

public class BankAccount {
   private final String accountId;
   private final User owner;
   private final Bank bank;
   private double balance;

   public BankAccount(String accountId, User owner, Bank bank, double initialBalance) {
      this.accountId = accountId;
      this.owner = owner;
      this.bank = bank;
      this.balance = initialBalance;
   }

   public String getAccountId() {
      return accountId;
   }

   public User getOwner() {
      return owner;
   }

   public Bank getBank() {
      return bank;
   }

   public double getBalance() {
      return balance;
   }

   public void deposit(double amount) {
      balance += amount;
   }

   public boolean withdraw(double amount) {
      if (balance >= amount) {
         balance -= amount;
         return true;
      }
      return false;
   }

   public void transferTo(BankAccount targetAccount, double amount, CurrencyConverter converter) {
      double convertedAmount = amount;

      if (!this.bank.getCurrency().equals(targetAccount.getBank().getCurrency())) {
         convertedAmount = converter.convert(this.bank.getCurrency(), targetAccount.getBank().getCurrency(), amount);
      }

      double fee = calculateFee(targetAccount);
      double totalAmount = convertedAmount * (1 - fee);

      if (this.withdraw(amount)) {
         targetAccount.deposit(totalAmount);
         System.out.printf("Transferred %.2f %s from account %s to account %s. Commission: %.2f%%\n",
               amount, this.bank.getCurrency(), this.accountId, targetAccount.getAccountId(), fee * 100);
      } else {
         System.out.println("Insufficient funds for the transfer.");
      }
   }

   private double calculateFee(BankAccount targetAccount) {
      if (this.owner.equals(targetAccount.getOwner())) {
         if (this.bank.equals(targetAccount.getBank())) {
            return 0.0;
         } else {
            return 0.02;
         }
      } else {
         if (this.bank.equals(targetAccount.getBank())) {
            return 0.03;
         } else {
            return 0.06;
         }
      }
   }
}