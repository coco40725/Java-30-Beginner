package Test1.Exer;

/**
 * @author Yu-Jing
 * @create 2022-06-16-AM 11:03
 */

// print 0~100 偶數
class Function1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 101; i++){
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}


// print 0~100 奇數
class Function2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 101; i++){
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        // 方法1: 創建兩個 thread
//        Function1 f1 = new Function1();
//        Function2 f2 = new Function2();
//
//        f1.start();
//        f2.start();

        //方法2: 直接採用匿名子類
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 101; i++){
                    if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 101; i++){
                    if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }.start();

    }

}
