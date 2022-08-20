/*
* Annocation 註解 介紹
* 1. JDK 5.0後新增
* 2. 可在不改變程式碼的源有邏輯新增一些補充資料
* 3. 框架 = 設計模式 + 註解 + 反射
* -------------------------------------------
* 4.
* 範例1: 生成文件相關的註解:
*  @author Yu-Jing
*  @create 2022-07-05-PM 04:06
*
*
* 範例2: 格式檢查，內建的三個基本註解，@Override, @Deprecated, @SuppressWarning
* @Override : 只能用於override方法。
* @Deprecated: 用於表示此類或方法等 已經過時。
* @SuppressWarning: 抑制編輯器出現Warning，且可以寫多個值
*
* 範例3: 跟蹤程是碼依賴性，代替配置文件
* */
/*
如何自定義 註解? 參照@SuppressWarning
1. 註解聲明為 @interface
2. 內部定義 member variable，以 value() 表示。
3. 可以指定 member variable 的默認值
4. 如果自定義註解沒有member variable，則視為標示用。
5. 如果自定義註解內有member variable，則需要對其member variable賦值。

自定義註解需要搭配訊息處理流程(使用反射)才有意義。

5. 元註解: 用於修飾其他註解的註解，目前jdk提供四種元註解:
   1. @Retention: 指定修飾的 Annotation的 生命週期，共有三種狀態: SOURCE (經過.javac後，此註解會消失),
                                                            CLASS (當通過.java後，不加載此註解，不加載至記憶體中，此為默認行為),
                                                            RUNTIME (可以透過反射進行讀取)
   2. @Target : 用於指定被修飾的 Annotation能用於修飾那些程序元素，包含 TYPE (class, interface, enum), FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
   3. @Documented: 用於指定被修飾的Annotation類將被 javadoc 工具提取成文檔，javadoc默認下是不包含註解的
   4. @Inherited : 被他修飾的Annotation 將具有繼承性，換言之父類若有此種註解，則子類會值皆繼承到此註解


   // @Retention and  @Target較常使用

 6. 通過反射來獲取註解訊息
 7. JDK 8 新特性: 可重複註解 (@Repeatable)、類型註解 (TYPE_PARAMETER 可以修飾泛型; TYPE_USE 只要是類型的地方都能用)

* */
package Test2;

import java.lang.annotation.*;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.*;

/**
 * @author Yu-Jing
 * @create 2022-07-05-PM 04:06
 */


// JDK 8以前的寫法:
//@testAnno2({@testAnno("hi"),@testAnno("okay")})
@testAnno("hi")
@testAnno("okay")
public class AnnomtationTest {
    public static void main(String[] args) {

        @SuppressWarnings({"unused","rawtype"}) //
        int num = 10;
    }
}

class test extends  AnnomtationTest{

}

class GENE<@testAnno T>{
    public void show() throws @testAnno RuntimeException{
        ArrayList<@testAnno String> list = new ArrayList<>();

        int num = (@testAnno int) 10L;

    }

}
@Repeatable(testAnno2.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, TYPE_PARAMETER, TYPE_USE})
@interface  testAnno{
    String value() default "hello"; // String value() 是屬於 field， 我們可以設定是否要default
}


@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, TYPE_PARAMETER, TYPE_USE})
@interface testAnno2{
    testAnno[] value()  ;
}