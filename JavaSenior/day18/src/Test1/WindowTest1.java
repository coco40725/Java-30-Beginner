/*
使用方法二:
* 創建3個窗口 來買票，總票數為 100 張
* (存有 thread安全問題!!)
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-16-PM 02:47
 */

class Window1 implements Runnable{
    private int ticket = 100; // 不需要 static !
    @Override
    public void run() {
        while (true){
            if (ticket > 0 ) {
                System.out.println(Thread.currentThread().getName() + " 賣票， 票號: " + ticket);
                ticket--;
            }else {
                break;
            }

        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1(); // 都是使用同一個 w1，故不需要對 ticket加 static!
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}
