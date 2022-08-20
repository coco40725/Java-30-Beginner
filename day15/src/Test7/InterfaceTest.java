package Test7;

public class InterfaceTest {
    public static void main(String[] args) {
        CompareableCircle c1 = new CompareableCircle(5);
        CompareableCircle c2 = new CompareableCircle(15);
        System.out.println(c1.compareTo(c2));

        CompareableRectangle r1 = new CompareableRectangle(20,15);
        CompareableRectangle r2 = new CompareableRectangle(10,26);
        System.out.println(r1.compareTo(r2));
        System.out.println(r1.compareTo(new String("155")));
    }




}
