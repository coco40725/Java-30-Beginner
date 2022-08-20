/*
  1. System.currentTimeMillis()
  2. java.util.Date 與其子類: java.sql.Date
  3. java.text.SimpleDateFormat
  4. Calendar
  -----------------------------------------
* Calender 屬於抽象類
 1. 創建其子類對象 GregorianCalendar
 2. 調用其靜態方法得到對象，getInstance()

 3. get(int field): 放入Calendar 的屬性，取得該屬性值

 4. set(int field, int value): 針對特定filed強制改成value

 5. add(int field, int amount): 針對特定filed 更動 amount 天

 6. getTime(): Calendar --> Date ；return  java.util.Date

 7. setTime(): Date --> Calendar； 將 Date的日期套用至Calendar上
 ---------------------------------------------------------------
 注意: Calender獲取 月份時，1月是0; 2月是 1;...; 12月是 11
                  星期時，1 是星期日; 2 是星期一; ....; 7 是星期六
*
*
* */
package Test2;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Yu-Jing
 * @create 2022-06-30-PM 03:28
 */
public class CalenderTest {
    @Test
    public void test(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());

        //get()
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        // set()
        instance.set(Calendar.DAY_OF_MONTH,29);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

        // add()
        instance.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

        instance.add(Calendar.DAY_OF_MONTH, -5);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

        // getTime() return  java.util.Date
        Date date = instance.getTime();
        System.out.println(date.toString());

        //setTime()
        Date date1 = new Date();
        instance.setTime(date1);
    }

    // 三天打魚兩天曬網，以 1990-01-01為第一天，試問: xxxx 年 xx 月 xx 日，魚夫在做甚麼?
    @Test
    public void test5() throws ParseException {
        // 第x天 = 距離1990-01-01幾天 + 1
        String ask_str = "1990-01-06";
        String base_str = "1990-01-01";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_base = sdf.parse(base_str);
        Date date_now = sdf.parse(ask_str);

        Calendar cal_base = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();

        cal_base.setTime(date_base);
        cal_now.setTime(date_now);






    }
}
