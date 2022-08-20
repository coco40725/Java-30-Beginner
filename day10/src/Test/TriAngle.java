package Test;

public class TriAngle {
    // Field
    private double base;
    private double height;

    // Constructor
    public TriAngle(){}
    public TriAngle(double i, double j){
        base = i;
        height = j;
    }

    // Method
    public void setBase(double i){
        base = i;
    }
    public void setHeight(double j){
        height = j;
    }

    public double getBase(){
        return base;
    }
    public double getHeight(){
        return height;
    }
}
