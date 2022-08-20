/*
int length() 返回字符串的長度： return value length
char charAt(int index) 返回某索引處的字符 return value[index
boolean isEmpty() 判斷是否是空字符串： return value length 0
String toLowerCase() 使用默認語言環境 將 String 中的所有字符轉換為小寫
String toUpperCase() 使用默認語言環境 將 String 中的所有字符轉換為大寫
String trim() 返回字符串的副本 忽略首尾 空白
boolean equals(Object obj) 比較字符串的 內容 是否相同
boolean equalsIgnoreCase(String anotherString) 與 equals 方法類似 忽略大小寫
String concat(String str) 將指定字符串連接到此字符串的結尾 。 等價於用
int compareTo(String anotherString) 比較兩個字符串的 大小，所謂的大小 指的是ASCII 對應的數字，例如 'a' 對應到 97, 'b' 對應到 97 ， 'b'比'a'大 1；涉及到字符串排序
String substring(int beginIndex) 返回一個新的字符串 它是此字符串的從
beginIndex 開始截取到最後的一個子字符串 。
String substring(int beginIndex, int endIndex) 返回一個新字符串 它是此字符串從 beginIndex 開始截取到 endIndex( 不包含 的一個子字符串 。 [beginIndex, endIndex)
*
* */
package Test1;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-23-PM 03:06
 */
public class StringMethod {

    @Test
    public  void test(){
        String s1 = "helloWorld";
        String s2 = "";
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.isEmpty()); // false
        System.out.println(s2.isEmpty()); // true

        String s3 = s1.toUpperCase();
        System.out.println("s1: " + s1 + "; s3: " + s3);

        String s4 = " He llo Wo rld ";
        System.out.println("---" + s4.trim() + "---");
        System.out.println("---" + s4 + "---");
        System.out.println("HELLOworld".equalsIgnoreCase(s1));
        System.out.println(s3.concat("_ajs"));

        System.out.println("比大小: "+ "abc".compareTo("65d2")); //涉及到字符串排序
        System.out.println( "取一部分: " + "肚子真的好飽，吃不下了喔! YEE".substring(5));
        System.out.println( "取一部分: " + "肚子真的好飽，吃不下了喔! YEE".substring(5,10)); // [beginIndex, endIndex)

    }


}
