package Test;

public class CheckAccount extends Account{

    private  double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void withdraw(double amount){
        if (getBalance() >= amount){
            // getBalance() -= amount, 是錯誤的! 因為這等同於 對balance進行賦值!
            // 方法1: setBalance(getBalance() - amount);
            super.withdraw(amount);
        } else if (overdraft >=  amount - getBalance()) {
            System.out.println("透支額度足夠消費");
            overdraft -=  (amount - getBalance());
            setBalance(0); // 或 super.withdraw(getBalance())

        } else {
            System.out.println("超過可透支限額");
        }
    }

}
