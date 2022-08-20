/*
* Singleton 單例設計模式
* 1. 整個過程中，確保某個類只能產生一個對象 (記憶體位址不會變)，換言之，這個類無法在外面隨便的使用 new 來創新對象
* 2. 餓漢式方法:
*    a. 將class constructor設計成 private
*    b. class的內部創建 private static 對象
*    c. 使用public static 方法來獲取 此對象
*
* 3. 餓漢式 vs 懶漢式
*   餓漢式:
*    壞處: 一開始就建立對象，存在於記憶體的時間過長；
*    好處: 線程安全
*   懶漢式:
*   壞處: 目前的寫法，線程較不安全
*   好處: 可以延遲對象的創建，減少存在時間
* */
package Test3;

public class Singleton1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        System.out.println(bank1);

        Bank bank2 = Bank.getInstance();
        System.out.println(bank2);

    }
}

class Bank{

    private Bank(){

    }

    private static Bank instance = new Bank(); // instance 創建完畢，後續的對象直接共用它，故可以直接調

    public static Bank getInstance(){
        return instance;

    }
}