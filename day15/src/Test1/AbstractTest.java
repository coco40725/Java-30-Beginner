/*
* abstract
* 1. 可用於修飾 class, method
* 2. abstract class: 此類不能實例化,但這不代表 這個class的 constructor沒有用，因為子類會調用父類constructor
*    abstract method: 只有方法聲明，沒有方法體，它不能調出來，代表 "abstract method 一定只能出現在 abstract class"。
*                     當你的方法的方法體是取決於子類，則會建議此方法與父類就定成abstract。
* 3. abstract注意:
* a.Field, constructor, code block, private method (子類無法override), static method(因為這樣不算是override), final method(不可以override) 不能修飾
*
* Note:
* 習慣上，若是子類對父類的方法重新撰寫 (方法名與formal parameter相同)，習慣稱為 override，
* 而若是對 abstract method 進行重新撰寫，亦可稱為override，但精確一點的話叫做 implement
* */

package Test1;

public class AbstractTest {
    public static void main(String[] args) {
        // Person p1 = new Person(); 一旦Person 變成 abstract，則無法new
        //p1.eat();
        Person p1 = new Student(23,"dd");
        test();

    }

    public static void test(){
        System.out.println();
    }
}

abstract class Person{
    int age;
    String name;

    public  Person(){}
    public  Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println("吃飯");
    }
    public void walk(){
        System.out.println("走路");
    }

    abstract public void study();

}

class Student extends Person{

    public Student(int age, String name){
        super(age, name);
    }

    public void study(){
        System.out.println("學生要學習");
    }

}


