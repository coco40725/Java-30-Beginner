package Test2;

public class Account {
    private int id;
    private String password = "000000";
    private double balance = 0.0;

    private static double InterestRate;
    private static double MinMoney = 1.0;
    private static int init = 1001;

    public Account(){
        id = init++;
    }

    public Account(String password, double balance){
        this();
        this.balance = balance;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return InterestRate;
    }

    public static void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    public static double getMinMoney() {
        return MinMoney;
    }

    public static void setMinMoney(double minMoney) {
        MinMoney = minMoney;
    }
}
