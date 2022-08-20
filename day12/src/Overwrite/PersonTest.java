/*
* 方法的重寫:
* 子類繼承父類後，可以對 同名 同formal parameter(含順序與數量) 的方法進行覆蓋操作
*
* 重寫的規則:
* 0. 方法的聲明: 權限修飾子 返回值類型 方法名 (formal parameter) throws 異常類型{
* .......code .......
* }
* 1. 子類重寫的方法，僅方法名與formal parameter 必須完全相同
* 2. 子類重寫的方法，其權限修飾子 必須 不小於 父類的方法
*    特殊情況: 子類 不可以重寫 父類方法權限為 private 的方法!
*3. 返回值:
*  a. 若父類方法的返回值為 void ，則子類重寫之方法亦必須為 void
*  b. 若父類方法的返回值為 A 類型，則子類重寫之方法可為A 類 或 A的子類
*  c. 若父類方法的返回值為 基本數據類型，則子類重寫之方法必須為 相同的基本數據類型
*  d. 子類重寫之方法 之異常類型 必須小於 父類方法的異常類型
*  e. 非static 才會考慮 重寫， static 方法是無法被重寫的!
*
* */

/*
* super:
* 1. super: 可以視為 父類的class
* 2. 可以使用super去用父類的屬性，方法，constructor
* 3. super(formal parameter): 也是必須列在首行 ( 如同 this(formal parameter)，故 this(formal parameter) 與 super(formal parameter) 只能二選一 )
* 4. 當類的 constructor  首行沒有特標示 this(formal parameter) or super(formal parameter)， 則系統是預設上 放 super()
* 5. 在多個constructor中， 至少有一個constructor一定是放 super()
* */
package Overwrite;

public class PersonTest {
    public static void main(String[] args) {
        Student s = new Student("資工");
        s.eat(); // 執行的是 子類override的方法
        s.walk(123);
        s.study();
        s.show();

        Student s1 = new Student("Tom", 12, "美術");
        s1.show();
    }

}
