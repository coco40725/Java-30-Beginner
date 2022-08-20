/*
對於整數有不同進位制:
1. 10進位制: 0-9，滿10進位
2. 2進位制: 0-1，滿2進位，以0B 或 0b為開頭
3. 8進位制: 0-7，滿8進位，數字以0開頭
4. 16進位制: 0-9 + A-F (大小寫沒差)，0x或0X開頭，滿G進位: 0x21AF +1 = 0x21B0

原碼(Sign-and-Magnitude Code)<值得正負(正0負1)及大小>
(原碼的)一補數(Ones' Complement)
(原碼的)二補數(Two's complement)<JAVA使用方法，口訣: 01互換再加一。> 電腦底層是以原碼的二補數儲存
10001110  -14 原碼 (2進位制轉10進位制: 2^3 + 2^2 + 2^1 = 14)
11110001 -14一補數 (除了正負號，其餘01互換)
11110010 -14二補數 (一補數 + 1)

2進制轉8進制 (3個看成一組):
00000 011 101 001 --> 0 3 5 1

2進位制轉16進位制 (4個看成一組):
000000 1110 1001 --> 0X E 9
 */

// javac -encoding UTF-8 D:\course_and_research\Java_lession\1_basic\code\day02\BinaryTest.java
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 BinaryTest2
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 integerTrans

class binaryTest{
     public static void main(String args[]){
         int num1 = 0b110; //2進位制
         int num2 = 01237; //8進位
         int num3 = 0x110A; //16進位制
         int num4 = 110;
         System.out.println(num1);
         System.out.println(num2);
         System.out.println(num3);
         System.out.println(num4);
     }
 }

 class BinaryTest2{
     public static void main(String args[]){
         int num1 = 128; // 0000 0000 0000 0000 0000 0000 1000 0000 此為32 bit 128的二補數
         byte b1 = (byte)num1; // byte只有 8bits 故只擷取 1000 0000，然而，1000 0000 為 -128 的二補數，因此轉換才會出現奇怪的現象
         System.out.println(num1);
         System.out.println(b1);
     }
 }

 class integerTrans{
      public static void main(String args[]){
         int num1 = 12;
         String num_Binay = Integer.toBinaryString(num1);
         String num_Hex = Integer.toHexString(num1);
         String num_Oct = Integer.toOctalString(num1);
         System.out.println(num1);
         System.out.println(num_Binay);
         System.out.println(num_Hex);
         System.out.println(num_Oct);



      }
 }