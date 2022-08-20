/*
使用方法一:
* 創建3個窗口 來買票，總票數為 100 張
* (存有 thread安全問題!!)
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-16-PM 01:54
 */

class Window extends Thread{
    private static int ticket = 100; // 讓所有對象共用同一個變數
    @Override
    public void run() {
        while (true){
            if (ticket > 0 ) {
                System.out.println(this.getName() + " 賣票，票號: " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}

public class WindowTest {
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
