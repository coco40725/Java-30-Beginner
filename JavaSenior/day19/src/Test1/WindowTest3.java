package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 01:33
 */

class Window3  implements Runnable{
    private int ticket = 10000; // 不需要 static !
    Object obj = new Object(); // 必須共用一個鎖
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

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3(); // 都是使用同一個 w1，故不需要對 ticket加 static!
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}
