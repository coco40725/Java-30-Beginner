package Test2;
/*
* JDK 5.0 後新增兩個方式來解決Thread 安全問題: Lock 鎖 (Interface)
* 方法一:
* 1. 實例化ReentrantLock
* 2 .調用 ReentrantLock 之 lock 方法
* 3. 用 try-finally 將將有操作共同數據的code包起來
* 4. 在finally 調用ReentrantLock 之 unlock 方法
* 注意: 建議把lock 放在 try外面 (雖然你放try裡面或外面執行起來結果都一樣)，主因是 若很不幸地妳沒有加鎖成功，則理論上來說你也不需要解鎖，
* 硬去解鎖會出現exception，因此，若把lock放在try裡面，會導致即使你加鎖失敗，仍會執行unlock，進而出現exception。 (https://stackoverflow.com/questions/10868423/lock-lock-before-try )
*
* Q1. synchronized 與 lock 差異
* A. synchronized機制 當執行完同步code，會"自動"解鎖釋放； lock則是需要"手動"指定何時 鎖上 (開始同步)、開鎖 (結束同步)
*
* Q2. 可以解決 thread安全的方法:
* B. synchronized code block、 synchronized method、lock
 *
* 開發中建議使用的同步機制:
* lock (較靈活) --> synchronized code block --> synchronized method
*
*
* */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 03:00
 */

class WindowLock  implements Runnable{
    private int ticket = 100; // 不需要 static !
    //1. 實例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true){
            //2 .調用 ReentrantLock 之 lock 方法
            lock.lock();
            //3. 用 try-finally 將將有操作共同數據的code包起來
            try {
                if (ticket > 0 ) {
                    System.out.println(Thread.currentThread().getName() + " 賣票， 票號: " + ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //4. 在finally 調用ReentrantLock 之 unlock 方法
                lock.unlock();
            }
        }
    }
}

public class Locktest {
    public static void main(String[] args) {
        WindowLock w1 = new WindowLock(); // 都是使用同一個 w1，故不需要對 ticket加 static!
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}
