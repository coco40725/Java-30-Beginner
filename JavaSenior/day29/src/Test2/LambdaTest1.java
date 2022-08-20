/*
* java 內置的4大核心 函數式接口:
*  1. Consumer<T> :  void accept(T t)
*  2. Supplier<T> :  T get()
*  3. Function<T,R> :  R applt(T t)
*  4. Predicate<T> : boolean test(T t)
*
* */
package Test2;

import org.testng.annotations.Test;

import java.util.function.Consumer;

/**
 * @author Yu-Jing
 * @create 2022-08-17-PM 03:31
 */
public class LambdaTest1 {

    @Test
    public void test1(){
        happlyTime(500,  );

    }
    public void happlyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
}
