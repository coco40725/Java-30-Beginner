/*
* statiic 靜態
* 1. 目的: 使某些特定的數據在 記憶體內貯存一份，例如: 某個Class的 A屬性-國家 所有對象都一樣，都是顯示台灣，我們會希望 這個屬性值-台灣，
* 可以存成一份就好，讓所有對象共同使用
* 2. 用於修飾class, Field, method, 代碼塊, 內部類 的結構 (不包含 constructor)
* a. Field: 使用 static ，則稱為 "靜態屬性"；沒有使用static，則稱為 "非靜態屬性"。
*    靜態屬性: 所有對象共享此屬性，代表當某個對象修改此屬性，會導致其他對象調用此靜態變數時，會調出改變過的。
*    非靜態屬性: 對象不共享此屬性。
*    其他說明: a.靜態屬性是依附在class上，換言之，class創建完，此屬性便創建，不需要依附 instance
*             b. 由於class只會創建一次，代表靜態屬性亦只會創建一次，效率好。
*             c. 靜態屬性存於 記憶體中的 method的靜態域
*    靜態屬性的例子: System.out, Math.PI,
*
*
* b. Method:
*    靜態方法: 所有對象共享此方法，方法依附在class，
*             -- 只能調用 靜態方法與靜態屬性!  (因為靜態方法是依附在class上，若出現非靜態的方法或屬性，則會導致他必須依附在對象上!)
*             -- 不能使用 this, super (因為這些是代表 對象)
*    非靜態方法: 對象不共享此方法，可以調用 (非)靜態方法與 (非)靜態屬性!
*
* Q1: 如何判斷 屬性 是否要聲明 static?
*     此屬性不會隨對象不同而不同，大家可以共用
* Q2: 如何判斷 方法 是否要聲明 static?
*     a.操作 "靜態屬性"的方法，通常也會設計成靜態
*     b.工具類的方法 習慣設計成靜態，因為這樣不需要創對象就可以調方法，很方便!
*
* */

package Test1;

public class StaticTest {
    public static void main(String[] args) {
        Student.school = "NCC"; // 可見 靜態屬性在 instance建立前便建立好了
        Student.exam(); // 可見 靜態方法在 instance建立前便建立好了

        Student s1 = new Student();
        s1.age = 20;
        s1.name = "Frank";
        s1.school = "NTU";
        s1.exam();

        Student s2 = new Student();
        s2.age = 23;
        s2.name = "Allen";
        System.out.println(s2.school); // 不是 null，而是"NTU"
        s2.school = "NCHU";
        System.out.println(s1.school); // 被修改了，從"NTU"變成"NCHU"
    }
}

class Student{
    static String school;
    int age;
    String name;

    public void eat(){
        System.out.println("吃飯");
        System.out.println(school); //省略的是 Student.school, 而不是 this.school
    }

    public static void exam(){
        System.out.println("考試");
        // eat(); error!
        // name = "dd"; errpr
    }

}