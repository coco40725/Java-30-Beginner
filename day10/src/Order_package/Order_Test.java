package Order_package;

import Test.Order;

public class Order_Test {
    public static void main(String[] args) {
        Order order  = new Order();
        // order.orderDefault = 1; error: default variable 出了其package 便不可調用
        order.orderPublic = 2;
        // order.orderPrivate = 3; error: Private variable 出了其class 便不可調用

        // order.methodDefault(); error: default variable 出了其package 便不可調用
        order.methodPublic();
        // order.methodPrivate();error: Private method 出了其class 便不可調用


    }
}
