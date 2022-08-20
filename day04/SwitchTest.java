// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day04\SwitchTest.java
// java -classpath D:\Java_lession\1_basic\code\day04 SwitchTest1
// java -classpath D:\Java_lession\1_basic\code\day04 SwitchTest2

import java.util.Scanner;
class SwitchTest1{
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        char chr = word.charAt(0);

        switch (chr) {
            case 'a':
             System.out.println("A");
             break;
            
            case 'b':
             System.out.println("B");
             break;

            case 'c':
             System.out.println("C");
             break;
            
            default:
             System.out.println("Other");
             break;


        }
    }

}

class SwitchTest2{
    /*
    使用switch case寫法寫出，學生成績>=60 顯示合格; 反之不合格
    可以使用多case合併
    */
     public static void main (String[] args){
         int score = 78;

         switch (score/10){
             case 0:
             case 1:
             case 2:
             case 3:
             case 4:
             case 5:
                System.out.println("不合格");
                break;

             case 6:
             case 7:
             case 8:
             case 9:
                System.out.println("合格");
                break;

         }
         


     }
}

class SwitchTest3{
    public static void main (String[] args){
        
    }
}