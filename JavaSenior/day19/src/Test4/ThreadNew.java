/*
* 使用 Callable implement 創建 Thread
* 1. 創建一個實現Callable的類
* 2. override call method，將thread欲操作的code，聲明其中，且此方法可以有返回值
* 3. 於main方法:
*       3.1 創建 實現Callable的類 之對象
*       3.2 創建 FutureTask 類的對象
*       3.3 啟動thread: 將FutureTask 作為參數填入Thread class
*       3.4 (option): 使用Callable的類 中的get 方法調出call的返回值
*
* ---------------------------------------------------------------------------------
* Callable 比 Runaable 還要強大!
* 1. Callable call() 可以有返回值
* 2. Callable call() 可以throw Exception
* 3. Callable 支持泛型
*
* */
package Test4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Yu-Jing
 * @create 2022-06-21-PM 02:21
 */

// 1. 創建一個實現Callable的類
class NumThread implements Callable{
    // 2. override call method，將thread欲操作的code，聲明其中，且此方法可以有返回值
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0 ; i < 101 ; i++){
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadNew {
    public static void main(String[] args) {
        // 3.1 創建 實現Callable的類 之對象
        NumThread thread1 = new NumThread();
        // 3.2 創建 FutureTask 類的對象
        FutureTask task = new FutureTask(thread1);
        // 3.3 啟動thread: 將FutureTask 作為參數填入Thread class
        new Thread(task).start(); // 因為Callable 也實現了 Runnable


        // 3.4 (option): 使用Callable的類 中的get 方法調出call的返回值
        try {
            // get method的返回值 即為 Callable call method(override) 所回傳的值
            Object sum = task.get();
            System.out.println("總合為: " + sum);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
