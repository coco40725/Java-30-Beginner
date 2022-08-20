/*
* equal(Object object) 與 == 差異
* a. ==
*    1. 此為運算子
*    2. 應用在 primitive variable 與 reference variable : a == b
*       2.1 如果是應用在primitive variable，則比較兩個變數保存的 數值 是否相同，a, b 類型不一定要相同!
*       2.2 如果是應用在 reference variable，則比較兩個變數存的 記憶體位址 是否相同
*
* b. equals(Object object)
*    1. 此為方法
*    2. 只能應用在 reference variable
*    3. public boolean equals(Object object){
*        if (this == object) return true;
*       }
*      基本上作用與 == 相同，皆是比較 記憶體位址， 然而!!
*      若 reference variable 是 "String", "Date" , "File"，則會重新撰寫 equals function，此時的 equals 則是比較 "實體內容 (也就是屬性值)" 是否相同 而非記憶體位址
*    4. 那自訂的class 如何去比較 兩個class 屬性值是否相同?
*       我們需要對 Object的 equal 進行 override，可以自己寫，也可以直接generate
* */

package Test;

import javax.swing.text.html.parser.TagElement;
import java.util.Objects;

public class EqualTest {
    public static void main(String[] args) {

        int i = 10;
        int j = 20;
        double ii = 10.0;
        boolean jj = true;
        char c = 10;
        char c1 = 'A';
        char c2 = 65;
        System.out.println(i == ii);
        // System.out.println(j == jj); error!
        System.out.println(c == i); // true
        System.out.println(c1 == c2); // true

        Customer cus1 = new Customer(18,"Tom");
        Customer cus2 = new Customer(18,"Tom");
        String str1  = new String("abc"); // new: 開一個空間， 將str1的值abc 存在 Heap，str1存記憶體位址
        String str2  = new String("abc"); // new: 開一個空間， 將str2的值abc 存在 Heap，str2存記憶體位址
        String str11 = "aa"; // str11的值aa 存在 Heap 中的 string pool，str11 存記憶體位址
        String str22 = "aa"; // 直接從string pool 找是否有aa，有的話 直接把此記憶體位址給 str22

        System.out.println("cus1 == cus2: " + (cus1 == cus2)); // false

        //********************* String Test ***********************************
        System.out.println("str1 == str2: " + (str1 == str2)); // false，
        System.out.println("str11 == str22: " + (str11 == str22)); // true，
        // 為何String 使用 System.out.println() 直接 output 出內容物，而非記憶體位址? 問題出在 toString!
        /*
        Object 的 toString 是如此定義的:
        public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
        但是 String class，則 override toString，把它改成會回傳 String 值本身 (the string itself.)，因此才不是回傳記憶體位址，
        */
        System.out.println(str1);
        System.out.println(cus1);

        System.out.println();
        //*******************************************************************************
        System.out.println("cus1 == cus2: " + (cus1.equals(cus2))); // false， override後 可以變成 true
        System.out.println("cus1 == str1: " + (cus1.equals(str1)));
        System.out.println("str1 == str2: " + (str1.equals(str2))); // true ???  WHY???
    }

}

class Customer{
    int age;
    String name;

    Customer (int age, String name){
        this.age = age;
        this.name = name; // 這樣的寫法，代表 name 是存在 String pool
    }
/*
    @Override
    public boolean equals(Object obj) {
        // 若 記憶體位址相同，則必然同一個東西
        if (obj == this) return true;

      // 如果 obj 不是 Customer instance ，則直接 false
        if (obj instanceof Customer){
            // 若 obj 是 Customer instance， 則為了可以比較 屬性值，我們必須先把 obj 強制轉成 Customers
            // 注意! 如果比較的屬性值中，有Strting，記得要轉換成 equals!
            Customer tmp = (Customer) obj;
            if (tmp.age == this.age && tmp.name.equals(this.name)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name);
    }


}