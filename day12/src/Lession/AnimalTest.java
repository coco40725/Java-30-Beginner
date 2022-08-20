/*
* 有了多態性，我們定義的方法其 formal parameter可以只定義 父類，不需要每一個子類都定義!
* 我們只需要在子類中，定義其override的方法後，即可直接用那個方法調用!
*
* */
package Lession;


public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog()); // Animal animal = new Dog()


    }
    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }

    /* 有了多態性，我們就可以不寫
    public void func(Dog dog){
        dog.eat();
        dog.shout();
    }
    public void func(Cat cat){
        cat.eat();
        cat.shout();
    }
    */
}

class Animal{
    public void eat(){
        System.out.println("動物吃");
    }

    public void shout(){
        System.out.println("動物叫");
    }

}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃狗糧");
    }

    public void shout(){
        System.out.println("汪汪汪!!!");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("貓吃魚");
    }

    public void shout(){
        System.out.println("喵~~");
    }
}