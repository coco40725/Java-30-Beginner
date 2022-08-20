package Test1;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-10-AM 10:10
 */
public class LibTest {
    @Test
    public void test(){
        try {
            File srcFile = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\Word.txt");
            File destFile = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\Word_FileUtilecopy.txt");
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
