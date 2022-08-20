/*
* 此Test class 有要求:
 1. 必須是 public class
 2. 必須提供 無參數的 constructor
 3. Test class中的方法必須是 public，沒有 formal parameter，沒有返回值
 4. 必須註明 @Test 與 import org.junit.Test;
 5. 方法內，寫測試用的code
 6. Run， 他就會直接執行這個方法 (不用寫main function，且方法可以直接用，不需要依靠class)
 如果執行結果沒有異常: 左方會有綠色點
 如果執行過程出現異常: 左方會有紅色點
* */
package Test;

import org.junit.Test;

import java.util.Date;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class JUnit_practiceTest {
    int num = 10;
    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));

        Object obj = new String("GG");
        //Date dd = (Date) obj;
        System.out.println(num);
        show();

    }

    public void show(){
        num = 20;
        System.out.println(num);
    }


}