/*
* final:
* 1. 可以修飾 class, method, variable
* 2. final class: 它不能往下延伸出子類， 例如: String, System, StringBuffer，
*    final method: 它不能被override，例如:getClass()
*    final variable: 它的值不能變動，變成常數
*                      a. final field: 屬性一旦賦值，便不可再變動；可以一開始便賦值，或是在code block、constructor再賦值
*                        (為何方法不能? 因為final要求 在對象被聲明出來後就必須把值賦上，若是使用方法來定值，會太晚!)
*                      b. final local variable : 變數一旦賦值，便不可再變動；
*
*
*    static final : 用於修式方法與field，稱為全局常數
* */
package Test5;

public class FinalTest {
    final int NUM = 5;
    final int LEFT;
    final int RIGHT;
    public void setNum(){
       // NUM++; Cannot assign a value to final variable 'num'
    }


    {
        LEFT = 2;
    }

    public FinalTest(){
        RIGHT = 20;
    }

    public void show(final int o){
        final int dd = 100;
        //dd++; 不可變動
        //o = o + 1; 不可變動
        System.out.println(o);
    }


}

final class FinalA{

}

class AA{
    public final void show(){}


}

class BB extends AA{
   // public void show(){},'show()' cannot override 'show()' in 'Test5.AA'; overridden method is final

}