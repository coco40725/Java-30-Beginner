/*
* 疑問1: 對象的創造應該使用 先前的方法 還是 反射的方法?
*  大多數情況還是用先前的方法，當你無法確定要new 甚麼class的時候，再考慮用反射的方法。
* 例如: 伺服器運行中，伺服器會需要接收使用者的操作，但每一種操作都是一種class，然而伺服器並不知道使用者會調用哪種class，
* 此時可使用反射。(動態性)
*
*  疑問2: 反射的存在是否會與 封裝性產生衝突?
*  其實沒有，封裝性的private比較偏向是"建議不要在class外使用"，你硬要用反射調，也不是不行。
*
* 重點1: 類的加載過程說明
*  1. 撰寫文件檔，並使用 javac.exe 將文字檔轉成 .class 檔案
*  2. 接著使用 java.exe 執行 .class檔案，將文字檔載入 記憶體中 ，此過程稱為 類的加載
*  3. 加載到記憶體內的類，稱為 "執行時類"，此class可視為 "Class" 的一個對象。
*     Class p = Person.class
*  4. 體現了 "萬事萬物皆對象"
*  5. 另外，只要是加載到記憶體內的結構，皆可以視為 Class的對象。例如: interface, primitive variable , array, enum, 內部類, void, annotation，甚至Class也是
*     Comparable.class;
*     int[10].class;
*     int.class;
*     ElementType.class;
*     Override.class;
*     void.class;
*     Class.class;
*     另外，只要數組的類型 與 維度相同，則視為同一個對象
*
*  重點2: "得到" (不是創建!!) Class 其對象，共有4種方式: 調用屬性.class、 getClass()、Class 的靜態方法(較常使用) 、 ClassLoader
*  重點3: 加載到記憶體的運行時類，會緩存一段時間，此期間我們可以透過 4 種方式 (重點2，前三種須掌握) 才獲得此 對象 (唯一)
*
* */

package Test1;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 11:49
 */
public class ReflectionTest {

    // 反射之前，對於Person的操作
    @Test
    public void test(){
        // 1. 創建Person 對象
        Person p = new Person("Tom",12);

        // 2. 調用其內部的屬性與方法
        p.age = 20;
        System.out.println(p.toString());
        p.show();

        // 在 Person類 外部，不可以調用 Person類內部的私有結構
    }

    // 反射之後，對於Person的操作
    @Test
    public void test1() throws Exception {

        // 1.通過反射，創造 Person 類的對象
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom",12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        // 2.通過反射，調用對象的屬性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        // 3.通過反射，調用對象的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        // 4. 通過反射，調用私有的結構
        // 調用私有結構
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object gary = cons1.newInstance("Gary");
        Person p2 = (Person) gary;
        System.out.println(p2);

        // 調用私有屬性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"DEEPROCK");
        System.out.println(p2);

        // 調用私有方法
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        Object obj2 = method.invoke(p2, "台灣");
        String str = (String) obj2;
        System.out.println(str);

    }

    @Test
    public void test3() throws ClassNotFoundException {
        // 方式1: 調用運行時類的屬性 class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式2: 通過運行時類的對象， getClass() return .class
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式3: 調用 Class 的靜態方法: forName(String classPath)，路徑要寫完整一點
        Class clazz3 = Class.forName("Test1.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 ==  clazz2); // true
        System.out.println(clazz1 == clazz3); // true

        // 方式4: 使用 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("Test1.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4); // true



    }
}

