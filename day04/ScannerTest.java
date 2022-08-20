/*
如何從鍵盤直接輸入東西給程式碼，然後程式碼output結果，需要使用Scanner 相關的package:
步驟:
1. 輸入package: import java.util.Scanner
2. 該package 已定義好Scanner class, 可以直接用此class Scanner scan = new Scanner(System.in)
3. 調用該class下的method，來得到指定變數類型的變量


 */

// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day04\ScannerTest.java
// java -classpath D:\Java_lession\1_basic\code\day04 ScannerTest


import java.util.Scanner;

class ScannerTest {
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("請輸入名字:");
        String name = scan.next(); // 指定輸入的data類型: 字串 ，輸入錯誤會終止運行
        System.out.println(name);

        System.out.println("請輸入年齡:");
        int age = scan.nextInt(); // 指定輸入的data類型: double
        System.out.println(age);

        System.out.println("請輸入體重:");
        double weight = scan.nextDouble(); // 指定輸入的data類型: int
        System.out.println(weight);

        System.out.println("你是否單身:");
        boolean ask = scan.nextBoolean(); // 指定輸入的data類型: int
        System.out.println(ask);

        System.out.println("性別(男/女)");
        String sex = scan.next();
        char sex0 = sex.charAt(0); // string第1個位置的字母
        System.out.println(sex0);


        

        


    }
}