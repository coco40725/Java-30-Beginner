/*
* Thread Pool:
* 1. 創建池子: ExecutorService service = Executors.newFixedThreadPool(10)
* a. newFixedThreadPool: 固定數量thread的池子
* b. newScheduledThreadPool: 給定延遲後執行thread 或 週期性執行
* c. newSingleThreadExecutor: 只有一個thread
* d. newCachedThreadPool: 可根據需要創建thread
*
* 2. 啟動thread: service.execute(Runnable) 或 service.submit(Callable)
* 3. 關閉thread: service.shutdown()
* 4. (optional)，若使用callable想要取得return 值，則需要使用futureTask!
*
* ------------------------------------------------------------------------------
* Thread Pool 好處 (開發中常用)
* 1. 減少重複創建 / 刪除 thread的時間與流程
* 2. 降低資源消耗
* 3. 便於管理，可以控制各種屬性
* -------------------------------------------------------------------------------
* Thread Pool 屬性 (但是這些屬性不在ExecutorService中，而是在 此interface的 實現類ThreadPoolExecutor )
* corePoolSize: 核心池的大小
* maximumPoolSize: 最大thread 數量
* keepAliveTime: thread閒置時，最多保持多久時間後便終止
*
* public class ThreadPoolExecutor extends AbstractExecutorService
* abstract public class AbstractExecutorService implements ExecutorService
*
* */
package Test4;

import java.util.concurrent.*;

/**
 * @author Yu-Jing
 * @create 2022-06-21-PM 04:17
 */
class NumThread1 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 101; i++){
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
class NumThread2 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 101; i++){
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumThread3 implements Callable {


    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 101; i++){
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
        return 123;
    }
}

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10); // 創一個池子

        // 設定 Thread Pool的屬性
        System.out.println(service.getClass()); // ThreadPoolExecutor
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(5);


        NumThread3 numThread3 = new NumThread3();
        FutureTask futureTask = new FutureTask(numThread3);
        // newFixedThreadPool ()會返回 ExecutorService，而 ExecutorService 為 interface

        service.execute(new NumThread1());  // 輸入 Runnable，開啟thread
        service.execute(new NumThread2());  // 輸入 Runnable，開啟thread
        service.submit(futureTask); //  輸入 Callable，開啟thread

        // 若想return ，則要使用 FutureTask
        Object num = futureTask.get();
        service.shutdown(); // 關掉
        System.out.println("輸出" + num);

    }
}
