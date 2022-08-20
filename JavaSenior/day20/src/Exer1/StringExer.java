package Exer1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Vector;

/**
 * @author Yu-Jing
 * @create 2022-06-27-PM 03:47
 */
public class StringExer {
    public static void main(String[] args) {
        StringExer str = new StringExer();

        // 1. 模擬一 個 trim 方法，去除字符串兩端的空格
        String s1 = "  abd 56 8    ";
        System.out.println("原始: " + s1);
        System.out.println("trim: " + "---" + s1.trim() + "---");
        System.out.println("MyTrim: " + "---" + str.mytTrim(s1) + "---");

        // 2. 將一個字符串進行反轉。將字符串中指定部分進行 反轉 。比如 abcdefg 反轉為 abfedcg。
        String s2 = "abcdefg";
        System.out.println("原始為:" + s2 + " 反轉 --> "+ str.reverseString(s2,2,5));
        System.out.println("原始為:" + s2 + " 反轉 (改良版) --> "+ str.reverseString1(s2,2,5));
       //System.out.println("原始為:" + s2 + " --> "+ str.reverseString(s2,6,5));

        // 3 .獲取一個字符串在另一個字符串中出現的次數。比如：獲取 “ ab 在 abkkcadkabkebfkcabkskab ” 中 出現的次數
        String s3 = "abkkcadkabkebfkcabkskabe";
        String s33 = "s5ad5";
        String s34 = "ssabababifjlababki";

        System.out.println("ab數量: " + str.countSpecificString(s3, "ab") );
        System.out.println("kca數量: " + str.countSpecificString(s3, "kca") );
        System.out.println("kass數量: " + str.countSpecificString(s3, "kass") );
        System.out.println("abab數量: " + str.countSpecificString(s34, "abab") );
        System.out.println("s5ad531s數量: " + str.countSpecificString(s33, "s5ad531s數量") );


        // 4.獲取兩個字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef“ ; str2 = "cvhellobnm"
        String s4 = "abcwerthelloyuiookay5defyoui1";
        String s44 = "youi1hellob56fokay5nm";
        System.out.println("比較兩字串並輸出最大相同子串: " + str.getMaxString(s44,s4).toString());

        // 5. 對字符串 中字符 進行自然順序排序
        String s5 = "dd2fadcu";
        System.out.println(s5 + "重新排序: " + str.sortString(s5));

    }



    // 1. 模擬一 個 trim 方法，去除字符串兩端的空格
    public String mytTrim(String str){
        int start = 0;
        int end =  str.length() - 1;

        while(start < end && str.charAt(start) == ' '){
            start ++;
        }

        while(start < end && str.charAt(end) == ' ') {
            end --;
        }
      return str.substring(start, end + 1);
    }

    // 2. 將一個字符串進行反轉。將字符串中指定部分進行 反轉 。比如 abcdefg 反轉為 abfedcg。
    // 針對特定範圍對字串進行反轉
    public String reverseString(String str, int start, int end){
        if (str == null) return null;
        if (str.length() == 0) return "";
        if (start > end) throw new RuntimeException("start value is larger than end value!");
        if (start < 0 || end > str.length()) throw new RuntimeException("the start value or end value is not vaild!");


        char[] c1 = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--){
            char temp = c1[j];
            c1[j] = c1[i];
            c1[i] = temp;
        }
        return new String(c1);
    }

    // 2. 改良版: 使用StringBuffer
    public String reverseString1(String str, int start, int end) {
        if (str == null) return null;
        if (str.length() == 0) return "";
        if (start > end) throw new RuntimeException("start value is larger than end value!");
        if (start < 0 || end > str.length()) throw new RuntimeException("the start value or end value is not vaild!");

        StringBuffer str_buffer = new StringBuffer(str.length());
        str_buffer.append(str.substring(0,start));
        for (int i = end; i > start - 1; i--){
            str_buffer.append(str.charAt(i));
        }
        str_buffer.append(str.substring(end+1));

        return str_buffer.toString();

    }

    // 3. 獲取一個字符串在另一個字符串中出現的次數。比如：獲取 “ ab 在 abkkcadkabkebfkabkskab ” 中 出現的次數
    public int countSpecificString(String str, String specific){
        if (specific.length() > str.length()) return 0;
        if (specific.length() == str.length()){
            if (specific.equals(specific)){
                return 1;
            }else {
                return 0;
            }
        }

        int count = 0;
        int start = 0;
        while(true){
            if (str.indexOf(specific,start) != -1) {
                count++;
                start = str.indexOf(specific,start) + 1;
            } else {
                break;
            }
        }
        return count;
    }

    // 4. 獲取兩個字符串中最大相同子串，可以有複數個。
    public Vector getMaxString(String str1, String str2){
        Vector vector = new Vector();
        String short_str = str1.length() <= str2.length() ? str1 : str2;
        String long_str = str1.length() <= str2.length() ? str2 : str1;

        for (int i = short_str.length(); i > 0; i--){ // 根據最小的字串，以此從最大長度開始找
            for (int j = 0, k = i; k < short_str.length(); j++, k++){ // 最小字串， 長度為 i 有很多種字串， j為起始點,k為終點
                if(long_str.contains(short_str.substring(j, k))) {
                    vector.add(short_str.substring(j, k));
                }
            }
            if (vector.size() != 0) return vector;
        }
        return vector;

    }

    // 5. 對字符串中字符 進行自然順序排序
    public String sortString(String str){
        byte[] byte_str = str.getBytes(StandardCharsets.UTF_8);
        Arrays.sort(byte_str);

        return new String(byte_str);
    }


}



