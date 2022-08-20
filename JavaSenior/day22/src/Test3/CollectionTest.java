/*
* A.Collection 概述
* 1. 對多個object 進行儲存並操作，可以視為Java容器
* 2. 目前指"儲存" 指的是 記憶體上的存取，而不是存在硬碟
* 3. Collection的程式碼也有用Array的code
*
*  Array 也是 java的容器，
* 特性:
*   1. 一但初始化，長度便確定了，後續不可修改。
*   2. 一但定義好指定元素的類型，後續不可修改。
*   3. 提供的function偏少，對於新增、刪除、插入等操作非常不方便，必須自己寫code。
*   4. 儲存特點: 有序、可重複，但對於 無序且不重複數據，Array無法實現。
*
* B. 集合框架
*   | ----- Collection interface : 單列接口，用來存一個一個的object
*       |----- List interface : 存有序可重複的數據，又可稱為 動態Array (因為可以修改)
*           |----- ArrayList, LinkedList, Vector 實現類
*
*       |----- Set interface : 存無序不可重複的數據，也就是 "set"
*           |----- HashSet, LinkedHashSet, TreeSet 實現類
*
*   | ----- Map interface: 雙列接口，用來存一對一對的數據 (一對: key + value)，類似函數關係 y = f(x)
*       |----- HashMap, LinkedHashMap,TreeMap, HashTable, Properties 實現類
*
*
* C. Collection interface method
*   1. 當你添加至Collection的object，必須override equals，反則會是比較地址值 !!!!!!!!
*
* */


package Test3;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-13-AM 10:06
 */
public class CollectionTest {
    @Test
    public void test1(){
        // Collection method介紹
        Collection coll = new ArrayList();

        // 1. add(Object e): 將元素e添加到collection中
        coll.add(123);
        coll.add("dog");
        coll.add(new String("AA"));
        coll.add(555);
        Person p = new Person("Tim",16);
        coll.add(p);

        // 2. size() return int: 回傳collection的元素個數
        System.out.println(coll.size());

        // 3. addAll(Collection e): 將這個collection中的所有元素添加過來
        Collection coll1 = new ArrayList();
        coll1.add("POE");
        coll1.add("55d");
        coll.addAll(coll1);
        System.out.println(coll);

        // 4. clear(): 清空集合內的元素
        coll1.clear();

        // 5. isEmpty() return boolean: 判斷此集合是否為空集合，不是用來判斷是否為null
        System.out.println(coll.isEmpty());
        System.out.println(coll1.isEmpty());

        // 6. contains(Object o) return boolean: 判斷此集合是否包含 o，他是調用Object.equals來判斷
        System.out.println(coll.contains(123)); // true
        System.out.println(coll.contains(new String("AA"))); // true， 他是調用String equals(override)，故是判斷內容值而非記憶體位址
        System.out.println(coll.contains(new Person("Tim",16)));// false，他是調用Object.equals，但這個相當於==，故如果想要比較內容，則需要overrideequals
                                                                            // override後就會變成true

        // 7. containsAll(Collection e) return boolean: 判斷此集合的元素是否有囊括 e的所有元素
        Collection coll2 = new ArrayList<>();
        coll2.add("123");
        System.out.println(coll.containsAll(coll2)); // false， 因為一個是string一個是Integer

        // 8. remove(Object o): 移除元素o，它會調用o 的 equals 去和list的元素比較，再次提醒，Collection一定要重寫equals!!!!
        coll.remove(123);
        System.out.println(coll);

        // 9. removeAll(Collection e): 移除 屬於e的元素，它必須調用equals!
        Collection coll3 = new ArrayList<>();
        coll3.add("dog");
        coll3.add(123);
        coll.removeAll(coll3);
        System.out.println(coll);

        // 10. retainAll(Collection e): 此集合變成與e的交集
        coll.add(123);
        coll.add("dog");
        coll.retainAll(coll3);
        System.out.println(coll);

        // 11. equals(Object o): 判斷集合與o之  元素  與  順序 (是否要考慮順序，取決於你是用 set還是list)   是否皆相同
        System.out.println(coll.equals(coll3));

        // 12. hashCode() return int: 返回 hashcode
        System.out.println(coll.hashCode());

        // 13. toArray() return Object: 集合轉成array
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        // 13.1 . Arrays.asList(Object): array轉 list，primitive的array 會視為一個元素，所以要更換成其包裝類
        List list = Arrays.asList(new String[]{"AA","BB"});
        List list1 = Arrays.asList(new int[]{12,35,5});
        List list2 = Arrays.asList(new Integer[]{1,56,3});
        System.out.println(list);  //視為兩個元素: [AA, BB]
        System.out.println(list1); //視為一個元素: [[I@731f8236]
        System.out.println(list2); //視為三個元素: [1,56,3]

        // 14. iterator() return iterator interface: 返回 iterator interface 的instance，用於集合元素的遍歷

    }
}

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals被重寫囉!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        System.out.println("Person Hashcode 被override!!!");
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Book{
    int ID;

    @Override
    public boolean equals(Object o) {
        System.out.println("Book equals override!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

