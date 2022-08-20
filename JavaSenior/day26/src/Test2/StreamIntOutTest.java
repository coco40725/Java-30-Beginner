package Test2;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-03-AM 10:17
 */
public class StreamIntOutTest {

    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 實例化 File
            File file = new File("img.png");
            File file1 = new File("img_copy.png");

            // 2. 建立數據流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            // 3. 輸入與輸出
            int len;
            byte[] bbuf = new byte[10];
            while( (len = fis.read(bbuf)) != -1){
                fos.write(bbuf, 0, len);
            }
            System.out.println("\n 複製成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 關閉數據流
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void copyFile(String scrPath, String destPath, int Buffer){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 實例化 File
            File file = new File(scrPath);
            File file1 = new File(destPath);

            // 2. 建立數據流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            // 3. 輸入與輸出
            int len;
            byte[] bbuf = new byte[Buffer];
            while( (len = fis.read(bbuf)) != -1){
                fos.write(bbuf, 0, len);
            }
            System.out.println("\n 複製成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 關閉數據流
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void copyTest(){
        long s = System.currentTimeMillis();
        copyFile("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\GWAS wih Sex Stratification (Female) .pdf",
                "D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\GWAS wih Sex Stratification (Female)_copy2.pdf",
                10);
        long e = System.currentTimeMillis();
        System.out.println("複製時間: " + (e-s)+ " ms"); //6896 ms
    }
}
