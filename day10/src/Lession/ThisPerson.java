/*
* this 可以用於 修飾或調用 Field, Method, Constructor
*
* 1. this 修飾 Field, Method:
* 此時，this 可以代表當前 class 的對象。 this.Field; this.Method
* 大部分的情況傾向省略，除特殊情況，例如: 方法的formal parameter 與 Field 名字相同
*
* 2. this 在 Constructor中，修飾 Field, Method
* 此時，this 可以代表當前 class 的對象。 this.Field; this.Method，可以調用正在創建的屬性與方法
* 大部分的情況傾向省略，除特殊情況，例如: 構造子的formal parameter 與 Field 名字相同
*
* 3. this 在 Constructor中，調用 constructor
* 當你的constructor內部有很多很多的code，而你的constructor又非常多個，則比較適合透過this來調用constructor 來簡潔版面。
* 如果有 n 個constructor，則有 n-1 constructor 使用 this。
* 另外，this.() 只能放第一row，因此 constructor只能有一個 this
*
*
* */

package Lession;

public class ThisPerson {
    public static void main(String[] args) {
        Person_this p1 = new Person_this();
        p1.setAge(11);
        System.out.println(p1.getAge());

        Person_this p2 = new Person_this(22, "Tom");
        System.out.println(p2.getAge());
    }
}

class Person_this{
    // Field
    private int age;
    private String name;

    // Constructor
    Person_this (){
        this.eat();
        this.study();
        this.eat();
        this.study();
        this.eat();
        this.study();
    }
    Person_this (String name){
        this(); // 直接調用 Person_this () 這個constructor
        this.name = name;
    }
    Person_this (int age){
        this();// 直接調用 Person_this () 這個constructor
        this.age = age;
    }

    Person_this (int age, String name){
        this(age); // 直接調用 Person_this (int age) 這個constructor
        // this.age = age; 多餘
        this.name = name;
        // age = age; 執行code不會報錯，但是，程式其實會認為這兩個age 都是 formal parameter 的 age
        // this 代表的是 當前class的對象，因此使用 this.age 可以很明確的調用出這個class的 age
    }

    // Method
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void eat(){
        System.out.println("人吃飯");
        study();
        // 等價於 this.study();
    }
    public void study(){
        System.out.println("人學習");
    }

}
