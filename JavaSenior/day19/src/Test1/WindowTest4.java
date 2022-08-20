package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 01:48
 */

class Window4 extends Thread{
    private static int ticket = 10000; // 讓所有對象共用同一個變數
    @Override
    public void run() {
        boolean is_ticket = true;
        while (is_ticket) {
            is_ticket = buyTicket();
        }
    }
    private static synchronized boolean buyTicket(){ // 同步監視器: Window4.class (唯一)，而非this!
        if (ticket > 0 ) {
            System.out.println(Thread.currentThread().getName() + " 賣票， 票號: " + ticket);
            ticket--;
            return true;
        }else{
            System.out.println(Thread.currentThread().getName() + ": 沒票了，滾啦!");
            return false;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("Window 1");
        w2.setName("Window 2");
        w3.setName("Window 3");

        w1.start();
        w2.start();
        w3.start();

    }
}
