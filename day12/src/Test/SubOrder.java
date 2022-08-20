package Test;

import Lession.Order;

public class SubOrder extends Order {
    public void method(){
        OrderPublic = 1;
        OrderProtect = 2; // protect 權限修飾子: 不同package但是是屬於子類，則可以直接用父類的變數與方法
        // OrderDefault = 3; 不可見
        // OrderPrivate = 4; 不可見
    }
}
