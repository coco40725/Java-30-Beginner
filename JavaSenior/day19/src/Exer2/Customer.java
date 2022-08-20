package Exer2;

public class Customer extends Thread{
    private Product prod;

    public Customer(Product prod){
        this.prod = prod;
    }

    public void buyProduct(){
        synchronized (prod){
            if (prod.getAmount() > 0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                prod.setAmount(prod.getAmount() - 1);
                System.out.println(currentThread().getName() + "購買產品，" + "產品數量: " + prod.getAmount());
                prod.notify();
            }else {
                try {
                    System.out.println("告知 " +currentThread().getName()+ ": 產品缺貨，請等待!");
                    prod.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (prod.getAmount() > 0) System.out.println("告知 " +currentThread().getName()+ ": 可以買貨!");
                }
            }
        }
    }

    @Override
    public void run() {
        while(true){
            buyProduct();
        }
    }
}
