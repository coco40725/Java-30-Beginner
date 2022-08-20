/*
* 遍歷Collection元素(不包含 Map): Iterator interface 的使用
* 1. next(): index往下並回傳元素
* 2. hasNext(): 還有下一個元素嗎? true or false
* 3. 集合每次調用iterator() 都是全新的iterator，默認是index從第一個元素之前
* 4. remove(): 移除當前元素，iterator.remove() 不同於 Collection.remove(Object o)
*
* */
package Test1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yu-Jing
 * @create 2022-07-13-PM 01:52
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("POE"));
        coll.add("food");
        coll.add(new Person("petter",65));
        coll.add(false);

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        // 若超過 集合的元素則會報異常: java.util.NoSuchElementException

        // 方式1: 但不推薦
//        for (int i = 0; i < coll.size(); i++){
//            System.out.println(iterator.next());
//        }
        // 方式2: 較推薦
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("POE"));
        coll.add("food");
        coll.add(new Person("petter",65));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("food".equals(obj)){
                iterator.remove();
            }

        }

        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }

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
        System.out.println("equals被重寫囉!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
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