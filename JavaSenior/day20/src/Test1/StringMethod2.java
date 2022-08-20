package Test1;

/*
替換
String replace(char oldChar, char newChar) 返回 一個新的字符串 它是通過用 newChar 替換此字符串中出現的 "所有" oldChar 得到的 。
String replace(CharSequence target, CharSequence replacement) 使用指定的字面值替換序列替換此字符串所有匹配字面值目標序列的子字符串 。
String replaceAll(String regex, String replacement) 使用 給定的replacement 替換此字符串所有匹配給定的正則表達式的子字符串 。
String replaceFirst(String regex, String replacement) 使用 給定的replacement 替換此字符串匹配給定的正則表達式的第一個子字符串 。

匹配
boolean matches(String regex) 告知此字符串是否匹配給定的正則表達式

切割
String[] split(String regex) 根據給定正則表達式的匹配拆分此字符串 。
String[] split(String regex, int limit) 根據匹配給定的正則表達式來拆分此字符串 最多不超過 limit 個 ，如果超過了， 剩下的全部都放到最後一個元素中
* */

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Yu-Jing
 * @create 2022-06-23-PM 04:20
 */
public class StringMethod2 {
    @Test
    public void test2(){
        String s1 = "林口長庚醫院4545AI核心實驗室4455林口霧很大";
        String s2 = s1.replace("林口","桃園");
        System.out.println(s2);

        String s3 = s1.replaceAll("\\d+", ",");
        System.out.println(s3);

        // 判斷是否為新北市或台北市的電話
        String s4 = "02-29956874";
        String s5 = "03-3256552";
        System.out.println("是不是台北的電話? : "  + s4.matches("02-\\d{8}"));
        System.out.println("是不是台北的電話? : "  + s5.matches("02-\\d{8}"));

        // 分割
        String s6 = "hello|world|fuck|you|";
        String[] s7 = s6.split("\\|");
        String[] s8 = s6.split("\\|",2);
        System.out.println(Arrays.toString(s7));
        System.out.println(Arrays.toString(s8));


    }
}
