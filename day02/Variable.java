/*
1. Variable包含:
   00.(可選) 存取修飾子 public, private, protucted
   01.(可選) 靜態成員修飾子: static 
   a. Variable 的名稱
   b. Variable 的類型: 
      b1. primitive type
        整數值型: byte (一個數字佔用 8 bit表示 --> 可以表示256個數字，範圍 -128~127), ex. byte Apple = -300 [這個會跑error]
                 short (一個數字佔用 16 bit --> 可以表示2^16個數字，範圍 -2^15 ~ 2^15 -1), 
                 int (一個數字佔用 32 bit --> 可以表示2^32個數字，範圍 -2^31 ~ 2^31 -1), 
                 long (一個數字佔用 64 bit --> 可以表示2^64個數字，範圍 -2^63 ~ 2^63 -1)
        
        浮點數值: float (一個數字占用 32 bit表示，這32個bit一部分的bit表示10的次方數，另一部分bit表示剩餘的數值 --> 可以表示 -3.403e38 ~ 3.403e38，可精確至小數點第7位，範圍比long大), 
                 double (一個數字占用 64 bit表示，這64個bit一部分的bit表示10的次方數，另一部分bit表示剩餘的數值 --> 可以表示 -1.798e308 ~ 1.798e308，可精確至小數點第14位)
        
        字符型: char (只能一個字 ex. A, 中，或者是跳脫字元 (Escape Character)，甚至可用Unicode代碼表示，一個字佔用 16 bit，使用時輸入 ''，而非""!!!)
        
        判斷型 (True/ False): boolean

      b2. reference type
        class: String: 使用時輸入 "" 而非 ''!! 可以不放東西例如: String s1 = ""，但是char裡面一定要有東西，例如 char c1 = '' [error!!]
        interface
        Array [[]]
         
   c. Variable 的值
   ex. int Ap6p = 12 

2. 如何覆寫Variable:
 ex.  int DRG_Rock = 12;
      int DRG_Rock = 11; 這樣會出現error
      short DRG_Rock = 11; 這樣會出現error
      
      DRG_Rock = 11; 通過，DRG_Rock覆寫成 11
      也就是若該變數已經定義過類型了，則不可重複定義!

3. funciton裡面的變數只能在function內使用

4.預設的1,2,3,4,.....這種常數，默認為int ;  23.222, 5566.5562,... 則是默認為double,
  ex. int i2 = 2;
      int i3 = i2 + 3; 這個3是int

 */
// javac -encoding UTF-8 D:\course_and_research\Java_lession\1_basic\code\day02\Variable.java
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 Variable
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 StringTest
 class Variable {
     public static void main(String[] args){

         // define 整數型variable
         byte Num_byte = -122;
         short Num_short = -1220;
         int Num_int = 232222;
         long Num_long = 233332226L; //long一定要在數字後面加上l或L，不加的話，他會預設成int

         // do thing
         System.out.println("整數類型:");
         System.out.println(Num_byte);
         System.out.println(Num_short);
         System.out.println(Num_int);
         System.out.println("");


         // define 浮點數variable
         float Num_float = 3.22F; // float一定要在數字後面加上f或F
         double Num_double = -1.33;

         // do thing
         System.out.println("浮點數類型:");
         System.out.println(Num_float);
         System.out.println(Num_double);
         System.out.println("");


        // define 字符型variable
         char char1 = 'G';
         char char2 = '中';
         char char3 = 'π';
         char char4 = '\n'; //跳脫字元
         char char5 = '\u0043'; //Unicode: C

         // do thing
         System.out.println("字符類型:");
         System.out.println(char1);
         System.out.println(char2);
         System.out.println(char3);
         System.out.println(char4);
         System.out.println(char5);
         System.out.println("");

         // define 邏輯型variable
         boolean bool1 = true;
         boolean bool2 = false;

        //do thing
         System.out.println("邏輯類型:");
         System.out.println(bool1);
         System.out.println(bool2);
         System.out.println("");

         if (bool1){
             System.out.println("Really \"大便很臭\"!");
         }else {
             System.out.println("NotGood!");
         }
         




     }

    

  
 }

 class StringTest{
     public static void main(String[] args){
         String s1 = "Fuck you";
         System.out.println(s1);

     }
 }