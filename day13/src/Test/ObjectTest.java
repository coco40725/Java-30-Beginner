/*
* java.lang.Object
* 1. Object是所有類的 父類
* 2. 若在宣告累的時候沒有聲明要extends哪個類，則預設是extend Object
* 3. Object class
* 屬性: 無
* 方法: toString(), equals(), getClass(), hashCode(),...
* ----------------------------------------------------------------
*
* */

package Test;

public class ObjectTest {
    public static void main(String[] args) {
        Order o = new Order();
        System.out.println( o.getClass().getSuperclass());

    }
}


class Order{

}