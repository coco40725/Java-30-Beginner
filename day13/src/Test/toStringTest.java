/*
toString
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
   }
1. 當我們使用 System.out.println()，基本上就是調用 toString()
2. String, Date, File class 的 toString 有 override，返回的是 屬性值
3. 自定義類亦可以透過 override toString ，使System.out.println() output 出 屬性值，也可以自動 Generate
*
* */
package Test;

import java.util.Date;

public class toStringTest {
    public static void main(String[] args) {
        Customer cust1 = new Customer(12,"Tom");
        System.out.println(cust1.toString());
        System.out.println(cust1);
        String s1 = new String("123");
        System.out.println(s1); // output "123"
        Date d1 = new Date(12354556L);
        System.out.println(d1); // output Thu Jan 01 11:25:54 CST 1970

        NewCustomer new_cust1 = new NewCustomer(123,"Yoo");
        System.out.println(new_cust1);
    }
}

class NewCustomer{
    int age;
    String name;

    NewCustomer (int age, String name){
        this.age = age;
        this.name = name; // 這樣的寫法，代表 name 是存在 String pool
    }

    @Override
    public String toString() {
        return "NewCustomer [ name = " + name + ", age = " + age + "]";
    }
}
