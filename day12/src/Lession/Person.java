package Lession;

public class Person {
    String name;
    int age;
    int id = 1001; // 身分證號碼

    public Person(){

    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println("人可以吃飯");
    }

    public void walk(int distance){
        System.out.println("人走了 " + distance + "公里");
        show();
    }

    private void show(){
        System.out.println("我是一個人");
    }
}
