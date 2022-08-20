/*
* 多態性 : 一個事物的多種形態
* a. 對象的多態性: 父類的引用 指向 子類的對象 (宣告父類 ，使用 子類構造子來 new)
* b. 虛擬方法調用 (Virtual Method):
* 當有了對象的多態性後，編譯的過程中，只能調用父類有的方法，而運行過程中則會動態地調用 父類與子類同名參數的方法 (override method)。
* 總結: 編譯看左邊，運行看右邊 (只適用方法)
* c. 屬性不存在多態性!
* d. 多態性的前提: 父類子類、override方法
* --------------------------------------------------------
* 1. 動態綁定: 運行前，在編譯器上無法確定到底是調用哪個方法 (無法確定說出 方法名 + formal parameter)，
* 在執行期間（非編譯期）才可判斷所引用對象的實際類型，根據其實際的類型調用其相應的方法。例如: 多態性
* 2. 靜態綁定: 在程序運行前就已經知道方法是屬於那個類的，在編譯的時候就可以連接到類的中，定位到這個方法。 例如 overload
*-----------------------------------------------------------
* * 為何要使用多型?
 * https://www.ptt.cc/bbs/java/M.1405790781.A.742.html
 * ------------------------------------------------------------------
 * Q1: Person為 super class，Man 為 subclass請問 Heap中是否有存入 Man subclass 所定義的屬性與方法?
* A1: 有的，由於你是 new Man()，則Heap中會建立一個空間存取 Man subclass 所有的屬性與方法，
* 但是，由於你聲明 p1 是 Person class，則 p1 只能去調用 Heap空間中的 Man subclass 其 Person 屬性與方法
*
* Q2: 呈Q1，請問如何調出 Man subclass 所定義的屬性方法?
* A2: 將 p1 變數類型 強制轉換成 Man 類型，此行為稱為 向下轉型 (使用率不高)，Man m2 = (Man) p2; 相反地，若是子類轉成父類，則稱為 向上轉型 ，其時就是多態。
* 注意! 使用強轉類型，可能會出現 ClassCastException 異常 (但是編譯的時候不會出現， 執行時才會出現) ，為避免此情況，可以先使用 instanceof 判斷
*
* instanceof:
* a instanceof A: 判斷 a 是否是 A的 instance
*
* */

package Instanceof;

import javax.management.PersistentMBean;
import java.util.Date;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();
        System.out.println(p1);

        Man m1 = new Man();
        m1.eat();
        m1.age = 25;
        m1.earnMoney();

        // ************************** 多態性 **************************
        Person p2 = new Man();
        // 編譯時期，p2 的 class是 Person
        // 運行時期，p2會調用子類的 override方法，這時 p2又會變成 Man class
        // 換言之，p2是 Man class 的 instance 亦是 Person class 的 instance
        p2.eat(); // 編譯的時候，eat是用Person，但運行卻是用 Man
        System.out.println(p2.id); // 1001 回報 Person 的 id
        // p2.earnMoney 無法調用，因為 編譯時期，p2 的 class是 Person
        System.out.println(p2); // 記憶體位址，他是記成Man class

        Man m2 = (Man) p2;
        System.out.println(m2); // 記憶體位置不會變
        m2.eat();
        m2.earnMoney();

        // Woman w1 = (Woman) p2; ClassCastException

        if (p2 instanceof Woman){
            Woman w1 = (Woman) p2;
            w1.goShopping();
            System.out.println("p2 是 Woman class 的 instance");
        }

        if (p2 instanceof Person){
            System.out.println("p2 是 Person class 的 instance");
        }

        if (p2 instanceof Man){
            System.out.println("p2 是 Man class 的 instance");
        }

        if (p2 instanceof Object){
            System.out.println("p2 是 Object 的 instance");
        }

        // 練習1:
        Object obj = new Woman();
        System.out.println("obj 是 Person 的 instance嗎? " + (obj instanceof Person));

        // 練習2:
        Person p4 = new Person();
        System.out.println("p4 是 Man 的 instance嗎? " + (p4 instanceof Man));

        // 練習3:
        Object o = new Date();
        System.out.println("o 是 String 的 instance嗎? " + (o instanceof String));






  }
}
