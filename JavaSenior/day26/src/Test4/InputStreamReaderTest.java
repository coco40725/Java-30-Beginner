package Test4;

/*
* 處理流之二:
* 1. 轉換流
*    - 屬於字符流 (character) : InputStreamReader : 將輸入的字節流(byte) 轉換成 字符流 (character)，類似解碼
*                             OutputStreamWriter : 將輸出的字符流 (character) 轉換成 字節流 (byte)，類似編碼
* 2. 轉換流的作用: 提供字符與字節流的轉換
* 3. 字符(character)集
*
*
* */

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yu-Jing
 * @create 2022-08-08-PM 01:53
 */
public class InputStreamReaderTest {
    @Test
    public void test(){
        InputStreamReader isr = null; // character set預設是根據idea，至於應該填多少，取決於你的文件存檔格式
        try {
            FileInputStream fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite.txt");
            isr = new InputStreamReader(fis,"UTF-8");

            char[] bchar = new char[20];
            int len;
            while((len = isr.read(bchar)) != -1 ){
                String str = new String(bchar,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (isr != null){
                    isr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
