public class BankAccount {
    private double balance;
    private double DepositFee;
    private double[] freeDeposits;
    private byte timeLeftInMonth;

    public BankAccount(){
        DepositFee = 0.5;
        freeDeposits = new double[]{/* Free Deposits Remaining */ 10, /* Each Month Allocation */ 10, /* Months Total Fees */ 0};
        balance = 0;
        timeLeftInMonth = 30;
    }
    public BankAccount(double initialBalance){
        DepositFee = 0.5;
        freeDeposits = new double[]{/* Free Deposits Remaining */ 10, /* Each Month Allocation */ 10, /* Months Total Fees */ 0};
        balance = initialBalance;
        timeLeftInMonth = 30;
    }

    public void deposit(double amount){
        balance += amount;
        if (freeDeposits[0] == 0) freeDeposits[2] += DepositFee;
        else freeDeposits[0]--;
    }

    public void withdraw(double amount){
        balance -= amount;
        if (freeDeposits[0] == 0) freeDeposits[2] += DepositFee;
        else freeDeposits[0]--;
    }

    public double getBalance() {
        return balance;
    }

    public void deductMonthlyCharge(){
        balance -= freeDeposits[2];
        freeDeposits[0] = freeDeposits[1];
        freeDeposits[2] = 0;
    }

    public void setFee(double num){
        DepositFee = num;
    }

    public void setFreeDeposits(int num){
        freeDeposits[0] = num;
        freeDeposits[1] = num;
    }

    public void passTime(){
        timeLeftInMonth--;
        if (timeLeftInMonth == 0){
            deductMonthlyCharge();
        }
        timeLeftInMonth = 30;  // no Leap years or 31 day months or even, gasp 28 day months
    }

    public void setBankAccount(int balance){
        this.balance = balance;
        setFreeDeposits(10);
        freeDeposits[2] = 0;
    }
}

