/*
* 如果結果不正確，但是卻沒有跑出error，怎麼去找錯誤呢?
* 1. 可以採用 System.out.println() 去看看中間環節是否有出錯
* 2. deBug功能:
*  a. 設定斷點: 執行到此點時先停一下
*  b. 使用Debug: Step over (跳下一行code); step into (進到某一個function去詳細看變數長怎樣); step out (跳出此function)
*
* */
package Lession;

public class DeBugTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println("i = " + i + "," + "j = " + j);

        DeBugTest test = new DeBugTest();
        int max = test.getMax(i, j);
        System.out.println("max = " + max);

    }
    private int getMax(int k, int m){
        int max = 0;
        if (k < m){
            max = k;
        }else {
            max = m;
        }
        return max;
    }
}
