/*
StringBuffer 與 StringBuilder 方法相同，以下方法為 "直接對字符串本身更動!"
StringBuffer append ( xxx)：提供了很多的 append() 方法 用於進行字符串拼接
StringBuffer delete (int start,int end)：刪除指定位置的內容, [start, end)
StringBuffer replace (int start, int end, String str)：把  [start, end) 位置替換為 str，str的大小不限制
StringBuffer insert (int offset, xxx)：在指定位置offset之"左邊" 插入 xxx
StringBuffer reverse ()：把當前字符序列逆轉
----------------------------------------------------------------------------
以下方法為 "不會直接對字符串本身更動!"
public int indexOf (String)
public String substring (int start,int): 注意他有返回值，所以是不會對字符串本身更動。
public int length
public char charAt (int n)
public void setCharAt (int n ,char)
*
*
*
*
* */
package Test2;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-29-PM 02:15
 */
public class StringBufferMethod {

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer(64);
        s1.append("林口房價");
        System.out.println(s1);
        s1.append(40000);
        System.out.println(s1);
        s1.append("，aabb，好貴");

//        s1.delete(10,14);
//        System.out.println(s1);

//        s1.replace(10,14,"are you fucking kinding me!");
//        System.out.println(s1);

        s1.insert(10,"AABB");
        System.out.println(s1);

//        System.out.println(s1.reverse());
//        System.out.println(s1);
        s1.substring(1,3);
        System.out.println(s1);

    }
}
