/*
* 在方法A中，調用 A方法，類似一種循環
* 甚麼時候才能寫成遞迴方法?
* 基本上只要 f(n) = g (f(m1), f(m2),...f(mn)), and mn < n.
* 則可以寫成遞迴式
*
*
* */
package Lession;

import java.util.Random;

public class Recursion {
    public static void main(String[] args) {
        // 計算 1~100 所有自然數的
        // 方法1:
        int sum1 = 0;
        for (int i = 1; i < 101 ; i++){
            sum1 += i;
        }
        System.out.println(sum1);

        //方法2:
        Recursion r1 = new Recursion();
        int sum2 = r1.getSum(100);
        System.out.println(sum2);


    }

    public int getSum(int n){
        if (n == 1) {
            return 1;
        }else {
            return n + getSum(n-1);
        }
    }


}
