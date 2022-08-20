package Test;

public class Class_Test3 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 2.1;
        double size = c1.calArea();
        System.out.println(size);
    }
}

class Circle{
    // Field
    double radius;
    double area;

    // Method
    public double calArea(){
        area = radius * radius * Math.PI;
        return area;
    }

}