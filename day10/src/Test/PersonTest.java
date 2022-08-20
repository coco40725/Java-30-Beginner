package Test;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getAge());
        System.out.println(p.getName());
        p.setAge(12);
        System.out.println(p.getAge());
        //p.setAge(-12);
    }
}
