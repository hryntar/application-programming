package LabWork_1.Task6_7;

public class BankAccount {
   private final User owner;
   private final Bank bank;
   private final String accountId;
   private final String currency;
   private double balance;

   public BankAccount(User owner, String currency, double balance, Bank bank) {
      this.accountId = java.util.UUID.randomUUID().toString();
      this.owner = owner;
      this.currency = currency;
      this.balance = balance;
      this.bank = bank;
   }

   public String getAccountId() {
      return accountId;
   }

   public User getOwner() {
      return owner;
   }

   public String getCurrency() {
      return currency;
   }

   public double getBalance() {
      return balance;
   }

   public Bank getBank() {
      return bank;
   }

   public void deposit(double amount) {
      this.balance += amount;
   }

   public void withdraw(double amount) {
      if (amount > balance) {
         throw new IllegalArgumentException("no enough money on account");
      }
      this.balance -= amount;
   }

   public void transfer(BankAccount targetAccount, double amount) {
      if (amount <= 0) {
         throw new IllegalArgumentException("cannot transfer an amount less or equal to zero");
      }

      double fee = calculateFee(targetAccount);
      double totalAmount = amount + amount * fee;

      if (this.getCurrency().equals(targetAccount.getCurrency())) {
         this.withdraw(totalAmount);
         targetAccount.deposit(amount);
      } else {
         double convertedAmount = this.bank.getCurrencyConverter().convert(this.getCurrency(), targetAccount.getCurrency(), amount);
         this.withdraw(totalAmount);
         targetAccount.deposit(convertedAmount);
      }

      System.out.println("Transferred " + amount + " " + this.getCurrency() + " to " + targetAccount.getOwner().getName()
              + " (" + targetAccount.getBank().getName() + "), fee: " + fee * 100 + "%.");
   }

   private double calculateFee(BankAccount targetAccount) {
      if (this.getOwner().equals(targetAccount.getOwner())) {
         if (this.getBank().getName().equals(targetAccount.getBank().getName())) {
            return 0.0;
         } else {
            return 0.02;
         }
      } else {
         if (this.getBank().getName().equals(targetAccount.getBank().getName())) {
            return 0.03;
         } else {
            return 0.06;
         }
      }
   }
}
