/*
* 如何自訂異異常類:
* 1. 將自訂義異常類 繼承現有的異常類型
* 2. 提供 serialVersionUID : 全局常數
* 3. 提供 overload constructor
* */
package Test2;

public class MyException1 extends RuntimeException{
    static final long serialVersionUID = -7034897190745766939L;
    public MyException1(){}

    public MyException1(String message){
        super(message);
    }
}
