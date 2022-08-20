/*
*  Constructor 構造子
* 1. constructor 功用:
*  a. 創建對象
*  b. 可以在創建對象時，指定這個對象要有指定好屬性的初始化值 或 指定該對象必須進行甚麼功能方法操作 ，這樣之後就不用一直重複做 方法調用或屬性值指定的操作
*  ex. Person p = new Person() ; Person() 為構造子
* 2. 若沒有特別定義構造子，系統會自動提供一個 沒有參數的構造子
* 3. 定義構造子: 權限修飾子(與類相同) 類名(參數){......}
* 4. 一個類中可以定義多個構造子，而彼此稱為 overload constructor
* 5. 另外，若你已經定義了 constructor，則 "沒有參數的構造子" ，你必須要自己定義
*
*
* */

package Lession;

import com.sun.nio.sctp.PeerAddressChangeNotification;

public class Constructor {
    public static void main(String[] args) {
        Person p = new Person();

        Person p1 = new Person("Tom");
        System.out.println(p1.name);

        Person p2 = new Person("Tim", 15);
            System.out.println(p2.name);
            System.out.println(p2.Age);

    }
}

class Person{
    // Field
    int Age;
    String name;

    // Constructor
    public Person(){
        System.out.println("Persone()......");
    }

    public Person(String n){
        name = n;

    }

    public Person(String n, int m){
        name = n;
        Age = m;
    }

    // Method
    public void eat(){
        System.out.println("人可以吃");
    }

    public void study(){
        System.out.println("人可以學習");
    }
}