// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day03\Test01\SetValue_Test1.java
// java -classpath D:\Java_lession\1_basic\code\day03\Test01 Setvalue_Test

class Setvalue_Test {
    public static void main(String args[]){

        // Test 1:
        int i = 1;
        i *= 0.1; // 可以過，但是 i *0.1 = 0.1 然後由於i是 int格式 故i會是 0
        System.out.println(i); // i = 0
        ++i;
        System.out.println(i); // i = 1

        // Test 2:
        int m = 2;
        int n = 3;
        n *= m++; // n = n * m++
        System.out.println("m = " + m); // m = 3
        System.out.println("n = " + n); // n = 6 !! m是後加!

        // Test 3:
        int n_1 = 10;
        n_1 += (n_1++) + (++n_1); // n_1 = n_1 + (n_1++) + (++n_1)
        System.out.println("n_1 = " + n_1); // n_1 = 10 + 10 + (11+1) = 32

    }
}