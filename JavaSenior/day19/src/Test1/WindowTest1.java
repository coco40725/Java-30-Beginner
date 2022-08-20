/*
* 解決thread安全問題: 例如 錯票 或 重票
* 原因: thread 1 正在執行購票行為時，還沒把 ticket 扣除並更新，結果thread 2 也跟著過if判斷，然後近來搶票，導致共享數據出現異常
* code:
* if (ticket > 0 ){
*  System.out.println(ticket);
* ticket --;
* }
*
*
* ticket = 1
* thread 1 -- > if (ticket > 0) -- true ---> 進入方法體中 --> 阻塞 xx秒 (.....) --> 執行System.out.println(ticket) --> 阻塞 xx 秒 (.....) --> ticket -- ，此時ticket = 0
*                                               thread 2 -->   if (ticket > 0)  -- true --->  進入方法體中 --> 阻塞 xx秒 (.....) --> 執行System.out.println(ticket) --> 阻塞 xx 秒 (.....) --> ticket  -- ，此時ticket = -1
*
* 可見 thread 1還來不及拿走ticket，thread2 就成功進入方法體中，導致出現 錯票!
* 如何解決: 當有thread在方法體中進行操作時，其它的thread不得進入，直到thread 處理完畢離開，其它thread才可進入! 即使方法體裡面的thread出現 阻塞，其它thread亦不可進入!
* 在java中我們會使用 同步機制 (synchronized)來解決。雖然說同步機制可以預防安全問題，然而這樣的操作卻使方法體變成"單線程"，效率降低。
*
* 方法一: synchronized code block
* synchronized (同步監視器){
*   需要同步的code,即有操作共享數據的 code!
* }
* 共享數據: 多個thread 共同操作的數據或變數
* 同步監視器 (synchronized monitor): 俗稱 鎖 (synchronized lock)， 任何class的對象都能當鎖，所有thread必須"共用同一個鎖"!
* 注意: synchronized 不要多包，因為會大幅降低效率! 另外，可能會導致錯誤
*
* 方法二: synchronized method
* 如果操作共享數據的code正好在一個方法中，則可以把這個方法聲明成 synchronized method
* synchronized method 也是有鎖，他是用 this 或 當前類.class 來當鎖!
* ex. private synchronized boolean buyTicket(): 非靜態方法，默認的鎖為 this
*     private static synchronized boolean buyTicket(): 靜態方法，默認的鎖為 當前類.class
*
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-16-PM 03:49
 */

class Window1 implements Runnable{
    private int ticket = 10000; // 不需要 static !
    Object obj = new Object(); // 必須共用一個鎖
    @Override
    public void run() {
        boolean is_ticket = true;
        while (is_ticket){
             is_ticket = buyTicket();
        }
    }

    private synchronized boolean buyTicket(){
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

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1(); // 都是使用同一個 w1，故不需要對 ticket加 static!
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}