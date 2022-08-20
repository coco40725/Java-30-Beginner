// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day04\IfTest.java
// java -classpath D:\Java_lession\1_basic\code\day04 IfTest1
// java -classpath D:\Java_lession\1_basic\code\day04 IfTest2
// java -classpath D:\Java_lession\1_basic\code\day04 IfTest3


import java.util.Scanner;
class IfTest1 {
    /*
        請輸入成績，
        成績 100分得到獎勵: BMW
        成績(80, 99]: iphone
        成績[60, 80]: iPad
        else 無
    */ 

    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("請輸入成績: ");
        int grade = scan.nextInt();


        if (grade == 100){
            System.out.println("BMW");
        } else if (grade > 80 && grade <= 99){
            System.out.println("iphone");
        } else if (grade >= 60 && grade <= 80){
            System.out.println("ipad");
        } else {
            System.out.println("無");
        }
      
       

        
    }
}


class IfTest2 {
    public static void main (String args[]){
    
    /*
    輸入3個整數，並從大排到小輸出
    */
    Scanner scan = new Scanner(System.in);
    
    System.out.println("請輸入數字1: ");
    int num1 = scan.nextInt();

    System.out.println("請輸入數字2: ");
    int num2 = scan.nextInt();

    System.out.println("請輸入數字3: ");
    int num3 = scan.nextInt();

    if (num1 > num2 && num2 > num3){
        System.out.println(num1 + ", " + num2 + ", " + num3);
    } else if (num1 > num3 && num3 > num2){
        System.out.println(num1 + ", " + num3 + ", " + num2);
    } else if (num2 > num1 && num1 > num3){
        System.out.println(num2 + ", " + num1 + ", " + num3);
    } else if (num2 > num3 && num3 > num1){
        System.out.println(num2 + ", " + num1 + ", " + num3);
    } else if (num3 > num1 && num1 > num2){
        System.out.println(num3 + ", " + num1 + ", " + num2);
    } else if (num3 > num2 && num2 > num1){
        System.out.println(num3 + ", " + num2 + ", " + num1);
    } else {
        System.out.println("無從判斷!");
    }


    }
}


class IfTest3 {
    /* 彩票規則
    0. 先隨機生成兩位的彩票碼 10-99
    1. 全對: 10,000 元
    2. 順序相反: 3000元
    3. 僅 個位數對 (十位數) 對: 1000元
    4. 十位數的數字跑到個位數 (或相反): 500元
    
    */
    public static void main (String args[]){
        // Math.random() 本身產生 [0.0, 1.0) 數值
        int ans = (int)(Math.random()*90 + 10); //產生 [10, 100) 的double
        Scanner scan  = new Scanner(System.in);
        System.out.println("標準答案: " + ans);
        System.out.println("請輸入號碼: ");

        int num = scan.nextInt();
        int num_1 = num / 10;
        int num_0 = num - num_1*10;
        int ans_1 = ans / 10;
        int ans_0 = ans - ans_1*10;
        if (num == ans){
            System.out.println("全對: 10,000 元");
        } else if (num_1 == ans_0 && num_0 == ans_1 ){
            System.out.println("順序相反: 3000元");
        } else if (num_1 == ans_1 || num_0 == ans_0){
            System.out.println("僅 個位數對 (十位數) 對: 1000元");
        } else if (num_1 == ans_0 || num_0 == ans_1){
            System.out.println("十位數的數字跑到個位數 (或相反): 500元");
        } else {
            System.out.println("無獎勵");
        }



        



        System.out.println(ans);

    }
}