package Test;

public class Class_Test1 {
    public static void main(String[] args) {

    }
}

class Student{
    // Field
    String name;
    int age;
    String major;
    String interest;

    // Method
    public String say(){
        String info  = "學生名字: " + name + "\t" + "年齡: " + age + "\t" + "主修: " + major + " \t" + "興趣: " + interest;
        return info;
    }

}

class Teacher{
    // Field
    String name;
    int age;
    int teachAge;
    String course;

    // Method
    public void say(){
        System.out.println("教師名字: " + name);
        System.out.println("age: " + age);
        System.out.println("teachAge: " + teachAge);
        System.out.println("course: " + course);

    }



}