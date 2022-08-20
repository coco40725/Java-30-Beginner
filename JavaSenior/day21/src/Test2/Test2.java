/*
  1. System.currentTimeMillis()
  2. java.util.Date 與其子類: java.sql.Date
  3. java.text.SimpleDateFormat
  4. Calendar
  -----------------------------------------
* SimpleDateFormat: 對日期進行格式化並解析
 1.1 格式化: 日期 (java.util.Date格式) --> 字符串
 1.2 解析: 字符串 (有格式要求) --> 日期 (java.util.Date格式)
     yyyy: 年
     MM: 月
     dd: 日
     hh: 小時
     mm: 分
     ss: 秒
*
*
*
* */
package Test2;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yu-Jing
 * @create 2022-06-30-PM 01:57
 */
public class Test2 {

    @Test
    public void test() throws ParseException {
        // 使用默認的constructor
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String s2 = "6/30/22, 2:08 PM";

        // 格式化日期
        String date_str = sdf.format(date);
        System.out.println(date_str);

        // 解析日期
        Date date2 = sdf.parse(s2);
        System.out.println(date2);


    }

    @Test
    public void test2() throws ParseException {
        // 使用特定格式 (可以自己寫) 的constructor
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println(date);
        String s2 = "2005-03-09 14:20:05";

        // 格式化日期
        String date_str = sdf.format(date);
        System.out.println(date_str);

        // 解析日期，字符串格式要符合你在構造器使用的格式
        Date date2 = sdf.parse(s2);
        System.out.println(date2);

    }

    @Test
    // 練習1
    // 將 字符串"2020-09-08" 轉換 java.sql.Date
    public void test3() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_util = sdf.parse(birth);

        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        System.out.println(date_sql.toString());




    }

    @Test
    // 練習2: 三天打魚 兩天曬網，從 1990-01-01開始，試問: xxxx 年 xx 月 xx 日，魚夫在做甚麼?
    public void test4() throws ParseException {
        String ask_str = "1990-01-06";
        String base_str = "1990-01-01";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        // 概念: 以1990-01-01開始 當 第1天， 則 xxxx 年 xx 月 xx 日 是第幾天?
        // 方法1: 透過兩天差距幾毫秒 來計算該日期是第幾天

        Date date_base = sdf.parse(base_str);
        Date date_now = sdf.parse(ask_str);

        long THE_day = (date_now.getTime() - date_base.getTime()) / (1000 * 86400) + 1; // 差幾天 + 1 = 第幾天
        long doing = THE_day % 5;

        if (doing == 1L || doing == 2L || doing == 3L){
            System.out.println("第" + THE_day + "天，" +"漁夫正在打魚");
        }else {
            System.out.println("第" + THE_day + "天，" +"漁夫正在偷懶");
        }

        // 方法2:


    }

}
