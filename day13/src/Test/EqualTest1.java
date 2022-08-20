package Test;

public class EqualTest1 {
    public static void main(String[] args) {
        Order2 o1 = new Order2(12,"Tom");
        Order2 o2 = new Order2(12,"Tom");
        Order2 o3 = new Order2(1,"Garry");
        System.out.println("o1 == o2 : " + o1.equals(o2));
        System.out.println("o1 == o3 : " + o1.equals(o3));

    }
}

class Order2{
    private int orderId;
    private String orderName;

    Order2 (int orderId, String orderName){
        this.orderName = orderName;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj ) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Order2 tmp = (Order2) obj;
        if (tmp.orderId == this.orderId && tmp.orderName.equals(this.orderName)){
            return true;
        }else{
            return false;
        }
    }
}
