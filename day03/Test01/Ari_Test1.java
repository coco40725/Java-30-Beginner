/*
隨意給定一個 3 位數，接著分別print出其百位數、十位數與個位數
例如: 153
百位數: 1
十位數: 5
個位數: 3


*/

// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day03\Test01\Ari_Test1.java
// java -classpath D:\Java_lession\1_basic\code\day03\Test01 Ari_Test1


class Ari_Test1{
    public static void main (String args[]){
        int num = 153;
        int num_3 = num / 100;
        int num_2 = (num - num_3 * 100)/10;
        int num_1 = num - num_3 * 100 - num_2 * 10 ;

        System.out.println("百位數: " + num_3);
        System.out.println("十位數: " + num_2);
        System.out.println("個位數: " + num_1);
    }
}