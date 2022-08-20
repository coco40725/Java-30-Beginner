/*
 * Singleton 單例設計模式
 * 1. 整個過程中，確保某個類只能產生一個對象，換言之，這個類無法在外面隨便的使用 new 來創新對象
 * 2. 懶漢式方法:
 *    a. 將class constructor設計成 private
 *    b. 只聲明當前類的對象，不進行初始化 (也就是不使用new)
 *    c. 使用public static 方法來new並獲取 此對象
 *
 * */
package Test3;

public class Singleton2 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        System.out.println(o1);

        Order o2 = Order.getInstance();
        System.out.println(o2);
    }
}

class Order{
    private Order(){}

    private static Order Instance = null;

    public static Order getInstance(){
        /**
         * 錯誤的寫法:
         * Instance = new Order(); 每調一次方法。就new 一次 class，雖然整體只會有一個class但是記憶體位只會變動
         * return Instance;
         *
         */
        if (Instance == null){
            Instance = new Order();
            return Instance;
        }else {
            return Instance;
        }


    }

}

