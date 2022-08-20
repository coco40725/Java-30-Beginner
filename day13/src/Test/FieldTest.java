package Test;

public class FieldTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count); // 20
        s.display(); //output 20

        Base b = s; // 多型，兩者的記憶體位址與 class 類型完全鄉同
        System.out.println(b == s); // true
        System.out.println(b.count); // 10
        b.display(); // override: 20

    }
}

class Base{
    int count = 10;





    public void display(){
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;
    public void display(){
        System.out.println(this.count);
    }
}
