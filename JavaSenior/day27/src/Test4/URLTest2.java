/*
* 從url 下載文件
*
* */
package Test4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 11:13
 */
public class URLTest2 {
    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            // 1. 建立url
            URL url = new URL("http://localhost:8080/examples/hamster.png");

            // 2. 建立連接
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            // 3. 建立輸入流
            inputStream = urlConnection.getInputStream();

            // 4. 建立輸出流
            fos = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\src\\Test4\\url.png");

            // 5. 將數據下載下來
            byte[] bbyte = new byte[1024];
            int len;
            while((len = inputStream.read(bbyte)) != -1){
                fos.write(bbyte,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 數據流關閉
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (urlConnection != null){
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }






    }
}
