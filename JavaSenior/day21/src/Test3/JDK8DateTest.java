/*
* JDK 8以前的Date、Calender相關的API缺陷很多
* 1. 可變性: 日期時間等class理應不可變
* 2. 偏移性: Date的年份是從1990年開始算起，而月份是從0開始算，導致使用 Date(2020, 9 , 8)其實不是得到 2020/09/08，而是得到 3920/10/08 。
*           原因是Date(2020, 9, 8 )其實是使用 Calender.set(2020 + 1900, 9 , 8)，因此才會出現偏移
* 3. 格式化: 格式化僅對Date有用，對Calender不行
* 4. 無法處理線程安全
* -----------------------------------------------------------------------
* JDK 8 之後引入了 java.time API 解決了上述所提的問題。
* java.time 建立了3個class: LocalDate, LocalTime, LocalDateTime(較常用)
* 其中方法包含:
* 1. .now(): 靜態方法，獲取當前日期時間
* 2. .of(): 靜態方法，獲取指定的日期時間,沒有偏移量
* 3. .getXXxx(): 非靜態方法，獲取相關日期時間等訊息
* 4. .withXXxx(): 非靜態方法，設定相關日期時間
* 5. .plusXXxx(): 非靜態方法，加減特定日期與時間 (寫負數就是減了)
* 6. .minusXXxx(): 非靜態方法，減特定日期與時間
* ---------------------------------------------------------------------------
* Instant class使用
* 包含方法:
* 1. .now(): 獲取當前日期與時間 + 毫秒數 (本初子午線)
* 2. OffsetDateTime: 根據時區調整時間
* 3. .toEpochMilli(): 獲取自 1970年1月1日至現在共經過多少毫秒。
* 4. .ofEpochMilli(毫秒): 通過給定的豪秒數找出對應的瞬時點，還是根據本初子午線給時間，因此仍要調整時區
*
* ------------------------------------------------------------------------------
* DateTimeFormatter class : 用於格式化日期與時間
* 1. 預設格式: 靜態final方法，ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
* 2. 本地化相關格式: 靜態方法，ofLocalizedDateTime(FormatStyle.LONG)，注意有對應的用法 https://stackoverflow.com/questions/59531046/java-time-datetimeexception-unable-to-extract-zoneid-from-temporal
* 3. 自定義相關格式 (較常用): 靜態方法，ofPattern(“yyyy MM dd hh:mm:ss”)
* */
package Test3;

import org.testng.annotations.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author Yu-Jing
 * @create 2022-07-04-PM 01:33
 */
public class JDK8DateTest {

    /*
    * LocalDate, LocalTime, LocalDateTime(較常用) 三個class的使用
    * 三個class皆為靜態方法
    * */
    @Test
    public void test(){
        // .now(): 靜態方法，獲取當前日期時間
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // .of(): 靜態方法，獲取指定的日期時間,沒有偏移量
        LocalDateTime localDateTime1 =  LocalDateTime.of(1995,12,25,12,25,41);
        System.out.println(localDateTime1);

        // .getXXxx(): 非靜態方法，獲取相關日期時間等訊息
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getHour());

        // .withXXxx(): 非靜態方法，設定相關日期時間
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(17);
        System.out.println(localDateTime1); // 不會更動到原始的!
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime1.withHour(4);
        System.out.println(localDateTime3);

        // .plusXXxx(): 非靜態方法，加減特定日期與時間 (寫負數就是減了)
        // .minusXXxx(): 非靜態方法，減特定日期與時間
        LocalDateTime localDateTime4 = localDateTime1.plusMonths(-3);
        LocalDateTime localDateTime5 = localDateTime1.plusMonths(4);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);

    }

    @Test
    public void test1(){
        // 1. .now(): 獲取當前日期與時間 + 毫秒數
        Instant instant = Instant.now(); // 回報的是 本初子午線，因此需要考慮時區問題調整時間
        System.out.println(instant);

        // 2. OffsetDateTime: 根據時區調整時間
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 將時區補上

        // 3. .toEpochMilli(): 獲取自 1970年1月1日至現在共經過多少毫秒。
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //4. .ofEpochMilli(毫秒): 通過給定的豪秒數找出對應的瞬時點，還是根據本初子午線給時間，因此仍要調整時區
        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);
    }

    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        //1. 預設格式: ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(localDateTime);
        // DateTimeFormatter 格式化: 日期 --> 字符串
        String str = dateTimeFormatter.format(localDateTime);
        System.out.println(str);
        // DateTimeFormatter 解析: 字符串 --> 日期
        TemporalAccessor parse = dateTimeFormatter.parse(str); //  TemporalAccessor 是interface
        System.out.println(parse);

        // 2. 本地化相關格式: ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // DateTimeFormatter 格式化: 日期 --> 字符串
        String format = dateTimeFormatter1.format(localDateTime);
        System.out.println(format);

        // DateTimeFormatter 解析: 字符串 --> 日期
        TemporalAccessor parse1 = dateTimeFormatter1.parse(format);
        System.out.println(parse1);


        // 3. 自定義相關格式 (較常用): ofPattern(“yyyy MM dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss");
        // 格式化
        String format1 = dateTimeFormatter2.format(localDateTime);
        System.out.println(format1);

        // 解析
        TemporalAccessor parse2 = dateTimeFormatter2.parse(format1);
        System.out.println(parse2);



    }
}
