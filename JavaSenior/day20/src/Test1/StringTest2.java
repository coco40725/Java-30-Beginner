/*
* String 與其他類型之間的轉換
* (1) string --> 數值 : Integer.parseInt, Double.parseDouble, Float.parseFloat
* (2) 數值 --> string : String.valueOf(int; double; float)
* ---------------------------------------------------------------------------------
* (3) string --> char[] : String.toCharArray()
* (4) char[] --> string : String.valueOf(char[]) 或 new String(char[])
* ---------------------------------------------------------------------------------
* (5) string --> byte[] : String.getBytes() // 從一般看得懂的 轉換成 電腦存取的格式 (底層)，類似編碼的行為
* (6) byte[] --> string :  new String(byte[]) // 從電腦存取的格式 (底層) 轉換成 一般看得懂的，類似解碼的行為
* 若編碼使用的系統 與 解碼所使用的系統 不同，則會出現亂碼
*
* */
package Test1;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Yu-Jing
 * @create 2022-06-27-PM 02:32
 */
public class StringTest2 {

    @Test
    public void test1(){

        String s1 = "123";
        // (1) string --> 數值
        int num = Integer.parseInt(s1);
        System.out.println(num);
        System.out.println(Double.parseDouble(s1));
        System.out.println(Float.parseFloat(s1));

        // (2) 數值 --> string
        String s2 = String.valueOf(num); // 方法 1
        String s3 = num + ""; // 方法 2
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // false，s3是透過new產生的
    }


    @Test
    public void test2(){

        // (3) string --> char[]
        String s1 = "abc123";
        char[] c1 = s1.toCharArray();
        System.out.println(Arrays.toString(c1));

        // (4) char[] --> string
        char[] c2 = new char[]{'a','b','1','2','3'};
        String s2 = String.valueOf(c2);
        String s3 = new String(c2);
        System.out.println(s2);
        System.out.println(s3);

        // 小題目: 請將s1變成 "a21cb3"
        char[] c3 = s1.toCharArray();
        char[] c4 = s1.toCharArray();
        for (int i = 1; i < c3.length - 1; i++){
            c4[i] = c3[c3.length - (i+1)];
        }
        System.out.println(new String(c4));
    }

    @Test
    public void test3() throws UnsupportedEncodingException {

        // (5) string --> byte[]
        String s1 = "abc123台灣"; // 使用預設編碼系統:UTF-8， UTF-8: 一個中文字 用三個字節存取
        byte[] b1 = s1.getBytes();
        System.out.println(Arrays.toString(b1));

        byte[] b2 = s1.getBytes("gbk");
        System.out.println(Arrays.toString(b2)); // 使用編碼系統 gbk: 一個中文字用2個字節存取

        // (6) byte[] --> string
        String s2 = new String(b1);
        System.out.println(s2);
        String s3 = new String(b2,"gbk");
        System.out.println(s3);

    }
}
