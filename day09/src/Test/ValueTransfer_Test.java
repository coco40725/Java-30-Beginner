/*
* Primitive Variable:
* 1. Variable 存在 Stcak, 保存的是 "確切地值"
*
* Reference Variable:
* 2. Variable 存在 Stack, 但是存的是 "記憶體地址"，確切的結構與值 在 Heap
*
*
*
* */

package Test;

public class ValueTransfer_Test {
    public static void main(String[] args) {
        // ************* Primitive Variable *****************************************
        int m = 20;
        int n = m;
        System.out.println(m);
        n = 10;
        System.out.println(m);

        // ************* Reference Variable *****************************************
        Other o1 = new Other();
        Other o2 = new Other();
        o1.ID = 1000;
        o2 = o1;
        System.out.println(o1.ID);
        o2.ID = 99;
        System.out.println(o1.ID);

    }
}

class Other{
    int ID;
}
