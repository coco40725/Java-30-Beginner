package Test;

public class InstanceTest {

    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        test.method(new Graduate());
    }

    public static  void method(Person e){
        String info = e.getInfo();
        System.out.println(info);

        if (e instanceof Graduate){
            System.out.println("a graduate student");
        }

        if (e instanceof Student) {
            System.out.println("a student");
        }

        if (e instanceof Person){
            System.out.println("a person");
        }
    }
}

class Person{
    protected String name;
    protected int age;
    public String getInfo(){
        return "Name: " + name + "\n" +
                "age: " + age;
    }
}

class Student extends Person{
    protected String school = "NTU";
    public String getInfo(){
        return "Name: " + name + "\n" +
                "age: " + age + "\n" +
                "school: " + school;
    }
}

class Graduate extends Student{
    public String major = "IT";
    public String getInfo(){
        return "Name: " + name + "\n" +
                "age: " + age + "\n" +
                "school: " + school + "\n" +
                "major: " + major;
    }
}