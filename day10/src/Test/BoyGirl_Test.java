package Test;

public class BoyGirl_Test {
    public static void main(String[] args) {
        Boy b1 = new Boy();
        b1.setName("羅密歐");
        b1.setAge(21);
        b1.shout();

        Girl g1 = new Girl(18);
        g1.setName("茱麗葉");
        g1.marry(b1);

        Girl g2 = new Girl(23);
        g2.setName("祝英台");
        System.out.println(g2.compare(g1));
        System.out.println(g1.compare(g2));

    }
}
