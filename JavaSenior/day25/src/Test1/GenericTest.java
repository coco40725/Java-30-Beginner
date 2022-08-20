package Test1;/*
*  1. 泛型 Generic: 用於限制集合裡面的變數類型，但不支援 primitive variable
*  2. 如何自定義 Generic 結構?
*       - 泛型類、泛型interface: 當你不確定某個屬性的類型時，可以使用
*       - 泛型方法 : 在方法中出現了泛型結構，但是 此泛型結構與 類的泛型結構沒有任何關係
*
* */

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-27-PM 03:21
 */

public class GenericTest {

    @Test
    public void test(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(44);
        arrayList.add(62);
        arrayList.add(78);
        arrayList.add(95);

        for (Integer i : arrayList){
            System.out.println(i);
        }

        System.out.println("*******************************");

        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test1(){
        // Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map = new HashMap<>(); // 等價上面的寫法
        map.put("MEATBALL",95);
        map.put("DOG",20);
        map.put("CAT",63);

        // 泛型的嵌套
        // Entry 是 Map的內部interface
       Set<Map.Entry<String, Integer>> entry =  map.entrySet(); // return Set< Map.Entry<String, Integer> >
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry1 = iterator.next();
            System.out.println("key = " + entry1.getKey() + "------> " + "value = " + entry1.getValue());
        }

    }
}


