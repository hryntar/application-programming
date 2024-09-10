package LabWork_1.Task6_7;

public class Main {
   public static void main(String[] args) {
      Bank bank1 = new Bank("monobank", "UAH");
      Bank bank2 = new Bank("bankofamerica", "USD");

      User nazar = new User("Nazar");
      User sofia = new User("Sofia");

      BankAccount nazarAccountUAH = new BankAccount("UAH_1", nazar, bank1, 15000);
      BankAccount nazarAccountUSD = new BankAccount("USD_2", nazar, bank2, 500);
      BankAccount sofiaAccountUAH = new BankAccount("UAH_3", sofia, bank1, 17000);

      nazar.addAccount(nazarAccountUAH);
      nazar.addAccount(nazarAccountUSD);
      sofia.addAccount(sofiaAccountUAH);

      bank1.addAccount(nazarAccountUAH);
      bank1.addAccount(sofiaAccountUAH);
      bank2.addAccount(nazarAccountUSD);

      CurrencyConverter converter = new CurrencyConverter();

      nazarAccountUAH.transferTo(nazarAccountUSD, 1000, converter);
      sofiaAccountUAH.transferTo(sofiaAccountUAH, 500, converter);
   }
}