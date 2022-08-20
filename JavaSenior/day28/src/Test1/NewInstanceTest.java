/*
* 創建運行時類的對象?
* 例如:
* Class clazz = Person.class
* 如何使用 clazz 來創建 Person的對象? (除了用 new Person())
*
* 1. newInstance(): 創建對應的 運行時類 的對象，但是他內部其實是會調用 "空參構造器 Person()" 或 "super()"，
*                   因此構造器必須要 "有空參的" 且 "權限不能太小，例如設為 public"。
*                   在javabean 中必須提供 空參的構造器且 權限為public，為了方便 "通過反射調對象" 與 "保證父類有構造器"
*
* */
package Test1;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 09:57
 */
public class NewInstanceTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz =  Person.class;
        Person obj = clazz.newInstance();
        System.out.println(obj);

    }

    // 體現反射的動態性
    @Test
    public void test1() throws Exception {
        int i = new Random().nextInt(3);
        String classPath = "";
        switch (i){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Test1.Person";
                break;

        }

        Object obj = getInstance(classPath);
        System.out.println(obj);

    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();

    }
}

