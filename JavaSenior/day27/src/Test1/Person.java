package Test1;

import java.io.Serializable;

/**
 * @author Yu-Jing
 * @create 2022-08-09-AM 10:33
 */
public class Person implements Serializable {
    private static String name;
    private transient int age;
    private boolean gender;

    public static final long serialVersionUID = 42521552L;

    public Person(){}

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
