package Test;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1= new TriAngle();
        t1.setBase(12.2);
        t1.setHeight(52.3);
        System.out.println(t1.getBase() + " " + t1.getHeight());

        TriAngle t2 = new TriAngle(3.6,66.3);
        System.out.println(t2.getBase() + " " + t2.getHeight());




    }
}
