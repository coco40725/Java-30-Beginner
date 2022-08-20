package Test1;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-06-30-PM 01:44
 */
public class DeBugTest {
    @Test
    public void test(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);

//        StringBuffer sb1 = new StringBuffer(str);
//        System.out.println(sb1);
    }

}
