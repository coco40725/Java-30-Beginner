package TEST;

public class Person {
    public static void main(String[] args) {
        Person s = new student();
        Person ss = new research();
        System.out.println(s.getClass().getSimpleName() );
        System.out.println(ss.getClass().getSimpleName() );
    }
}

class student extends Person{}

class research extends student{}