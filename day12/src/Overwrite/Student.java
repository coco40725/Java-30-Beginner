package Overwrite;

public class Student extends Person {
    String major;
    int id = 1002; // 學號

    public Student(){

    }
    public Student(String major){
        // 其實有 super();
        this.major = major;
    }

    public Student(String name, int age, String major){
        //this.age = age;
        //this.id = id;
        // 如果 age與 id被 並定義成private 則上述的寫法會抱錯，當然，你也可以寫 this.setage 或 this.setname，
        // 但這裡提供更好的寫法，直接調用他的constructor:
        super(name, age);
        this.major = major;


    }

    public void study(){
        System.out.println("學生學習的專業是" + this.major);
    }

    // 想要重寫(Override/Overwrite) eat function
    public void eat(){
        System.out.println("學生應該多吃營養食物");
        super.eat(); // super 代表的是 父類的class
    }

    public void show(){

        System.out.println("name = " + this.name + ", age = " + super.age + ", 學號 = " + super.id);
    }



}
