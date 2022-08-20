package Test3;
/*
* thread communication : 複數個thread 交互使用
* 例子: 使 thread 1 與 thread 2 交互print 出 1~100。
* notify () , notifyall 與 wait()
* 1. wait(): thread進入阻塞，並將同步監視器拋出。
* 2. notify(): 喚醒正在 被wait的 single thread，若有多個被wait()則喚醒優先級高的。
* 3. notifyall(): 喚醒正在 wait的 all thread
* 說明:
* a. 這三種methods 必須使用在 synchronized () 或 synchronized method ; 不適用在 lock unlock
* b. 這3個調用者，必須是synchronized () 或 synchronized method 中 的 "同步監視器" 進行調用，否則會出現IllegalMonitorStateException，例如:
*
* synchronized (this){
* this.notify();
* this.wait();
* }
 * synchronized (obj){
 * obj.notify();
 * obj.wait();
 * }
 * c. 這三個方法其實是在 Object class中定義的
 * d. sleep 與 wait的差異:
 *    d1. 定義位置: sleep是定義在 Thread中; wait是定義在 Object
 *    d2. 調用的範圍: sleep可以在任何需要的場景下調用; wait則需要被 "同步監視器" 調用，故只能在 synchronized () 或 synchronized method 中 使用
 *    d3. 是否釋放同步監視器: sleep不釋放; wait會釋放
* */
/**
 * @author Yu-Jing
 * @create 2022-06-20-AM 11:44
 */

class Number implements Runnable{
    private int num = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj) {
                obj.notify();
                if (num <= 500){
                    System.out.println(Thread.currentThread().getName()+ ", 輸出數字: " + num);
                    num++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else{
                    break;
                }
            }
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        Number num = new Number();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.start();
        t2.start();


    }
}
