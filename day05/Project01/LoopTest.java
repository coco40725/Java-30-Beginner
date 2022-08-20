//javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\Project01\LoopTest.java
/*
code無法執行! 
因為在 loop 結構中所"建立"的變數，皆無法拿到loop 外使用，除非，
你一開始就建好!
*/
class Test {
    public static void main (Strings args[]){
        // for
        for (;;){
            int sum = 1; 
            break;
        }
        System.out.print(sum);
        
        //
        while (true){
            int sum1 = 100;
            break;
        }
        System.out.println(sum1);

    }
}