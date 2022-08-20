/*
* 獲取當前運行類的屬性
* */
package Test3;

import Test2.Person;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 11:08
 */
public class FieldTest {
    @Test
    public void test(){
        Class clazz = Person.class;

        // 獲取多個屬性: getFields() 獲取當前運行時類及其父類的 public 的屬性
        Field[] fields =  clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        // 獲取多個屬性: getDeclaredFields() 獲取當前運行時類 所有屬性
        System.out.println("*********************");
        Field[] fields1 =  clazz.getDeclaredFields();
        for(Field f : fields1){
            System.out.println(f);
        }
    }

    // 獲取屬性的 權限修飾子、數據類型、變數名
    @Test
    public void test1(){
        Class clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields){
            // 獲取權限修飾子: Public = 1; PRIVATE = 2; PROTECTED = 4; Default = 0;
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t") ; // 將數字轉回對應的型態

            // 獲取數據類型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");


            // 獲取變數名
            System.out.print(f.getName() + "\t");
            System.out.println();

        }

    }
}
