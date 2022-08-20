package Test;

public class Class_Test2 {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.name = "Tom";
        p1.age = 18;
        p1.sex = 1;
        p1.showAge();
        p1.study();
        p1.addAge(2);
        p1.showAge();
    }
}

class Person1{

    //Field
    String name;
    int age;
    int sex;

    // Method
    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println(age);

    }

    public int addAge(int i){
        age += i ;
        return age;

    }
}