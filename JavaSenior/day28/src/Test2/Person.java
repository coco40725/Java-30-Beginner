package Test2;

import java.util.Comparator;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 10:44
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparator<String>, MyInterface {

    private String name;
    int age;
    public int id;

    @MyAnnotation("coool")
    public Person(){};

    private Person(String name){
        this.name = name;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation("bad")
    private String show(String nation) throws  Exception, NullPointerException{
        System.out.println( "國籍:" + nation);
        return nation;
    }

    public static String display(String str){
        return "興趣是: " + str;
    }

    @Override
    public void inference() {
        System.out.println("我人");

    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
