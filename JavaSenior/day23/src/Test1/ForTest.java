package Test1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Yu-Jing
 * @create 2022-07-13-PM 02:48
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("POE"));
        coll.add("food");
        coll.add(new Person("petter",65));
        coll.add(false);

        // for (集合中的元素 : 集合)
        for (Object obj : coll){
            System.out.println(obj);

        }

        for (int i : new int[]{123,456}){
            System.out.println(i);

        }

    }

    @Test
    public void test2(){
        String[] arr = new String[]{"MM","MM","MM"};

//        for (int i = 0; i < arr.length; i++){
//            arr[i] = "GG";
//        }

        for (String s : arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }
}
