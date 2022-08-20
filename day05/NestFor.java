/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\NestFor.java
java -classpath D:\Java_lession\1_basic\code\day05 NestFor
java -classpath D:\Java_lession\1_basic\code\day05 NineNineTable
java -classpath D:\Java_lession\1_basic\code\day05 PrimeNum
*/

import java.lang.Math;
class NestFor {
    public static void main (String args[]){


        /* 透過NestFor 輸出 : 提示 以"* "為單位輸出 (不要用 "*")
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *   

        */

        //上半部
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 4 - i; j++){
                System.out.print(" ");
            }
            
            for (int k = 0; k < i + 1; k++){
                 System.out.print("* ");
            }
             System.out.println();
               
        }

        // 下半部
        for (int i = 0 ; i < 4 ; i++){
          for (int j = 0 ; j < i + 1; j++){
                System.out.print(" ");
            }
            
            for (int k = 0; k < 4 - i; k++){
                 System.out.print("* ");
            }
             System.out.println();

            
        }
          
        

    }
}

// 九九乘法表
class NineNineTable {
    public static void main (String args[]){
        for (int i = 1 ; i <= 9 ; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(i + " * " + j + " = " + i*j + " ; ");
            }
            System.out.println();

        }
 

  }   
}

// 輸出100以內的質數

class PrimeNum {
    /*
    找出 100以內的質數
    */
    public static void main(String args[]) {
        int num = 100000;
        long start = System.currentTimeMillis();
        for (int i = 2 ; i <= num; ++i) {
            for (int j = 2 ; j <= Math.sqrt(i)  ; ++j){ // 循環條件可以設定從2 ~ i / 2，也就是檢查 a%2, a%3, ... ,a% (i/2) 是否整除，如果都沒有那就是沒有 
                                                        // 或者，又可以更有效率換成 2 ~ (i)^0.5, 例如: j < i^0.5
                if (i % j == 0 && j != Math.sqrt(i)) {
                    break;
                } else if (i % j == 0 && j == Math.sqrt(i)){
                    System.out.println(i);
                }
                
            }
            
            
        }
        long end = System.currentTimeMillis();
        System.out.println("共花費: " + (end - start) + "秒");
    }
    
}


