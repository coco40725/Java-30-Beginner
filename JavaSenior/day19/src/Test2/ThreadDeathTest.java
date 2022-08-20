/*
* 死鎖 Deadlock:
* 1. 不同的thread分別占用對方需要的 鎖 不釋放，都在等待對方釋放，導致所有threaad 僵持在那，程式無法結束:
*  thread A 拿著 (鎖1) 正在等著拿到 (鎖2) 才要釋放 (鎖1)
*  thread B 拿著 (鎖2) 正在等著拿到 (鎖1) 才要釋放 (鎖2)
*
* 2. 如何避免 Deadlock ?
*    a. 考慮專門的算法
*    b. 少用同步機制
*    c. 竟量避免用鑲嵌synchronized
*    d. 避免鎖彼此嵌套
*
* */
package Test2;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 02:36
 */
public class ThreadDeathTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {

                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
