package Exer2;

public class Producer extends Thread{
    private Product prod;

    public Producer(Product prod){
        this.prod = prod;
    }

    public void makeProduct(){
        synchronized (prod){
        if (prod.getAmount() < 20){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            prod.setAmount(prod.getAmount() + 1);
            System.out.println(currentThread().getName() + "製造一個產品。" + "商品數量: " + prod.getAmount());
            prod.notify();

        } else {
                try {
                    System.out.println("商品數量過多，暫時休業!");
                    prod.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (prod.getAmount() < 20) System.out.println("已通知可以開始製造!");
                }
            }
        }

    }

    @Override
    public void run() {
        while(true){
            makeProduct();
        }
    }
}
