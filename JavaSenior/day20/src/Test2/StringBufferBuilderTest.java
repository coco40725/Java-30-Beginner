/*
* String, StringBuffer, StringBuilder 差異
* 1. String: 不可變字符串 (JDK 1.0 就有)；底層使用 final char[] 存取數據;JDK 9 之後換成用 final byte[]存取以節省空間
* 2. StringBuffer: 可變字符串 (JDK 1.0 就有)，有考慮的線程安全的設計、效率較低；底層使用 char[] 存取數據;JDK 9 之後換成用  byte[]存取以節省空間
* 3. StringBuilder: 可變字符串 (JDK 1.5 新增)，不考慮的線程安全的設計、效率高；底層使用 char[] 存取數據;JDK 9 之後換成用  byte[]存取以節省空間
*
* 三者之間的效率比較:  StringBuilder > StringBuffer > String
* ---------------------------------------------------------------------------------------------
* 源碼分析 (以 JDK 9 之前為例子):
* String s1 = new String();// new char[0];
* String s1 = new String("abc");  //new char[]{'a','b','c'};
*
* StringBuffer s1 = new StringBuffer(); // new char[16]; 由於 public StringBuilder() {super(16); }
* s1.append('a');// s1[0] = 'a'
* s1.append('b');// s1[1] = 'b'
*
*  StringBuffer s1 = new StringBuffer("abc"); // new char[16 + "abc".length()]
*  s1.append('a');// s1[0] = 'a'
*  s1.append('b');// s1[1] = 'b'
*
* -----------------------------------------------------------------------------------------------
* 問題1: 已知 StringBuffer 存取數據是預先用 char[16] 來存取，那麼 使用StringBuffer建立字符串，其length會是多少?
* StringBuffer s1 = new StringBuffer("abc");
* s1.length(); // 答案是: 仍是 3， 不是 3 + 16
*
* 問題2: 擴充問題，若不斷的 用append黏貼字串，黏到超過StringBuffer預先開出來的char Array大小，則需要擴充底層的char[]。
* 底層的做法是 把原來的 char[]數據 進行 copy，使用 Arrays.copyOf(char[] original, int newLength)，而new length通常是設定成 "原來容量的大小" * 2 + 2
*
* 建議: 開發中建議使用 StringBuffer 並且最好預先設定好大小。不建議讓他中途進行擴充大小，太花時間。
*
* ------------------------------------------------------------------------------------------------------------------------------------------------
* 題外話: 左移運算符 << 與 右移運算符 >> ，他們的效率是高於乘法運算 (A good optimizing compiler will replace multiplications with shifts when possible.) https://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work
*(https://docs.oracle.com/javase/specs/jls/se10/html/jls-15.html#jls-15.19 )
1. The value of n << s is n left-shifted s bit positions; this is equivalent (even if overflow occurs) to multiplication by two to the power s.
2. The value of n >> s is n right-shifted s bit positions with sign-extension. The resulting value is floor(n / 2s).
   For non-negative values of n, this is equivalent to truncating integer division, as computed by the integer division operator /, by two to the power s.
* A << 1 等同於 A * 2^1
* A << 2 等同於 A * 2^2
* A << n 等同於 A * 2^n
*
* A >> 1 等同於; if A is positive:  A / 2^1. if A is negative, floor(A / 2^1)
* A >> 2 等同於 if A is positive:  A / 2^2. if A is negative, floor(A / 2^2)
* A >> n 等同於 if A is positive:  A / 2^n. if A is negative, floor(A / 2^n)
*
*  */
package Test2;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-28-PM 03:46
 */
public class StringBufferBuilderTest {
    @Test
    public void test(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.setCharAt(0,'m');
        System.out.println(s1);
        System.out.println(s1.length());


    }
}
