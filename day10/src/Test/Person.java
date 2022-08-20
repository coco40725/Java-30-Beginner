package Test;

import com.sun.nio.sctp.PeerAddressChangeNotification;

public class Person {
    // Field
    private int Age;
    private String name;

    // Constructor
    public Person(){
        Age = 18;
        name = "Unknown";
    }


    // Method
    public void setAge(int n){
        if (n >= 0  && n <= 130 ){
            Age = n;
        }else {
            Age = -9;
            throw new RuntimeException("不合理的年齡");
        }
    }

    public void setName(String n){
        name = n;
    }

    public int getAge(){
        return  Age;
    }
    public String getName() {return name;}




}
