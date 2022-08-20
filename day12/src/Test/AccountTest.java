package Test;

public class AccountTest {
    public static void main(String[] args) {
        Account p = new Account(1122, 20000,0.045);
        p.withdraw(30000);
        System.out.println("您的帳戶餘額為: " + p.getBalance());
        p.withdraw(2500);
        System.out.println("您的帳戶餘額為: " + p.getBalance());
        p.deposit(3000);
        System.out.println("您的帳戶餘額為: " + p.getBalance());
        System.out.println("您的帳戶月利率為: " + p.getMonthlyInterest()*100 + "%" );
    }
}
