/* throws 異常類型 rule:
* 1. 子類override的方法，其throws 異常類型 不可大於父類方法的，如此，我們之後 try-catch才有辦法同時處理子類異常。
*
* */
package Test3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.Flow;

public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest t = new OverrideTest();
        t.display(new SubClass());

    }
    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperClass{
    public  void method() throws IOException{

    }
}

class SubClass extends SuperClass{
    @Override
    public void method() throws FileNotFoundException {

    }
}