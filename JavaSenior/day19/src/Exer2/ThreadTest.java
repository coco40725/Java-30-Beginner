package Exer2;

public class ThreadTest {
    public static void main(String[] args) {
        Product product = new Product();
        Producer producer = new Producer(product);
        Customer customer1 = new Customer(product);
        Customer customer2 = new Customer(product);

          producer.setName("製造商1");
          customer1.setName("消費者1");
          customer2.setName("消費者2");

           producer.start();
           customer1.start();
           customer2.start();



    }
}

