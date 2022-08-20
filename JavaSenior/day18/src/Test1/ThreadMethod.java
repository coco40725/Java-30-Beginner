/*
* Thread 常用 method:
* 1. start(): 啟動 當前thread 並調用 當前thread的run function
* 2. run(): 方法體為 欲執行的code，通常需要override
* 3. currentThread(): static method, return 當前thread (return Thread class)
* 4. getName(): 取得當前thread name (return String)
* 5. setName(String): 設置當前thread 名字
* 6. yield(): 釋放當前cpu的執行權，讓cpu重新選擇要執行哪個thread(有可能又回到執行此thread!)
* 7. join(): 在 thread A 中調用 thread B .join，此時，thread A 會進入暫停狀態， 直到 thread B 執行完畢， thread A才會再次執行
* 8. stop(): thread 強制結束， 此方法已過時不推薦使用。
* 9. sleep(long milltime): static method, 使當前 thread 進入休眠，自訂休眠時間。
* 10. isAlive(): 判斷當前thread 是否還在執行
* 11. Thread Priority:
*     MAX = 10
*     NORM = 5
*     MIN = 1
*    setPriority(int newPriority): 設定優先度
*    getPriority(): 取得當前thread的優先度
*    Note: 這裡的 priority高，只代表 高機率此thread會被cpu選中執行
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-16-AM 11:13
 */

class Myclass1 extends Thread{
    public Myclass1(String name){
        super(name);
    }
    public Myclass1(){}
    //2.  override Thread類 的 run method，  將想要執行的code 聲明的run method中
    @Override
    public void run() {
        // print 1~100 之偶數
        for (int i = 0; i < 101; i++){
            if (i % 2 == 0) System.out.println(Myclass1.currentThread().getName() + ": " + i +", Priority: " + Myclass1.currentThread().getPriority());

//            if (i % 20 == 0) this.yield();
        }


    }
}
public class ThreadMethod {
    public static void main(String[] args) {
        Myclass1 myclass1 = new Myclass1();
//      Myclass1 myclass2 = new Myclass1("Thread-Fuck");
        myclass1.setName("Thread-G");
        myclass1.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        myclass1.start();
        //myclass2.start();
        // 是主線程執行，且與Thread 1 同時執行
        for (int j = 0; j < 100; j++) {
            if (j % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + j + ", Priority: " + Thread.currentThread().getPriority());
//            System.out.println(myclass1.isAlive());
//            if (j == 20) {
//                try {
//                    myclass1.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
    }
}
