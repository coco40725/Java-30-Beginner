/*
* code block (代碼塊)
* 1. 功能: 用於初始化當前對象或類
* 2. 結構:
*     靜態 code block: static {}; 隨著類的加載而加載，且同時執行，但只執行一次。 若一個類中定義了多的static code block，則按照聲明的先後順序來執行。
*     非靜態 code block: {}; 隨著對象的加載而加載，且同時執行，美創建一個對象，便執行一次。若一個類中定義了多的static code block，則按照聲明的先後順序來執行。
* 3. 先父類再子類，先static 再 non-static
* */
package Test4;

public class BlockTest {
    public static void main(String[] args) {
        String dsc = Person.desc; // 加載class
        Person p1 = new Person();// 加載對象
        Person p2 = new Person();// 加載對象
    }
}

class Person{

    // Field
    String name;
    int age;
    static String desc = "人類";

    // Constructor
    public Person(){

    }

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    // Method
    public void eat(){
        System.out.println("吃飯");
    }

    public static void info(){
        System.out.println("必須呼吸");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // code block
    {
        System.out.println("non-static code block");

    }

    static {
        System.out.println("static code block 1");
    }
    static {
        System.out.println("static code block 2");
        info();
    }
}