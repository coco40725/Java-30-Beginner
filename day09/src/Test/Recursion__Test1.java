package Test;

import Lession.Recursion;

import java.util.ResourceBundle;

public class Recursion__Test1 {
    public static void main(String[] args) {
        Recursion__Test1 r1 = new Recursion__Test1();
        // Fibonacci 計算並print出整個數列


        // 方法1.
        r1.Fib1(10);
        System.out.println();

        // 方法2.
        for (int i = 1; i <= 10; i++){
            System.out.print(r1.Fib2(i)+ " ");
        }



    }



    public void Fib1(int n){
        int[] arra = new int[n];
        for (int i = 0; i < n ; i++){
            if (i == 0 || i == 1){
                arra[i] = 1;
                System.out.print(1 + " ");
            } else {
                arra[i] = arra[i - 1] + arra[i - 2];
                System.out.print(arra[i] + " ");
            }
        }
    }

    public int Fib2(int n){
        if (n == 1 || n == 2){
            int sum = 1;
            return 1;
        }else {
            int sum  = Fib2(n - 1) + Fib2(n - 2);
            return sum;
        }

    }

}
