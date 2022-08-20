/*
* 使用 properties 將配置文件的訊息讀進來，此文件的 key value 只能是 String
*
* */
package Test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Yu-Jing
 * @create 2022-07-25-PM 02:35
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();
            fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day24\\src\\Test1\\jdbc.properties");
            properties.load(fis); // 讀資料進來
            System.out.println(properties.getProperty("name"));
            System.out.println(properties.getProperty("password"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null ){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }


    }


}

