package Test414;

/**
 * @author Yu-Jing
 * @create 2022-07-28-PM 02:06
 */
public class Test {
    public static void main(String[] args) {
        Person ps = new Son();
        Person p = new Person();
        Son s = new Son();



        System.out.println(ps.getClass().getSuperclass());
        System.out.println(p.getClass().getSuperclass());
        System.out.println(s.getClass());
    }
}

class Person{
    int id = 1;
    public void show(){
        System.out.println("父類!");
    }
}

class Son extends Person{
    int id = 0;
    public void show(){
        System.out.println("子類!");
    }
}
class Animal{
    String name;
}