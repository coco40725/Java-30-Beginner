/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\Test01\LoopTest.java
java -classpath D:\Java_lession\1_basic\code\day05\Test01 LoopTest
*/

import java.util.Scanner;

class LoopTest {
    public static void main (String args[]){
        // 輸入任意整數，判斷是正數還是負數並累計數目，不斷執行，直到輸入0，跳出後顯示累計數目

        System.out.println("請輸入數值: ");
        Scanner scan = new Scanner(System.in) ;
        int num = scan.nextInt();
        int positive_count = 0;
        int negative_count = 0;

        while (num != 0){
            if (num > 0){
                System.out.println("正數");
                positive_count += 1;
                
            } else {
                System.out.println("負數");
                negative_count += 1;
            }
            
            System.out.println("請輸入數值: ");
            scan = new Scanner(System.in) ;
            num = scan.nextInt();
        }
        System.out.println("目前累積的正數數目: " + positive_count + "; 負數數目: " + negative_count);
    }
}