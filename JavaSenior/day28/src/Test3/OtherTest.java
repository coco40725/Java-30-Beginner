package Test3;

import Test2.Person;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Yu-Jing
 * @create 2022-08-16-PM 01:21
 */
public class OtherTest {

    // 獲取構造器
    @Test
    public void  test(){
        Class clazz = Person.class;
        // getConstructors() 獲取當前運行時類的 public構造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println("***********************");

        // getConstructors() 獲取當前運行時類的 所有構造器
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor c : constructors1){
            System.out.println(c);
        }


    }


    // getSuperclass() 獲取運行時類的父類
    @Test
    public void test1(){
        Class clazz  = Person.class;
        Class clazz_Par = clazz.getSuperclass();
        System.out.println(clazz_Par);
    }

    // getGenericSuperclass() 獲取運行時類的 帶泛型父類， Type 為interface
    @Test
    public void test2(){
        Class clazz  = Person.class;
        Type clazz_Par = clazz.getGenericSuperclass();
        System.out.println(clazz_Par);
    }

    // getGenericSuperclass()  + ParameterizedType : 獲取運行時類的 帶泛型父類的泛型
    @Test
    public void test3(){
        Class clazz  = Person.class;
        Type clazz_Par = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz_Par;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());

    }

    // 獲取運行時類的 接口
    @Test
    public void test4(){
        Class clazz  = Person.class;
        for (Class anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface.getName());
        }

        System.out.println("*******************************");
        for (Class anInterface : clazz.getSuperclass().getInterfaces()) {
            System.out.println(anInterface.getName());
        }


    }

    // 獲取運行時類的 所在的package
    @Test
    public void test5(){
        Class clazz  = Person.class;
        Package p  = clazz.getPackage();
        System.out.println(p.getName());
    }


    // 獲取運行時類的 申明的註解
    @Test
    public void test6(){
        Class clazz  = Person.class;
        Annotation[] a = clazz.getAnnotations();
        for (Annotation aa : a){
            System.out.println(aa);
        }
    }
}
