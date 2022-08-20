/*
Loop 結構:
1. 初始執行程式碼, ex. 定義int i = 0 或者 System.out.println("...")
2. 循環條件: boolean , ex. price > 0
3. 循環過程: ex. price - i
4. 跌代執行程式碼: ex. ++i，若要複數個則以","區隔: ++i, ++j, System.out.println("....")
5. 注意! 在loop 結構"內" 所定義的變數，皆不被存在記憶體內，換言之，出了loop 結構後，該變數皆無法調用，除非，你一開始就建好

a. For 寫法
for (初始執行程式碼; 循環條件; 跌代執行程式碼){
    循環過程
}

注意! 在for loop 初始執行程式碼 這裡所定義的"所有變數" 是不被存在記憶體的，換言之，出了for，是無法調用i的!

*/


/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\ForLoop.java
java -classpath D:\Java_lession\1_basic\code\day05 ForTest
*/

import java.util.Scanner;
import java.lang.Math;

class ForTest{
    public static void main (String args[]){
        

        //連續輸出 10 個 hello world
        for (int i = 1 ; i <= 5 ; ++i){
            System.out.println("Hello World!");

        }

        // 練習 1: 輸出 abcbcbc
        int num = 1;
        for (System.out.print("a") ; num <= 3 ; System.out.print("c"), ++num){
            System.out.print("b");
        }

        // 練習 2: 輸出 100以內的偶數，與加總和 個數
        int sum = 0;
        int count = 0;
        for (int i = 0; i<=100; i+=2) {
            System.out.println(i);
            sum += i;
            count += 1;
        }
        System.out.println(sum);
        System.out.println(count);

        // 輸入兩個整數，求其最大公約數 最小公倍數

        Scanner scan = new Scanner(System.in);
        System.out.println("請輸入第一個正整數: ");
        int n1 = scan.nextInt();

        System.out.println("請輸入第二個正整數: ");
        int n2 = scan.nextInt();

        int min = (n1 < n2) ? n1 : n2 ;
        int max = (n1 > n2 ) ? n1 : n2;
        
        for (int i = min ; true; --i){
            if (n1 % i == 0 && n2 % i == 0){
                System.out.println("最大公約數: " + i);
                break;
            }

        }

        for (int j = max ; true; ++j){
            if (j % n1 == 0 && j % n2 == 0){
                System.out.println("最小公倍數: " + j);
                break;
            }
        }


        // 輸出所有三位數，並計算其水仙花數

        for (int k = 100; k <= 999 ; ++k){
            int i_100 = k / 100;
            int i_10 = (k - i_100 * 100) / 10;
            int i_1 = k - i_100 * 100  - i_10 * 10;
            
            double sum_3 = Math.pow(i_100,i_100) + Math.pow(i_10,i_10) + Math.pow(i_1,i_1);
            System.out.println(sum_3) ;



        }
        

        

    }

}

