/*
* 創建multiple thread
* A.方法一: extends Thread
*   1. 創建繼承Thread的子類
*   2. override Thread類 的 run method，  將想要執行的code 聲明的run method中
*   3. 創建子類對象
*   4. 通過此對象調用此start method，注意 不可以讓已經start的thread，再start，會報illegalthreadstateexception (因為 thread status != 0)
* 例子: print  出 1~100所有的偶數
*
* B. 方法二: implement Runnable
*   1. 創建一個實現runnable 接口的類
*   2. 實現 runnable的 abstract method, 即run method
*   3. 創建 實現類 的instance
*   4. 將此instance 作為 formal parameter 加入 Thread constructor
*   5. 通過thread class 調用 start
*
* 比較兩方法:
* 1.  開發中，優先選擇 Runnable方式，如此才不會占用父類
* 2.  Runnable方式 較天然地實現 "共享" 數據
* 3.
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-15-PM 04:02
 */

//1. 創建繼承Thread的子類
class Myclass extends Thread{
        //2.  override Thread類 的 run method，  將想要執行的code 聲明的run method中
    @Override
    public void run() {
        // print 1~100 之偶數
        for (int i = 0; i < 101; i++){
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //  3. 創建子類對象
        Myclass mythread = new Myclass();
        Myclass mythread1 = new Myclass();

        // 4. 通過此對象調用此start method: 啟動新的thread (Thread 1 )--> 調用 thread run method
        mythread.start();
        // mythread.start();  illegalthreadstateexception
        mythread1.start(); // 要透過新對象才能再開啟一個新thread
        // 是主線程執行，且與Thread 1 同時執行
        for (int j = 0; j < 500; j++) System.out.println(Thread.currentThread().getName() + ": " + j); // 這一條是主線程執行，且與Thread 1 同時執行
        // (不是 Thread 1 執行完 才執行上  System.out.println("main Thread: " + j) 喔!)
    }

}
