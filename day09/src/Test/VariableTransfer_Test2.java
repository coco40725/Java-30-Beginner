package Test;

import java.awt.*;

public class VariableTransfer_Test2 {
    public static void main(String[] args) {
        PassObject p = new PassObject();
        Circle c = new Circle();
        c.radius = 102;
        p.printAreas(c, 15);
        System.out.println("now radius = " + c.radius);

    }

}

class Circle{
    // Field
    double radius;


    // Method
    public double  findArea(double r){
        double area = r * r * Math.PI;
        return area;
    }

}

class PassObject{
    public void printAreas(Circle c, int time){
        System.out.println("Radius" + "\t" + "Area");
        for (double i = 1; i < (time + 1); i++){
            System.out.println(i + "\t\t" + c.findArea(i));
        }


    }
}