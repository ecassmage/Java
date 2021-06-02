public class TestBankAccount {
    public static void main(String[] args){
        BankAccount Bank = new BankAccount(10000);
        for (double year = 0; year < 10000; year++) {
            for (double month = 0; month < 12; month++) {
                for (double day = 0; day < 30; day++) {
                    if (day % 3 == 0 || month % 9 == 2 || year % 17 == 1) {
                        if (Bank.getBalance() > 100000) Bank.deposit(year / 10);
                        else Bank.deposit(year);
                    }
                    if (day % 2 == 0 || month % 5 == 1 || year % 13 == 2) {
                        if (Bank.getBalance() < 0) Bank.withdraw(year / 10);
                        else Bank.withdraw(year / 2);
                    }
                    if (Bank.getBalance() % 9 == 0) {
                        Bank.withdraw(1000);
                    }
                }
                Bank.passTime();
            }
            if (year % 45 == 0) {
                System.out.println("Current Balance for year " + year + " is: " + Bank.getBalance());
            }
        }
        Bank.setBankAccount(1000);
        System.out.println("\nCurrent Balance is: " + Bank.getBalance());
        for (int i = 0; i < 9; i++)     {Bank.deposit(100);}
        System.out.println("\nCurrent Balance is: " + Bank.getBalance());
        for (int i = 0; i < 10; i++)    {Bank.withdraw(75);}
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.deductMonthlyCharge();
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.deductMonthlyCharge();
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.withdraw(75);
        Bank.withdraw(75);
        Bank.withdraw(75);
        Bank.withdraw(75);
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.deposit(100);
        Bank.deposit(100);
        Bank.deposit(100);
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.deductMonthlyCharge();
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.setFreeDeposits(0);
        Bank.setFee(1000);
        Bank.deposit(100);
        System.out.println("Current Balance is: " + Bank.getBalance());
        Bank.deductMonthlyCharge();
        System.out.println("Current Balance is: " + Bank.getBalance());
        BankAccount first = new BankAccount (100);
        BankAccount second = new BankAccount (100);
        BankAccount third = first;
        first.deposit (50.0);
        second.deposit (50.0);
        third.deposit (50.0);
        System.out.println (first.getBalance() + " " + second.getBalance() + " " + third.getBalance());
    }
}
