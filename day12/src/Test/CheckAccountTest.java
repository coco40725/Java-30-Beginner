package Test;

public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount p = new CheckAccount(1122, 20000,0.045,5000);
        p.withdraw(5000);
        System.out.println("您的帳戶餘額為: " + p.getBalance() + ", 可透支餘額: " + p.getOverdraft());
        p.withdraw(18000);
        System.out.println("您的帳戶餘額為: " + p.getBalance() + ", 可透支餘額: " + p.getOverdraft());
        p.withdraw(3000);
        System.out.println("您的帳戶餘額為: " + p.getBalance() + ", 可透支餘額: " + p.getOverdraft());

    }
}

