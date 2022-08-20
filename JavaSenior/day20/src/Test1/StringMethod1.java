/*
boolean endsWith(String suffix) 測試此字符串是否以指定的後綴結束
boolean startsWith(String prefix) 測試此字符串是否以指定的前綴開始
boolean startsWith(String prefix, int toffset) 測試此字符串從指定索引 (toffset)開始的子字符串是否以指定前綴開始
*
boolean contains(CharSequence s) 當且僅當此字符串包含指定的 char 值序列時，返回 true
int indexOf(String str) 返回指定子字符串在此字符串中 "第一次" 出現處的 索引，找不到的話會返回 -1
int indexOf(String str, int fromIndex) 返回指定子字符串在此字符串中第一次出現處的索引，從 "指定的索引" 開始
int lastIndexOf(String str) 返回指定子字符串在此字符串中最右邊出現處的 索引
int lastIndexOf(String str, int fromIndex) 返回指定子字符串在此字符串中最後一次出現處的索引，從"指定的索引"開始反向 搜索
注：
indexOf 和 lastIndexOf 方法如果未找到都是返回 1
若 indexOf 與 lastIndexOf return的結果都一樣，代表這個字符串出現目標string的次數只有一次 (或是根本沒有此string)

* */
package Test1;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-23-PM 03:42
 */

public class StringMethod1 {

    @Test
    public void test1(){
        String s1 = "helloWorld! hello ok?~~";
        System.out.println(s1.endsWith("~~"));
        System.out.println(s1.startsWith("h"));
        System.out.println(s1.startsWith("oW", 4));

        System.out.println("是否包含 oRl? :" + s1.contains("oRl"));
        System.out.println("llo 出現位置: " + s1.indexOf("llo"));
        System.out.println("llo 出現位置: " + s1.indexOf("llo",8));

        System.out.println("llo 出現位置 (從後開始找): " + s1.lastIndexOf("llo"));
        System.out.println("llo 出現位置 (從後開始找): " + s1.lastIndexOf("llo",7));

    }
}
