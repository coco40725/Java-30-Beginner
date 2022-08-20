package Exer1;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-08-AM 09:40
 */
public class PicTest1 {

    // 圖片加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\img.png");
            fos = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\img_secret.png");

            byte[] bbtye = new byte[1024];
            int len;
            while((len = fis.read(bbtye)) != -1){
                // 對數據進行修改
                for (int i = 0; i < len ; i++){
                    bbtye[i] = (byte) (bbtye[i] ^ 5); // ^ : XOR，  https://medium.com/@hyWang/xor-%E4%BD%8D%E5%85%83%E9%81%8B%E7%AE%97%E5%AD%90-1c25b4ae15fb
                }

                fos.write(bbtye, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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


    //圖片解密
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\img_secret.png");
            fos = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\img_solve.png");

            byte[] bbtye = new byte[1024];
            int len;
            while((len = fis.read(bbtye)) != -1){
                // 對數據進行修改
                for (int i = 0; i < len ; i++){
                    bbtye[i] =  (byte) (bbtye[i] ^ 5);

                    // 已知:
                    // (1) a^a = 0
                    // (2) a^0 = a
                    // (3) a^b == b^a
                    // 問題: 欲將 a^5 進行運算得到 a
                    // (a^5)^5 = 5^5^a = 0^a = a
                }

                fos.write(bbtye, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
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
}
