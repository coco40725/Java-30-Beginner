/*
* 獲取運行時類的 方法
*
* */
package Test3;

import Test2.Person;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 11:31
 */
public class MethodTest {

    @Test
    public void test(){
        Class clazz = Person.class;

        //  獲取多個方法: getMethods() 獲取當前運行時類及其父類的 public 的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("*********************************");
        // 獲取多個方法: getDeclaredMethods() 獲取當前運行時類 所有方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1){
            System.out.println(m);
        }


    }


    // 獲取方法的 權限修飾子、返回值類型、方法名(參數類型1 形參名,....) throws 異常、註解
    @Test
    public void test1(){
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods){
            
            // 獲取方法的註解: 注意如果要在反射時獲取註解，註解週期必須定為RUNTIME
            for (Annotation annotation : m.getAnnotations()) {
                System.out.println(annotation);
            }

            // 獲取權限修飾子
            int i = m.getModifiers();
            System.out.print(Modifier.toString(i) + "\t");

            // 獲取 返回值類型
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName()+ "\t");

            // 獲取方法名
            System.out.print(m.getName());
            System.out.print("(");

            // 獲取形參列表
            Class[] ParameterTypes = m.getParameterTypes();
            if (ParameterTypes.length != 0  && ParameterTypes != null){
                for (int j = 0; j < ParameterTypes.length; j++) {
                    if (j == ParameterTypes.length - 1) {
                        System.out.print(ParameterTypes[j].getName() + " args_" + j );
                    }else{
                        System.out.print(ParameterTypes[j].getName() + " args_" + j + ", ");
                    }

                }
            }


            System.out.print(")");

            // 獲取方法異常
            Class[] exceptionType = m.getExceptionTypes();
            if (exceptionType.length != 0 && exceptionType != null){
                System.out.print(" throws ");
                for (int j = 0; j < exceptionType.length; j++){
                    if (j == exceptionType.length - 1) {
                        System.out.print( exceptionType[j].getName());

                    }else {
                        System.out.print(exceptionType[j].getName() + " , ");

                    }
                }
            }

            System.out.println();


        }


    }
}
