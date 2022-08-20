package Test;

public class InterviewTest1 {
    public static void main(String[] args) {
        Base1 base1 = new Sub1();
        base1.add(1,2,3); // sub1

        Sub1 s = (Sub1) base1;
        s.add(1,2,3);
    }
}

class Base1{
    public void add(int a, int... arr){
        System.out.println("base1");
    }

}

class Sub1 extends  Base1 {
    public void add(int a, int[] arr){
        System.out.println("sub1");
    }

    public void add(int a, int b, int c){
        System.out.println("sub1_2");
    }

}