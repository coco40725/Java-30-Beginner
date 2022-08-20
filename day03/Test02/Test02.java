// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day03\Test02\Test02.java
// java -classpath D:\Java_lession\1_basic\code\day03\Test02 Test1
// java -classpath D:\Java_lession\1_basic\code\day03\Test02 Test2
// java -classpath D:\Java_lession\1_basic\code\day03\Test02 Test3

class Test1 {
    public static void main(String args[]){

     // 定義3個int ，並以a. 三元運算子   b. if-else 抓出最大值
     int i_1 = 20;
     int i_2 = -100;
     int i_3 = 13;

     // a. 三元運算子 
     int thr_max = (i_1 > i_2) ? i_1 : i_2;
     thr_max = (thr_max > i_3) ? thr_max : i_3;
     System.out.println("(三元) 最大值為 " + thr_max);


     // b. if-else
     if (i_1 >= i_2 && i_1 >= i_3){
         System.out.println("(if-else) 最大值為 " + i_1);
     } else if  (i_2 >= i_1 && i_2 >= i_3){
         System.out.println("(if-else) 最大值為 " + i_2);
     } else {
         System.out.println("(if-else) 最大值為 " + i_3);
    }
    
  }
}

class Test2{
    public static void main(String args[]){
     
     // 給予兩個double , 若第1個值大於10.0 且 第2個值小於 20.0 則兩值相加，否則兩值相乘
     double d1 = 12.3;
     double d2 = 32.1;


     double d3 = (d1 > 10.0 && d2 < 20.0) ? (d1 + d2) : (d1 * d2);
     System.out.println(d3);


    }

}


class Test3{
    public static void main(String args[]){

        //交換兩個變量值
        String s1 = "台北";
        String s2 = "台南";

        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println(s1 + "; " + s2);




    }
}
