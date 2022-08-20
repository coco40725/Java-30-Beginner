/*
* Interface (接口)
* 0. 目的在於解決多繼承的問題，java不支援多父類，因此提出了interface
* 1. 繼承是 描述 A (Student) 是不是 B (Person)，而接口描述的是 A (Student) 是否有 B (閱讀論文) 的功能
* 2. interface 的等級是與 class 是並列的。
* 3. interface的格式:
*    JDK 7.0以前:
*         只可定義 全局常數 (public static final ) 與 抽象方法 (abstract public )
*
*    JDK 7.0以後:
*         除可定義 全局常數 (public static final ) 與 抽象方法 (abstract public )，另可定義 靜態方法 (static method) 與 默認方法
*      ** 接口內定義的 靜態方法 只能用接口去調用: Interface.method
*      ** 接口內定義的 默認方法 能用 實現類的對象去調用，且可以override:
*         s.method
*         或者可以透過 interface+ super 來調
*         Interface.super.method
*
*      ** 若父類與接口 接出現同名同參數的方法，若子類調用此方法(沒有override)，則調用的是 父類的方法。
*      ** 若兩個街口出現同名同餐的方法，而實現類不但沒有重寫，且同時實現這兩個接口，則會報錯，因為會不知道要調誰的，稱為接口衝突
*
* 4. interface 不能有constructor，故不能實例化 (創建對象)。
* 5. interface 大多是透過 類 來執行interface裡面的code: 使用 implements
*    若 這個類 "完全" override interface中的 abstract method，則 此類可以實例化，
*    反之 若沒有完全override，則此類仍是一個 abstract class，無法實例化
*
* 6. 可以實現多個接口，以此來代替多繼承
* 7. 先寫繼承(extends) 再寫 實現(implements):
* class AA extends BB implements CC, GG, LL {}
*
* 8. interface之間與有 繼承關係，且可已是多繼承關係 (即可以有多父類)
* 9. interface 是一種規範，基本上都是定義了一些 常數 或 抽象方法(大概的方法，但是具體會有差異)
* 10. interface 亦有多態性: USB usb = new Printer()
* */
package Test5;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        Plane plane1 = new Plane();
        plane1.method2(); // Plane.method1() 出現error並說沒有定義，why?
        Flyable.method1(); // 接口可以調用，
    }
}

interface Flyable{

    // 全局常數
    public final static int MAX_SPEED = 7900;
    int MIN_SPEED = 1; // 為何沒報錯? 這邊其實是系統幫你省略了 public final static

    // 抽象方法
    abstract public void fly();
    void stop(); // 為何沒報錯? 這邊其實是系統幫你省略了 abstract public

    // 靜態方法
    public static void method1(){
        System.out.println("靜態方法輸出");
    }

    // 默認方法
    public default void method2(){
        System.out.println("默認方法輸出_Fly");

    }

}

interface Attackable{
    abstract public void attack();
    public default void method2(){
        System.out.println("默認方法輸出_Attack");

    }

}

class Plane extends Object implements Flyable, Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    public void attack(){

    }
    public  void method2(){
        System.out.println("默認方法輸出_override");

    }
    public void showMethod2(){
        method2();
        Attackable.super.method2();
        Flyable.super.method2();
    }
}

interface AA{}
interface BB{

}
interface CC extends AA, BB{}
