/*
* 1. Lambda的寫法:
*  a. 適用在 Interface 且只有一個方法要override，一種更為簡潔的寫法
*  b. 格式: Interface name = (參數名稱) -> {
      方法體
*   }
*     b1. -> 稱為 lambda 操作子
*     b2. (參數名稱) 稱為 lambda形參列表
*     b3. 方法體 稱為 lambda方法體
*
* c.  Lambda使用的6種情況
*
*
* d. Lambda的本質: 作為函數式接口的對象
* e. 如果此接口中，只聲明一個 abstract method，則稱此接口為 函數式接口，會有註解 @FunctionalInterface
* */
package Test2;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Yu-Jing
 * @create 2022-08-17-PM 02:36
 */
public class LambdaTest {
    // 情況 1: 無形參，無返回值
    @Test
    public void test(){
        Runnable runnable = () -> {
            System.out.println("cool!");
        };
    }

    // 情況 2:  有形參 (指名參數type)，無返回值
    @Test
    public void test1(){
        Consumer<String> con = (String s) -> {
            System.out.println(s);
        };
        con.accept("GG!");
    }

    //  情況 3:  有形參 (無需指名參數type，可以自動推斷出來)，無返回值
    @Test
    public void test2(){
        Consumer<String> con = (s) -> { // 泛型已經暗示一定要input String
            System.out.println(s);
        };
        con.accept("GG!");
    }

    // 情況 4: 若只需要一個形參，()可以直接省略
    @Test
    public void test3(){
        Consumer<String> con = s -> {
            System.out.println(s);
        };
        con.accept("GG!");
    }

    @Test
    // 情況 5: 兩個以上的形參，多條執行語句，並且可以有返回值
    public void test4(){
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println("compare!");
            return Integer.compare(o1,o2);
        };

        comparator.compare(12,33);
    }

    @Test
    // 情況 6 : 當 Lambda方法體只有一條，return 與 {} 可以省略 (但要一起省略!!)
    public void test5(){
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1,o2);
        comparator.compare(12,33);

    }

}
