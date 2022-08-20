/*
* Wrapper: 8 種 prmitive variable 所對應的 class:
* Byte, Short, Integer, Long, Float, Double, Boolean, Character
* 前6種他們的父為: Number
*  primitive variable, Wrapper, String 互相轉換
* 1. primitive variable --> Wrapper : 調用 Wrapper 內裡的constructor，把primitive variable的值塞到Field
*例如:  Integer in1 = new Integer(num);
* 2. Wrapper --> primitive variable: 調用 class中的　xxvalue Field
* 例如:
        Integer in1 = new Integer(113);
        int num = in1.intValue();
** Note: JDK 5.0 新增了新功能 "自動裝箱" 與 "自動拆箱"，但是，他建立Wrapper的方式不是用new的方法
* 3. primitive variable 與 Wrapper --> String
* 方法1:  String s1 = 123 + "";
* 方法2:  String s2 = String.valueOf(in1);
*
* 4. String --> primitive variable (或Wrapper): Wrapper.parseXX(String s)的方法調用
* 例如:  int in1 = Integer.parseInt(s1);
* */
package Test;

import org.junit.Test;

public class Wrapper_Lession {

    @Test
    // primitive variable --> Wrapper : 調用 Wrapper 內裡的constructor
    public void test1(){
        int num = 10;
        Integer in1 = new Integer(num);
        System.out.println(in1.toString()); //Integer內的 toString() 是override，他會回傳裡面的值

        Integer in2 = new Integer("123");
        System.out.println(in2.toString());

        // Integer in3 = new Integer("123abc"); java.lang.NumberFormatException: For input string: "123abc"

       Float f1 = new Float(12.3f);
       Float f2 = new Float("12.3");
       System.out.println(f1);
       System.out.println(f2);

       Boolean b1 = new Boolean(true);
       Boolean b2 = new Boolean("true");
       Boolean b3 = new Boolean("true123");

       System.out.println(b3); // 為何沒error?
        /*
        public static boolean parseBoolean(String s) {
        return "true".equalsIgnoreCase(s); }
        因為程式碼是定成 s 若是"true"，則回傳true，其餘皆是false
        */

        Order1 ord = new Order1();
        System.out.println(ord.isMale); // false
        System.out.println(ord.isFemale); // null

    }

    @Test
    public void test2(){
        Integer in1 = new Integer(113);
        int num = in1.intValue();
        System.out.println(num);

    }

    @Test
    public void test3(){
        // 自動裝箱
        //原本: Integer in1 = new Integer(123);
        Integer in2 = 123;

        // 自鄧拆箱
        //原本: int num1 = in2.intValue();
        int num2 = in2;

    }

    @Test
    //  primitive variable 與 Wrapper --> String
    public void test4(){
        int in1 = 123;
        Integer int1 = 12312; // 採用自動裝箱
        String s1 = in1 + ""; // 方法1
        String s2 = String.valueOf(in1); // 方法2
        String s3 = String.valueOf(int1); // 方法2
    }

    @Test
    public void test5(){
        String s1 = "123";

        Integer int1 = new Integer(s1);
        int in1 = Integer.parseInt(s1);
    }
}

class Order1{
    boolean isMale;
    Boolean isFemale;
}
