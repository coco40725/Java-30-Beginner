package Test;

/*
* 定義一個 int[] 10 element (隨機生成整數)，求最大值、最小值、總和、平均值，並輸出
* note: 要求全部是兩位數
*
* 1. 建立 10 element 空int[]
* 2. for
* 3. 隨機生成整數，並且為 10 ~ 99
* 4. 紀錄 max. min, sum, average
*
* */

import java.lang.Math;
public class Array_Test3 {
    public static void main(String[] args) {

        // 建立初始，之後要output的東西
        int[] arr1 = new int[10];
        int max = 0;
        int min = 0;
        double sum = 0.0;
        double average;


        // 抽10次2位數
        for (int i = 0; i < arr1.length ; i++){

            // 抽數字
            int num = (int)(Math.random()*90 + 10); // [0.0, 1.0) * 90 + 10
            arr1[i] = num;
            System.out.print(arr1[i] + " ");


           // 將首值賦給 max, min, sum
            if (i == 0){
                max = arr1[i];
                min = arr1[i];
                sum = 0;
            }


            // max
            if (arr1[i] > max ) {
                max = arr1[i];
            }

            // min
            if (arr1[i] < min){
                min = arr1[i];
            }

            // sum
            sum += sum + arr1[i];

        }

        average = sum / arr1.length;
        System.out.println();

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);


    }
}
