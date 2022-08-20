/*
* 了解類的加載器
*
* */
package Test1;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 09:30
 */
public class ClassLoaderTest {
    @Test
    public void test(){
        // 對於自定義類是使用  AppClassLoader 進行加載
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 調用 AppClassLoader getParent 獲取 PlatformClassLoader
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        // 另外，引導類加載器是無法調用出來的，引導類加載器主要是用c++來加載 核心類 (像是 String等)
        ClassLoader str = String.class.getClassLoader();
        System.out.println(str); // 其實是有加載器的(引導類加載器)，但無法直接獲取故回傳null


    }
    /*
    * Properties: 用來讀取配置文件
    * */

    @Test
    public  void test2() throws Exception {
        Properties pros =  new Properties();

        // 讀取properties的方式1:
//        FileInputStream fis = new FileInputStream("src\\Test1\\test.properties");
//        pros.load(fis);

        // 讀取properties的方式2:
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("test1.properties"); // 默認位置: 當前module/src，注意不能使用絕對路徑
        pros.load(resourceAsStream);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user);
        System.out.println(password);



    }
}
