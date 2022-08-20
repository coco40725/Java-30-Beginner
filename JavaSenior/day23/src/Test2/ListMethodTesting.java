/*
*List 除了從 Collection 集合繼承的方法外， List 集合里添加了一些根據索引來
操作集合元素的 方法 則返回零 。
*
void add( int index, Object ele) : 在 index 位置插入 ele 元素
boolean addAll(int index, Collection eles) : 從 index 位置開始將 eles 中的所有元素添加進來
Object get( int index): 獲取指定 index 位置的元素
int indexOf (Object obj): 返回 obj 在集合中首次出現的位置，不存再返回-1
int lastIndexOf (Object obj): 返回 obj 在當前集合中末次出現的位置，不存再返回-1
Object remove( int index): 移除指定 index 位置的元素，並返回你所移除的元素 (overload)
void remove(Object o): 移除指定的Object (overload)
Object set( int index, Object ele): 設置指定 index 位置的元素為 ele，並返回被更改的元素
List subList(int fromIndex , int toIndex): 返回從 fromIndex 到 toIndex位置的子集合, [fromIndex, toIndex)
*
*
* 常用的方法:
* 增加: add(Obj)
* 刪除: remove(int), remove(obj)
* 改: set(int, Obj)
* 查該位置的元素:  get(int)
* 查元素在哪裡:  indexOf(Object obj) / lastIndexOf(Object obj)
* 插: add(int Obj)
* 長度: size
* 遍歷: Iterator next, hasNext / for(Object e : List)
* */
package Test2;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-14-PM 03:05
 */
public class ListMethodTesting {
    @Test
    public void test(){
        ArrayList arr = new ArrayList( 5);
        arr.add(123);
        arr.add(456);
        arr.add("AA");
        arr.add(new Person("Tom", 26));
        arr.add(456);
        System.out.println(arr.toString());

        // add(int index, Object obj)
        arr.add(2,"FuckYou");
        System.out.println(arr);

        // addAll(int index, Collection eles)
        List list = Arrays.asList(new Integer[]{1,2,3});
        arr.addAll(1,list);
        System.out.println(arr);

        // Object get( int index): 獲取指定 index 位置的元素
        System.out.println(arr.get(5));

        // int indexOf (Object obj): 返回 obj 在集合中首次出現的位置
        System.out.println(arr.indexOf(456));

        // int lastIndexOf (Object obj): 返回 obj 在當前集合中末次出現的位置
        System.out.println(arr.lastIndexOf(456));

        // Object remove( int index): 移除指定 index 位置的元素，並返回此元素
        System.out.println(arr.remove(0));

        // Object set( int index, Object ele): 設置指定 index 位置的元素為 ele
        System.out.println(arr.set(0, 9856));

        // List subList(int fromIndex , int toIndex): 返回從 fromIndex 到 toIndex位置的子集合
        System.out.println(arr);
        System.out.println(arr.subList(4,7));

        // 方式一: Iterator
        Iterator iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------------------");
        // 方式二: for
        for (Object obj : arr){
            System.out.println(obj);
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
