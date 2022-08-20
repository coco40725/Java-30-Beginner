/*
 * 銀行有一個帳戶，
 * 有兩個儲戶 分別 往裡面存3000元，每次存1000，共存3次，每次存完 print出餘額
 * 分析:
 * 1. multiple Thread
 * 2. 有共享數據
 * 3. 一定有thread安全問題，必須考慮同步機制
 *
 * */

package Exer1_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 03:58
 */

class Account{
    private int balance;
    private ReentrantLock lock = new ReentrantLock();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void deposit(double amt){
        if (amt > 0) {
            try {
                Thread.sleep(100);
                balance += amt;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Customer extends Thread{
    private Account acct;
    private int customerSaveMoneyNum = 0;

    public Customer(Account acct) {
        this.acct = acct;
    }

    public void run() {
        while (customerSaveMoneyNum < 3 ){
            acct.getLock().lock();
            try {
                acct.deposit(1000);
                System.out.println(this.currentThread().getName() + "進行存錢, Balance: " + acct.getBalance());
                customerSaveMoneyNum++;
            } finally {
                acct.getLock().unlock();
            }
        }
    }
}

public class AccountTest1 {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.start();
        c2.start();

    }
}
