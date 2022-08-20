package Test1;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-22-PM 02:59
 */
public class StringTest {
    /*
    * String:
    * 1. 此為final class，不可以被繼承
    * 2. 實現了 java.io.Serializable, Comparable<String>, CharSequence,
               Constable, ConstantDesc

          2.1 Serializable: 表示string支持序列化
          2.2 Comparable: 可以比較大小
       3. String 內部定義了屬性 final char[] value ，用於儲存string 數據
       4. String代表不可變的字符序列。 考慮string pool，當一個字符內容被創造且附上位址後，便不可以再更改此內容物!
    *  5. 定義方式有兩種: (https://www.youtube.com/watch?v=aAKyixOtfYc )
    *       5.1 new String: 數據建立在 Heap
    *       5.2 string literal: 數據建立在 method中的 string pool，這種定義方式會優先在string pool尋找是否有相同的內容，
    *                           若有，則直接copy該內容的記憶體位址；若無，則重新建一個。 因此 string pool 不會存相同的內容物
    *
    *  6. 屬性為String時，記憶體的分布: 屬性為string時，存的是記憶體位址，且是string pool的記憶體位址
    *  7. String 與 String的拼接: 1) "a" + "b" : 這種的結果會在string pool 進行並存取
    *                           2) "a" + 變數: 只要拼接的對象出現變數，則會在Heap new一個新空間存取資料。
    *  8.String.intern(): 強制去string pool尋找字符串，若有找到，則回傳此字符串在string pool的記憶體位址
     *
    * */
    @Test
    public void test1(){
        String s1 = "abc"; // 此為 string literal (字面量) 定義方式，也是把"abc" 建在 method(方法區)中的 string pool
        String s2 = "abc";

        System.out.println(s1 == s2);
        s1 = "hello";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println("***********************************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); //abcdef
        System.out.println(s2); // abc
        System.out.println("***********************************");

        String s4 = "abc";
        String s5 = s4.replace("a","m");
        System.out.println(s4); // abc
        System.out.println(s5); // mbc
    }


    @Test
    public void test2(){
        String s1 = "javaEE";
        String s2 = "javaEE";

        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4); // false
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false

        System.out.println("***********************************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name.equals(p2.name)); // true，比較的是字符內容 Tom，兩者內容都是Tom，故相同
        System.out.println(p1.name == p2.name); // true，比較的是字符地址，兩個都是對應至string pool的Tom，而 Tom的地址唯一，故相同。

        p1.name = "Jary";
        System.out.println(p2.name);

    }

    @Test
    public void test3(){
        String s1 = "JavaEE";
        String s2 = "cool";
        String s3 = "JavaEEcool";

        String s4 = "JavaEE" + "cool";
        String s5 = s1 + "cool";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false

        String s8 = s5.intern();
        System.out.println(s3 == s8); // true

    }



}


