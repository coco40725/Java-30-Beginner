/*
 Variable運算:

 1. 自動轉型 (提升):
    byte、char(與數值型變數運算，可自動轉成對應的數字)、short  --> int  --> long  --> float  --> double
    
    a. 可表示較多範圍的變數類型 %運算% 可表示較少範圍的變數類型 --> 結果會自動提升可表示較多範圍的變數類型 
    ex. byte  b1 = 2;
        int i1 = 3;
        int b2 = b1 + i1; 因為 int 可表示的數字多於 byte
    
    b. 特殊情況: 當byte、char、short互相運算(包含同種運算)後，output會自動轉成int
    c. String + 數值型變數或boolean = String (+相當於paste)
    d. 運算有先後順序，括弧先執行
    

 2. 強制轉型 (例如我想從 int轉成byte 或 int轉成 double):
    ex. int i2 = 2;
        byte i3 = (byte)i2;
        double d2 = (double)i2;
    但是，若是想要從字串轉成整數，則需要使用
    int num = Integer.parseInt(String)

        



 */


// javac -encoding UTF-8 D:\course_and_research\Java_lession\1_basic\code\day02\Variable_Cal.java
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 VariableCal_auto
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day02 VariableCal_trans
class VariableCal_auto{
    public static void main(String[] args){
        byte  b1 = 2;
        int i1 = 3;
        int i11 = b1 + i1;
        System.out.println(i11); //byte --> short  --> int
        System.out.println(b1 + i1);

        char c1 = 'a';
        int i2 = 3;
        int i3 = c1 + i2; //char  --> int
        System.out.println(i3);

        short s1 = 2;
        // short s2 = s1 + c1; error
        // char c2 = s1 + s2; error
        int i4 = s1 + c1; // byte + char(轉成數字) 彼此運算後得到的結果必須用int

        byte b2 = 3;
        // byte b3 = b1 + b2;  error，byte 彼此運算後得到的結果必須用int

        String str1 = "大臭狗: ";
        int i5 = 1000 ;
        String str2 = str1 + i5;
        System.out.println(str2);

        //運算有先後順序，括弧先運行
        char c_1 = 'a'; //97
        int i_1 = 10;
        String s_1 = "Hello";
        System.out.println(c_1 + i_1 + s_1); //得到 107Hello
        System.out.println(c_1 + s_1 + i_1 ); //得到 aHello10
        System.out.println(c_1 + (i_1 + s_1)); //得到 a10Hello
        System.out.println((c_1 + i_1) + s_1); //得到 107Hello
        System.out.println(s_1 + i_1 + c_1); //得到 Hello10a

        // 想要輸出 * \t *
        System.out.println("*\t*");
        System.out.println('*' + '\t' + '*'); // 失敗，主要是因為 '*' + '\t' 會轉成 int
        System.out.println("*" + "\t" + "*");
        System.out.println('*' + "\t" + '*');






    }
}

class VariableCal_trans{
    public static void main(String[] args){
        int i2 = 2;
        byte i3 = (byte)i2;
        double d2 = (double)i2;
        System.out.println(i3);
        System.out.println(d2);

        int ii = 49;
        char ii_c = (char)ii;
        System.out.println(ii_c); // 對應的編譯數字 49 轉回編譯碼 '1'

        char c11 = '1';
        int c11_i = (int)c11;
        System.out.println(c11_i); // c11 = '1' 轉成int後 不是1喔! 而是'1'對應的編譯數字 49!

        String s11 = "123456";
        int int11 = Integer.parseInt(s11);
        System.out.println(int11); // 字串 123456 轉成數字 123456


    }
}