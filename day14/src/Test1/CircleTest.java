package Test1;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(c1.getTotal());

        Circle c3 = new Circle(12.3);
        System.out.println(c3.getId());
        System.out.println(c1.getTotal());
    }
}

class Circle {
    private double radius;
    private int id; // 自動給予數字

    public Circle(){
        this.id = init++;
        total ++;
    }

    public Circle(double radius){
        this();
        this.radius = radius;
    }

    static private int total = 0;
    static  private int init = 1001;

    public double findArea(){
        return radius * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }
}