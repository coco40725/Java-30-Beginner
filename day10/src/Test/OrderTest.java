package Test;

public class OrderTest {
    public static void main(String[] args) {
        Order order  = new Order();
        order.orderDefault = 1;
        order.orderPublic = 2;
        // order.orderPrivate = 3; error: Private variable 出了其class 便不可調用

        order.methodDefault();
        order.methodPublic();
        // order.methodPrivate();error: Private method 出了其class 便不可調用


    }
}

