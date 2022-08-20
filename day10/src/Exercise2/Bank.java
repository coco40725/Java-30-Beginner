package Exercise2;

import java.util.Arrays;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank(int MaxCustomer){
        customers = new Customer[MaxCustomer];
    }

    public void addCustomer(String f, String l){
        Customer new_c = new Customer(f, l);
        customers[numberOfCustomer ++] = new_c;
    }

    public Customer getCustomers(int index) {
        if (index < numberOfCustomer){
            return this.customers[index];
        } else {
            throw new RuntimeException("index 超出範圍");
        }
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
}
