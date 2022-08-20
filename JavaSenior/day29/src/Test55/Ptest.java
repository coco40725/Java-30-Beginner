package Test55;

/**
 * @author Yu-Jing
 * @create 2022-08-17-PM 01:10
 */
public class Ptest {
    public static void main(String[] args) {
        Object obj = new Person();
        Person p = (Person) obj;
        ability ab = (ability) obj;


        // Object無法體現Person的方法! 除非使用 (Person) obj 或者是 (ability) obj
        // 試想一個情境: 請問已知interface，且透過 class A 實現，但 class A 未知的情況下，如何調用 class A 的 method A ?
        ability ab1 = (ability) obj;
        ab1.say("good");


    }


}
