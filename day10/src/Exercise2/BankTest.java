package Exercise2;

public class BankTest {
    public static void main(String[] args) {
        Bank b1 = new Bank(50);

        b1.addCustomer("Jane", "Smith");
        b1.getCustomers(0).setAccount(new Account(2000));
        b1.getCustomers(0).getAccount().withdraw(130);
        double b1_balance = b1.getCustomers(0).getAccount().getBalance();
        System.out.println(b1_balance);


        b1.addCustomer("Wang", "Amy");
        b1.getCustomers(1).setAccount(new Account(2000));



    }
}
