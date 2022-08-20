/*
* * * B. 集合框架
 *   | ----- Collection interface : 單列接口，用來存一個一個的object
 *       |----- List interface : 存有序可重複的數據，又可稱為 動態Array (因為可以修改)
 *           |----- ArrayList, LinkedList, Vector 實現類
 *
 *       |----- Set interface : 存無序不可重複的數據，也就是 "set"
 *           |----- HashSet 實現類: 作為set interface的主要實現類，thread not safe，可存取null
 *                      |----- LinkedHashSet 實現類: 為HashSet子類，增加了雙向鏈，使的遍歷其內部資料時，會按照"你添加資料的順序" 來遍歷，適用於對數據頻繁的遍歷操作
 *           |----- TreeSet 實現類: 必須"存放同樣類型"的物件，必依照物件的特定屬性來"排序"，如果是自己定義的class，要自行定義好排序方法，
 *                                  例如自然排序或定製排序
 *                                       - 自然排序: 元素 class 進行 implement comparable interface
 *                                       - 定製排序: 使用TreeSet的 constructor (含有comparator)
 *                                  這裡要注意的是，TreeSet在比較物件的時候，不是使用equals ，而是使用compareTo，因此，如果是使用TreeSet，
 *                                  則不需要特別override equals與 Hashcode.
 *
*
* */
package Test3;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-15-PM 02:07
 */
public class TreeSetTest {
    @Test
    public void test1(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person tmp1 = (Person) o1;
                    Person tmp2 = (Person) o2;

                    if (tmp1.age == tmp2.age){
                        return -tmp1.name.compareTo(tmp2.name);
                    }else {
                        return  -Integer.compare(tmp1.age, tmp2.age);
                    }

                }
                throw new RuntimeException("not available Object");
            }
        };


        Set set = new TreeSet();
        Set set1 = new TreeSet(comparator);
//        set.add(456);
//        set.add(123);
//        set.add(123);
//        set.add("AA");
//        set.add("CC");
//        set.add(new Person("Tom",26));
        // 不可添加不同類型的對象

        set.add(123);
        set.add(-12);
        set.add(55);
        set.add(12);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next()); // 從小排到大
        }

        set1.add(new Person("Tom",26));
        set1.add(new Person("Riby",26));
        set1.add(new Person("Eric",23));
        set1.add(new Person("Pink",10));
        set1.add(new Person("Tom",10));

        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next()); // 從小排到大
        }





    }

}

class Person implements Comparable{

    String name;
    int age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        System.out.println("equals override!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode override!!");
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    // 先年齡從小到大 ; 再name
    public int compareTo(Object o) {
        if (o  instanceof  Person) {
            Person tmp = (Person) o;
            if (this.age == tmp.age) {
                return this.name.compareTo(tmp.name);
            }else{
               return Integer.compare(this.age, tmp.age);
            }
        }
        throw new RuntimeException("非Person instance !");
    }
}