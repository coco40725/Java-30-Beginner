/*
 添加 、 刪除、修改操作
 Object put(Object key,Object value) value)：將 指定 key value 添加到 或修改 當前 map 對象中
 void putAll(Map m): 將 m 中的所有 key value 對存放到當前 map 中
 Object remove(Object key) key)：移除指定 key 的 key value 對，並返回 value
 void clear()clear()：清空當前 map 中的所有數據

  元素 查詢的操作：
 Object get(Object key) key)：獲取指定 key 對應的 value
 boolean containsKey(Object key) key)：是否包含指定的 key
 boolean containsValue(Object value) value)：是否包含指定的 value
 int size()size()：返回 map 中 key value 對的個數
 boolean isEmpty()isEmpty()：判斷當前 map 是否為空
 boolean equals(Object obj) obj)：判斷當前 map 和參數對象 obj 是否相等

 元視圖操作的方法： (用於遍歷)
 Set keySet()：返回所有 key 構成的 Set 集合
 Collection values()：返回所有 value 構成的 Collection 集合
 Set entrySet()：返回所有 key value 對構成的 Set 集合，此集合中的元素都是 Entry；
                  而 Entry.getKey() ; Entry.getValue() 可以分別得到 key 與 value

* */


package Test1;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-22-PM 04:13
 */
public class MapMethod {
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",12);
        map.put(45,123);
        map.put("BB",56);

        // 想遍歷所有的 key : key 是存在Set中
        Set set  = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************************************");

        // 想遍歷所有的value : value 是存在 Collection中
        Collection collection = map.values();
        for (Object obj : collection){
            System.out.println(obj);
        }
        System.out.println("*****************************************");

        // 想遍歷所有的 key-value : key-value 是存在 Set中
        // 方式1: 使用 entrySet() 並轉成 entry 的類型
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("key: " + entry.getKey() + " ---> value: " + entry.getValue());
        }
        System.out.println("*****************************************");


        // 方式2: 使用 keySet 搭配 get(key)
        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()){
            Object obj = iterator2.next();
            System.out.println("key: " + obj + " ---> " + "value: " +  map.get(obj));
        }


    }

    @Test
    public void test1(){

        // put (key, value)
        Map map = new HashMap();
        Map map1 = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",45); // 覆蓋掉"AA",123
        System.out.println(map);

        map1.put("CC",11);
        map1.put("GG",55);
        map.putAll(map1);
        System.out.println(map);

        // remove (key) return removed value
        Object obj = map.remove("AA");
        System.out.println(obj);
        System.out.println(map);

        // clear()
        map1.clear(); // 相當於 把 tab[i] = null，
        System.out.println(map1);
        System.out.println(map1.size());

        //  get(key) return value
        Object obj1 = map.get("BB");
        System.out.println(obj1);

        // containsKey return boolean
       boolean isExist = map.containsKey("eds");
       System.out.println(isExist);

       //


    }
}
