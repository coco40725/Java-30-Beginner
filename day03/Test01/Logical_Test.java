// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day03\Test01\Logical_Test.java
// java -classpath D:\Java_lession\1_basic\code\day03\Test01 logicial_test
// java -classpath D:\Java_lession\1_basic\code\day03\Test01 Logical_advanTest

class logicial_test {
    public static void main(String args[]){

        // Test 01
        int x_1 = 1;
        int y_1 = 1;

        if (x_1++ == 2 & ++y_1 == 2){
            x_1 = 7;
        }

        System.out.println("x_1 = " + x_1 + "; y_1 = " + y_1); // x_1 = 2; y_1 = 2

        // Test 02
        int x_2 = 1,  y_2 = 1;
        if (x_2++ == 2  && ++y_2 == 2){
            x_2 = 7;
        }
        System.out.println("x_2 = " + x_2 + "; y_2 = " + y_2); // x_2 = 2; y_2 = 1

        // Test 03
        int x_3 = 1,  y_3 = 1;
        if (x_3++ == 1  | ++y_3 == 1){
            x_3 = 7;
        }
        System.out.println("x_3 = " + x_3 + "; y_3 = " + y_3); // x_3 = 7; y_3 = 2

        // Test 04
        int x_4 = 1,  y_4 = 1;
        if (x_4++ == 1  || ++y_4 == 1){
            x_4 = 7;
        }
        System.out.println("x_4 = " + x_4 + "; y_4 = " + y_4); // x_4 = 7; y_4 = 1



   
   
   
    }
}

class Logical_advanTest{
    public static void main(String args[]){
        boolean x = true;
        boolean y = false;
        short z = 42;

        // if (y ==  true)
        if ( (z++ == 42) && (y == true)) z++; 
        if ( (x == false) || (++z == 45)) z++;

        System.out.println("z = " + z ); // z = 42+1+1 if y = false; z = 42+1+1+1+1 if y = true


    }
}