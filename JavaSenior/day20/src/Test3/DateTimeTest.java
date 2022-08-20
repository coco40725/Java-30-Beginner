/*
* JDK 8.0之前的時間設定
* 1. System.currentTimeMillis(): 回報 從1970/01/01 至 現在 共經過多少毫秒。
* 2. java.util.Date
*    2.1 constructors
*        2.1.1 Date():創建當前時間的對象
*        2.1.2 Date(long ): 根據指定毫秒數 (距離 1970/01/01)見出對應日期的對象。
*    2.2 method
*        2.2.1 toString(): 顯示當前年月日時間(時分秒) 與時區
*        2.2.2 getTime(): 回報 從1970/01/01 至 現在 共經過多少毫秒。
*
* 3. java.sql.Date (java.util.Date 的子類): 對應數據庫中的日期變數類型
*           java.util.Date
*               |------java.sql.Date
*        3.1 method
*           3.1.1 toString(): 僅回報 西元年-月-日
*
* java.util.Date 如何轉換成 java.sql.Date ?
* java.sql.Date date2 = new java.sql.Date(date1.getTime());
*
* */
package Test3;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author Yu-Jing
 * @create 2022-06-29-PM 02:41
 */
public class DateTimeTest {

    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis()); // 時常用於當 時間戳
    }

    @Test
    public void test2(){
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        Date date1 = new Date(123554478453L);
        System.out.println(date1.toString());

        java.sql.Date date2 = new java.sql.Date(123554478453L);
        System.out.println(date2.toString());
    }

    @Test
    public void test3(){
        // 情況1: 可以直接轉
//       Date date1 = new java.sql.Date(123554478453L);
//       java.sql.Date date2 = (java.sql.Date) date1;

        // 情況2: 用毫秒來轉
        Date date1 = new Date();
        java.sql.Date date2 = new java.sql.Date(date1.getTime());


    }
}
