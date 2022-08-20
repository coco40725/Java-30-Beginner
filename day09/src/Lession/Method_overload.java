/*
* 1. method overload:
* 同一個class中，可以有複數個相同名字的方法，只要參數 類型或個數或順序 不同即可，而這種方法，我們稱為是overload方法
* 例如: Arrays的 sort(int); sort(double)
*
* 2. 可變個數的 formal parameter
* show (String ... strs){
* }
* a. strs  就是 one-dimension Array!
* b. 此寫法是 JDK5 新增的，另外這個寫法是"完全等價"於 show (String[] strs){}、因此只能擇一
* c. 另外，可變個數的 formal parameter 一定要寫在最後
*   show (int i, String ... strs); correct
*   show (String ... strs, int i); error
* d. 可變個數的 formal parameter 只能存在一個!
*
* */
package Lession;

public class Method_overload {
    public static void main(String[] args) {
        Method_overload m = new Method_overload();
        m.getSum(1,2);
        m.getSum("11");
        m.getSum("123", "56566");
        // 如果 我們把 getSum (int i, int j) 移除，請問 m.getSum(1,2); 會抱錯嗎?
        // 不一定，首先java會自動去找與其匹配的 getSum, 例如getSum (double i, double j), getSum (int i, double j)
        // 如果 java發現有一個以上的function可以匹配，則會報錯，因為他會不知道要用哪個
        //  java: reference to getSum is ambiguous
        //  both method getSum(int,double) in Lession.Method_overload and method getSum(double,int) in Lession.Method_overload match
        // 相反地，若只有一個匹配，則java不會報錯
    }

    // 以下方法為 overload methods
    public void getSum (int i, int j){
        System.out.println("1");

    }

    public void getSum (double i, double j){
        System.out.println("2");

    }
    public void getSum (int i, double j){
        System.out.println("3");
    }

    public void getSum (double j, int i){
        System.out.println("4");

    }
    public void getSum (String s){
        System.out.println("5");

    }

    public void getSum (String ... s){
        System.out.println("6");
        for (int i = 0; i < s.length ; i++) System.out.println(s[i]);

    }



    // 以下不算 overload
    /*
    public int getSum (int i, int j){

    }
    private void getSum (int i, int j){

    }

    * */

}
