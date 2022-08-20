/*
* 內部類 inner class:
* 1. 允許在類A 中 定義一個 類B，類B稱為內部類；類A稱為外部類
* 2. 內部類:
*    a. 成員內部類
*       一方面作為外部類的 屬性: 權限修飾、final、static
*       另一方面又是作為一個類: 可以定義 屬性 方法 構造子 代碼塊 內部類；可以權限修飾、final、abstract
*    b. 局部內部類: 內部類定義在 方法體中、code block、constructor
*
* 3.
* 3.1 如何實例化成員內部類?
*      靜態局部內部類
*      Person.DF p1 = new Person.DF();
*
*      非靜態局部內部類
*      Person p2 = new Person();
       Person.DD dd = p2.new DD();
*
* 3.2 如何區分調用 內部類與外部類的結構
         System.out.println(this.name); // 內部類的對象
         System.out.println(Person.this.name); //Person.this 代表 這個this是 外部類的對象
* 3.3 開發中局部內部類的使用，看 InnerClassTest1
* */
package Test8;

public class InnerClassTest {
    public static void main(String[] args) {
        // 創建 DF 靜態局部內部類
        Person.DF p1 = new Person.DF();
        p1.speak();

        // 創建 DD 非靜態局部內部類，必須要用 new 的
        Person p2 = new Person();
        Person.DD dd = p2.new DD();
        dd.test("測測看");

        //


    }
}

class Person{
    int age;
    String name = "外部類";
    public void eat(){}

    //非靜態成員內部類
    class DD{
        int a = 12;
        String name = "內部類";
        public void test(String name){
            eat(); // this.eat() 這是錯誤的，因為你現在在類裡面，因此 this是 內部類的對象，內部類並沒有定義 eat
            // eat() = Person.this.eat()
            Person.this.eat();
            System.out.println(name); // formal parameter
            System.out.println(this.name); // 內部類的對象
            System.out.println(Person.this.name); //Person.this 代表 這個this是 外部類的對象
        }
    };
    //靜態成員內部類
    static class DF{
        public void speak(){
            System.out.println("okay");
        }
    };

    public Person(){
        //局部內部類
        class CC{};
    }
    public void method(){
        //局部內部類
        class AA{}
    }

    {
       //局部內部類
        class BB{}
    }
}