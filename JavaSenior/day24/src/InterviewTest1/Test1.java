package InterviewTest1;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Yu-Jing
 * @create 2022-07-15-PM 04:18
 */
public class Test1 {
    @Test
    public void test1(){

        /*
        * Collection interface remove function
        * 1. remove(Object o) method 是透過call o.equals method來判斷o與collection的元素是否為相同。
        * 2. List實現類.remove(Object o) 判斷 A物件是否與B物件相同: 直接調用 o.equals + 迴圈 去找哪個 "index" 的element與 o相同
        * 3. Set實現類.remove(Object o) 判斷 A物件是否與B物件相同: 先調用 o.Hashcode 來判斷 o的位置，在去該位置檢查是否有元素，
        *                                                     若無元素，代表o不在此set; 若有元素，則往下執行 o.equals 來判斷此元素是否與o相同。
         * */
        HashSet set = new HashSet<>();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        set.remove(p1); // call p1.Hashcode，但是由於p1改過內容，因此Hashcode會與 "一開始p1的Hashcode" 不同，自然會找到不一樣的位置了!
        System.out.println(set); // CC, AA

        set.add(new Person(1001,"CC"));
        System.out.println(set); // CC, CC, BB

        set.add(new Person(1001,"AA"));
        System.out.println(set); // CC-AA, CC, BB


    }
}

class Person{
    int number;
    String name;

    public Person(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return number == person.number && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}