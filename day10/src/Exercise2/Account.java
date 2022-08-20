package Exercise2;

public class Account {
    private double balance;

    public Account (double init_balance){
        balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw (double amount) { // 取錢
        if (amount < 0) {
            throw new RuntimeException("錯誤的數字，請重新輸入");
        } else {
            if (balance < amount) {
                throw new RuntimeException("餘額不足，無法提取");
            } else {
                balance -= amount;
                System.out.println("提取成功，" + "提取: " + amount + "元。" + "\t" + "目前帳戶餘額為 " + balance);
            }
        }
    }

    public void deposit (double amount){ // 存錢
            if (amount < 0) {
                throw new RuntimeException("錯誤的數字，請重新輸入");
            } else {
                balance += amount;
                System.out.println("存取成功，" + "已存取 " + amount + "元。" + "\t" + "目前帳戶餘額為 " + balance);
            }
        }


}
