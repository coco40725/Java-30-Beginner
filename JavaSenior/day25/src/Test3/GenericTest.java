/*
* 1. 泛型在繼承方面的體現
* 即使 classA 與 classB，則 List<classA> 與 List<classB> 仍不具有子父類關係，兩個是獨立的Class!
* 但是若 classA 與 classB 是子父類關係，或者是 實現關係，則 classA<E> 與 classB<E> 仍維持子父類或實現關係! 注意 泛型結構的類型要相同
*
* 2. 泛型的通配符: ?
* 根據上面的例子，我們知道  List<classA> 與 List<classB> 之間不存在子父類關係，那麼兩者之間是否有共同的父類，(除了Object以外)，
* 有的:
*   List<?> listall  = null;
* 透過這層關係，我們可以展現出 多態的概念!

服 */
package Test3;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yu-Jing
 * @create 2022-07-28-AM 11:37
 */
public class GenericTest {

    @Test
    public void test(){
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
//        list1 = list2;   即使 String 與 Object彼此是子父類關係，則 List<Object> 與 List<String> 仍不具有子父類關係

        List<Object> list3 = null;
        ArrayList<Object> list4 = null;
        list3 = list4;

        List<?> listall  = null;
        listall = list1;
        listall = list2;
        show(list1); // 多態
        show(list2); // 多態
    }

    // 遍歷用的function
    public void show(List<?> list){
        Iterator <?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next(); // 多態
            System.out.println(o);
        }
    }
    @Test
    public void test2(){
        //
        List<?> list = null;
        List<String> list1 = new ArrayList<>();
        list1.add("AA");
        list1.add("BB");
        list1.add("CC");
        list = list1; // 等同於 List<?> list = new ArrayList<>(); 多態性

        // 添加，list<?> 這種通配符 是不能添加數據的，它會要求你填入? 但你又填不出來
        // list.add(123);
        // list.add("dhdh");

        // 瀏覽 ，list.get(0) 它返回的類型是 ? 但你可以用Object去抓取
        Object o = list.get(0);
        System.out.println(o);

    }

    @Test
    public void test3(){
        /*
        * 限制型通配符
        * 1. ? extend Person : 裡面的reference類型是 小於等於Person 的 Class
        * 2. ? super Person : 裡面的reference類型是 大於等於Person 的 Class
        *
        * */

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Son> list3 = null;
        List<Person> list4 = new ArrayList<>();
        list4.add(new Person());
        list4.add(new Son());

        List<Object> list5 = null;

        list1 = list3;
         list1 = list4;
//        list1 = list5;
//
//        list2 = list3;
        list2 = list4;
         list2 = list5;

         // 瀏覽 List<? extends Person> ，使用最大的class給變數
        Person pp = list1.get(0);
//        Son ss = list1.get(0); 錯誤! 這樣會導致 Son ss = new Person()

        // 瀏覽 List<? super Person> ，使用最大的class給變數
        Object oo = list2.get(0);
//        Person od = list2.get(1); 錯誤! 這樣會導致 Person od = new Object()

        // 添加數據
        // list1.add(new Son()); 錯誤! 因為 <? extend Person> 可能會出現比Son還要小的class，如此會變成 smallSon ss = new Son();
        list2.add(new Person()); //通過 因為 ParentClass ff = new Person()
        list2.add(new Son()); // 通過 因為 ParentClass ff = new Son()

    }


}
