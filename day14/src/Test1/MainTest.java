/*
* main() 方法的使用:
* 1. main方法作為程式的入口
* 2. main方法也是一個普通的靜態方法
* 3. main()方法可以透過 formal parameter與控制台進行互動
*
* */
package Test1;

public class MainTest {
    public static void main(String[] args) {
        Main.main(new String[100]);

    }

}

class Main{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}
