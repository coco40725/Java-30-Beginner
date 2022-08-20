/*
* 銀行有一個帳戶，
* 有兩個儲戶 分別 往裡面存3000元，每次存1000，共存3次，每次存完 print出餘額
* 分析:
* 1. multiple Thread
* 2. 有共享數據
* 3. 一定有thread安全問題，必須考慮同步機制
*
* */
package Exer1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 03:39
 */


class Customer implements Runnable{
    private static int balance = 0;
    private int customerSaveMoneyNum = 0;
    private static ReentrantLock lock = new ReentrantLock();



    @Override
    public void run() {
        while (customerSaveMoneyNum < 200 ){
            lock.lock();
            try {
                balance += 1000;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "進行存錢, Balance: " + balance);
                customerSaveMoneyNum++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();


    }
}

