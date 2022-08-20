
package Test5;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Yu-Jing
 * @create 2022-07-05-PM 01:57
 */
public class OtherClassTest {
    @Test
   public void test(){
        BigInteger bi = new BigInteger("12554416545125615454615656564");
        BigDecimal bd = new BigDecimal(2345655.48572515448545);
        BigDecimal bd2 = new BigDecimal(23.55);
        System.out.println(bi);

        System.out.println(bd.divide(bd2,5,BigDecimal.ROUND_HALF_UP));
    }
}
