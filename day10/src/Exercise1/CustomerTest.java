package Exercise1;
/*
* 建立一個customer ，名字為 Jane Smith，他的id 為1000, 餘額為 2000, 年利率為1.23。
* 對 Jane Smith 操作:
* 存100元，再取出960元。 再取出2000元
* print出 Jane Smith 基本訊息
*
* */

public class CustomerTest {
    public static void main(String[] args) {
        Customer cust = new Customer("Jane", "Smith");
        Account acc = new Account(1000, 2000.0, 1.23);
        cust.setAccount(acc);


        acc.deposit(100);
        acc.withdraw(960);
        acc.withdraw(230);
        System.out.println("Customer [" + cust.getLastname() + "," +cust.getFirstname() + "] " + "has a account: " + "id is " + acc.getId() + ",");
        System.out.println("annualRate is " + acc.getAnnualInterRate() + "%, " + "balance is " + acc.getBalance()) ;


        // 或者 你也可以這樣寫
        /*
        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(2000);
        System.out.println( cust.getAccount().getBalance());
        * */




    }
}
