/*
1. Switch 寫法 :

switch(表達式){
    case output_1: [表達式 的值為output_1 則 "從此行開始往下執行，直到switch結束"]
     to do code....
     // break;


    case output_2: [表達式 的值為output_2 則 "從此行開始往下執行，直到switch結束"]
     to do code ....
     // break;


    default: [表達式 的值不在case 則 "從此行開始往下執行"]
     to do code .... 
     // break;

}

2. 如果想要的效果是，當表達式的值為output_1，則僅執行該case下的code，那麼我們需要在那個case下寫 break;
3. 表達式的類型只能是 byte, short, char, int, String (JDK7.0 新增), enum(列舉, JDK5.0新增 ) 
4. 基本上可以用switch-case的結構，皆可轉換成if-else，反之不然；基本上，switch-case 執行效率略高於if-else 

 */

// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day04\SwitchCase.java
// java -classpath D:\Java_lession\1_basic\code\day04 Switch_Test


import java.util.Scanner;
 class Switch_Test{
     public static void main (String args[]){
         Scanner scan = new Scanner(System.in);
         System.out.println("請輸入0-3: ");
         int number = scan.nextInt();

         switch (number) {
             case 0:
             System.out.println("zero");

             case 2: 
             System.out.println("two");

             case 1:
             System.out.println("one");

             case 3:
             System.out.println("three");

             default:
             System.out.println("other");


         }

     }
 }