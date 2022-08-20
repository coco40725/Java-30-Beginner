/*
* Formal Parameter: 方法定義時，聲明的小括弧中的參數
* Actual Parameter: 方法調用時，實際傳遞給形參的數值
*
*
*
*
* */

package Test;

public class VariableTransfer_Test1 {
    public static void main(String[] args) {
        VariableTransfer_Test1 m1 = new VariableTransfer_Test1();
        // *******  失敗 *********** Primitive Variable 使用function來 調整會有問題
        int m = 12;
        int n = 10;
        m1.swap(m,n); // m,n are actual parameter
        System.out.println("m = " + m + " n = " + n); // 沒有換成功! Why? 首先swap所定義的的變數 n, m 是存在stack，
                                                     // swap是調整 swap 的 n 與 m 的順序 (不是 main的 n,m)，
                                                    // 當swap執行完畢會銷毀stack 的變數 swap n,m (stack的特性)
        int[] arr1 = new int[]{3,5};
        m1.swap(arr1[0], arr1[1]);
        System.out.println("arr1[0] = " + arr1[0] + " arr1[1] = " + arr1[1]); // 一樣沒換成功

        // ****** 成功 ********** Reference Variable 使用function 來調整是可以的
        Data d1 = new Data();
        d1.n = 10;
        d1.m = 15;
        m1.swap(d1); // d1 = dat = 記憶體地址 存在stack
        System.out.println("d1.n = " + d1.n + " d1.m = " + d1.m); // 成功! why? 因為 這一次定義的swap 他是直接在 Heap操作的，
                                                                 // swap結束後，只銷毀了 dat (記憶體地址)與tmp (int 變數)
                                                                 // Heap沒有動





    }

    /**
     * 交換兩個變數的方法
     * @param n
     * @param m
     */
    public void swap(int n, int m){ // i and j are formal parameter
        int tmp = n;
        n = m;
        m = tmp;
    }

    public void swap(Data dat){
        int tmp = dat.n;
        dat.n = dat.m;
        dat.m = tmp;
    }

}

class Data{
    int m;
    int n;
}
