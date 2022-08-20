package Test;
/*
* 一、如何設計 類?
* 1. 創建類，並設計類
* 一個類 需要包含 屬性 (Field)、方法 (Method)、建構子 (這3者較常用); 代碼塊、內部類別
* 2. 創建對象
* 3. 調用對象的屬性與方法
*
* 二、
* 1. 如果針對一個class創見多個 instance，則每一個instance都獨立的擁有一套類屬性 (非static)，換言之，我們修改任一個instance的屬性值，
* 並不影響另一個instance的屬性值
*
* 三、
* class的記憶體解析
* https://www.youtube.com/watch?v=vhpkCmxVEeI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=181
*
* */

// 測試 Person class
public class Person_Test {
    public static void main(String[] args) {

        // 創建Person class的instance = 創建對象
        Person p1 = new Person();

        // 調用對象的屬性 (Field)
        p1.name = "Tom";
        p1.isMale = true;
        p1.age = 40;

        // 調用對象的方法 (Method)
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");

        // 創建 Person class的 instance
        Person p2 = new Person();
        System.out.println(p2.name); // null
        System.out.println(p2.isMale); // false





    }
}

class Person{

    // Field
    String name;
    int age = 1;
    boolean isMale;

    // Method
    public  void eat(){
        System.out.println("可以吃飯");
    }

    public   void  sleep(){
        System.out.println("可以睡覺");
    }

    public   void talk(String language){
        System.out.println("可以交流，使用語言: " + language);
    }

}

