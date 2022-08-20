/*
* 銀行帳戶: 帳號、密碼、存款餘額、利率、最小餘額
* 帳號要自動生成
*
*
*
* */
package Test2;

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account("a125d%j", 3000);
        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(a1.getPassword());
        System.out.println(a1.getMinMoney());
    }
}
