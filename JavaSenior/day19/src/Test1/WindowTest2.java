package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 12:08
 */
class Window extends Thread{
    private static int ticket = 10000; // 讓所有對象共用同一個變數
    private static Object obj = new Object(); // 必須保證所有thread共用同一個鎖
    @Override
    public void run() {
        while (true){
            synchronized (obj) { // 或使用 Window.class ，這個只會存一個
                if (ticket > 0 ) {
                    System.out.println(this.getName() + " 賣票，票號: " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("Window 1");
        w2.setName("Window 2");
        w3.setName("Window 3");

        w1.start();
        w2.start();
        w3.start();

    }

}