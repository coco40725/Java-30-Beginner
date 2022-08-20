package Test;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c1 = new Circle(2.3, "white",1.0);
        test.displayGeometricArea(c1);
        Circle c2 = new Circle(2.9, "white",1.0);
        test.displayGeometricArea(c2);
        System.out.println(test.equalArea(c1,c2));

        MyRectangle m1 = new MyRectangle(12,20,"black",2.0);
        test.displayGeometricArea(m1);
        System.out.println(test.equalArea(m1,c2));

    }

    public boolean equalArea(GeometricObject g1, GeometricObject g2){ // 多型性
        return g1.findArea() == g2.findArea();
    }

    public void displayGeometricArea(GeometricObject g1){ // 多型性
        System.out.println("面積是: " + g1.findArea());
    }
}


class GeometricObject{
    protected String color;
    protected double weight;

    GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea(){
        return 0.0; // 理論上應該寫出微積分
    }
}

class Circle extends GeometricObject{
    private double radius;

    Circle (double radius, String color, double weight){
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea(){
        return radius * radius * Math.PI;
    }
}

class MyRectangle extends GeometricObject{
    private double width;
    private double height;

    MyRectangle(double width, double height,  String color, double weight){
        super(color, weight);
        this.width = width;
        this.height = height;

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea(){
        return width * height;
    }
}