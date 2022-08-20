/*
* 多態性 : 一個事物的多種形態
* a. 對象的多態性: 父類的引用 指向 子類的對象
* b. 虛擬方法調用 (Virtual Method):
* 當有了對象的多態性後，編譯的過程中，只能調用父類有的方法，而運行過程中則會動態地調用 父類與子類同名參數的方法 (override method)。
* 總結: 編譯看左邊，運行看右邊 (只適用方法)
* c. 屬性不存在多態性!
* d. 多態性的前提: 父類子類、override方法
* --------------------------------------------------------
* 1. 動態綁定: 運行前，在編譯器上無法確定到底是調用哪個方法 (無法確定說出 方法名 + formal parameter)，
* 在執行期間（非編譯期）才可判斷所引用對象的實際類型，根據其實際的類型調用其相應的方法。例如: 多態性
* 2. 靜態綁定: 在程序運行前就已經知道方法是屬於那個類的，在編譯的時候就可以連接到類的中，定位到這個方法。 例如 overload
*-------------------------------------------------------
* 為何要使用多型?
* https://www.ptt.cc/bbs/java/M.1405790781.A.742.html
* */

package Lession;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man m1 = new Man();
        m1.eat();
        m1.age = 25;
        m1.earnMoney();

        // ************************** 多態性 **************************
        Person p2 = new Man(); //此case 又稱為 對象的多態性，父類的引用 指向 子類的對象
        // p2 的 class是 Person
        p2.eat(); // 編譯的時候，eat是用Person，但運行卻是用 Man
        System.out.println(p1.id);
        // p2.earnMoney 無法調用
        Person p3 = new Woman();



    }
}
