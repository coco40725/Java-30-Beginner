package Test;

import java.util.Objects;

public class GeometricTest1 {
    public static void main(String[] args) {
        Circle1 c1 = new Circle1(2.3);
        Circle1 c2 = new Circle1(2.3,"white",2.0);

        System.out.println("c1與c2顏色是否相同? " + c1.getColor().equals(c2.getColor()));
        System.out.println("c1與c2半徑是否相同? " + c1.equals(c2));
        System.out.println(c1);
    }
}

class GeometricObject1{
    protected String color;
    protected double weight;

    protected GeometricObject1(){
        this.color = "white";
        this.weight = 1.0;
    }
    protected GeometricObject1(String color, double weight){
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
}

class Circle1 extends GeometricObject1{
    private double radius;

    public Circle1(){
        super();
    }

    public Circle1(double radius){
        super();
        this.radius = radius;
    }
    public Circle1(double radius, String color, double weight){
        super(color,weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return radius * radius * Math.PI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Circle1 tmp = (Circle1) o;
        if (tmp.radius == this.radius) {
            return true;
        }else {
            return false;
        }

    }

    public String toString(){
        return "The radius of circle is " + radius;

    }

}