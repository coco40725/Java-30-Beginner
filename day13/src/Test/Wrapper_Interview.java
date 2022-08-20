package Test;

import org.junit.Test;

public class Wrapper_Interview {
    @Test
    public void test1(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1); // 1.0，因為 三元運算子會 "統一格式"，故 int 會提升成 double
    }

    @Test
    public void test2(){
        Object o2;
        if (true){
            o2 = new Integer(1);
        }else {
            o2 = new Double(2.0);
        }
        System.out.println(o2); // 1
    }

    @Test
    public void test3(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false, i and j 存取記憶體位置

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true,
                                    // 因為自動裝箱建立 Wrapper的方式不是採用 new，
                                    // 而是先提前建立了一個array (詳請可看 IntegerCache)，裡面有-127~128，然後直接從裡面拿數字，因此得到的地址值才會相同ˋ

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false，由於超過那個array，必須採用new方式，故地址值不同

    }
}
