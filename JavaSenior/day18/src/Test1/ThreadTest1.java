package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-16-PM 02:25
 */

// 1. 創建一個實現runnable 接口的類
class Mythread implements Runnable{

    // 2. 實現 runnable的 abstract method, 即run method
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 創建 實現類 的instance
        Mythread m1 = new Mythread();
        //4. 將此instance 作為 formal parameter 加入 Thread constructor
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        //5. 通過thread class 調用 start
        t1.start(); // 若thread之constructor有使用到 runnable，則 run function,會用 runnable object's run function 執行
                    // 否則不執行 (除非你有override)
        t2.start();


    }

}
