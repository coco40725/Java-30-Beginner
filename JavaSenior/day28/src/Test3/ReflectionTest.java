/*
* 調用 運行時類中的指定結構，包含field, method, constructor
*
* */
package Test3;

import Test2.Person;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yu-Jing
 * @create 2022-08-16-PM 01:47
 */
public class ReflectionTest {
    @Test
    public void test() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        // 創建運行時類的對象
        Person p = clazz.newInstance();

        // getField(String) 獲取指定的 public 屬性
        Field id = clazz.getField("id"); // 這個屬性是非靜態屬性，因此依賴於Person 對象

        // 設定當前屬性的值
        id.set(p, 20);

        // 取得當前屬性的值
        System.out.println((int) id.get(p));

    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class;

        // 創建運行時類的對象
        Person p = clazz.newInstance();

        // getDeclaredField(String) 獲取指定的 屬性
        Field name = clazz.getDeclaredField("name");

        // 開啟權限
        name.setAccessible(true);

        // 設定當前屬性的值
        name.set(p, "poo");

        // 取得當前屬性的值
        System.out.println((String) name.get(p));
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        // 創建運行時類的對象
        Person p = clazz.newInstance();

        // 獲取指定的 非靜態方法，需要 Person的 對象
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(p,"雞雞");
        Object ss = show.invoke(p,"雞雞");
        System.out.println((String) ss);

        // 獲取指定的 靜態方法，不需要 Person的 對象，僅調用 Person類本身
        Method display = clazz.getDeclaredMethod("display", String.class);
        display.setAccessible(true);
        display.invoke(Person.class,"睡覺");


    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        // 獲取指定的構造器: 直接放形參
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);

        constructor.setAccessible(true);

        // 創建運行時類 的對象
        Person p = (Person) constructor.newInstance("TOM",12);
        System.out.println(p);


    }

}
