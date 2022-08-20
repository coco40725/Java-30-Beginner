package Test7;

public interface CompareObject {
     abstract public  int compareTo(Object o); // return 0 --> 相等; return 正數 代表
}

class Circle {
     private Double radius;

     public Circle(double radius){
          this.radius = radius;
     }

     public Double getRadius() {
          return radius;
     }

}

class Rectangle{
     private Integer width;
     private Integer height;

     public Rectangle(int width, int height){
          this.width = width;
          this.height = height;
     }

     public Integer getWidth() {
          return width;
     }

     public Integer getHeight() {
          return height;
     }

     public Integer findArea(){
          return width * height;
     }
}

class CompareableCircle extends Circle implements CompareObject{

     public CompareableCircle(int radius){
          super(radius);
     }

     @Override
     public int compareTo(Object o) {
          if (o instanceof Circle) {
               Circle o_circle = (Circle) o;
               /*若 radius為 primitive variable 則需要手動寫比較大小
               *     if (this.getRadius() == o_circle.getRadius() ) {
                    System.out.println("The radius of this circle is equal to Compare_Circle");
                    return  0;
               }else if (this.getRadius() > o_circle.getRadius()){
                    System.out.println("The radius of this circle is larger than Compare_Circle");
                    return this.getRadius() - o_circle.getRadius();
               }else{
                    System.out.println("The radius of this circle is smaller than Compare_Circle");
                    return this.getRadius() - o_circle.getRadius();
               }
               * */
           return this.getRadius().compareTo(o_circle.getRadius());

          }else{
               System.out.println("Object is not the instance of Circle");
               return -9;
          }
     }
}

class CompareableRectangle extends Rectangle implements CompareObject{

     public CompareableRectangle(int width, int height){
          super(width,height);
     }

     @Override
     public int compareTo(Object o) {
          /*若 width height 為 primitive variable 則需要手動寫比較大小
          * if (this.findArea() == o_rectangle.findArea() ) {
                    System.out.println("The area of this rectangle is equal to Compare_rectangle");
                    return  0;
               }else if (this.findArea() > o_rectangle.findArea()){
                    System.out.println("The radius of this rectangle is larger than Compare_rectangle");
                    return this.findArea() - o_rectangle.findArea();
               }else{
                    System.out.println("The radius of this rectangle is smaller than Compare_rectangle");
                    return this.findArea() - o_rectangle.findArea();
               }
          *
          *
          * */
          if (o instanceof Rectangle) {
               Rectangle o_rectangle = (Rectangle) o;
               return this.findArea().compareTo(o_rectangle.findArea());

          }else{
               System.out.println("Object is not the instance of rectangle");
               return -9;
          }
     }
}