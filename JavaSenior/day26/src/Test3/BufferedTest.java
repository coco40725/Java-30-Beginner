package Test3;
/*
* 處理流:
* 1. 緩衝流
* BufferInputStream
* BufferOutputStream
* BufferReader
* BufferWriter
*
* 2. 緩衝流的作用: 提供流的輸出輸入的速率
* 提高讀寫速度的原因 : 內部提供了一個緩衝區，此緩衝取 size 為 8192，當8192被存滿，會自動掉 flush() 將裡面的內容輸出，以此清出緩衝區。
*
*
* */

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author Yu-Jing
 * @create 2022-08-03-AM 11:26
 */
public class BufferedTest {

    @Test
    public void test(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 1. 實例化 File
            File srcFile = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite.txt");
            File destFile = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite_buffer_cpoy.txt");

            // 2. 建立數據流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            // 3. 使用緩衝流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);


            // 4. 數據輸入輸出
            int len;
            char[] bchar = new char[10];
            while( (len = br.read(bchar)) != -1 ){
                bw.write(bchar, 0 , len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 5. 數據流關閉: 先關 外層 在往內層關，而其實JAVA 在關閉外層流時，會自動一併把內層流關掉
            // 因此只要關外層流!

            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void copyFileWithBuffer(String srcPath, String destPath){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 1. 實例化 File
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2. 建立數據流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            // 3. 使用緩衝流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);


            // 4. 數據輸入輸出
            // 方法 1: 使用 char array
//            int len;
//            char[] bchar = new char[10];
//            while( (len = br.read(bchar)) != -1 ){
//                bw.write(bchar, 0 , len);
//            }

            // 方法 2: 使用 readLine ，一次讀一行並存成string，注意預設不含換行
            String str;
            while ( (str = br.readLine()) != null  ){
                // 換行方法1: 直接加 \n
                // bw.write(str + "\n");
                // 換行方法2: 加 newLine()
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 5. 數據流關閉: 先關 外層 在往內層關，而其實JAVA 在關閉外層流時，會自動一併把內層流關掉
            // 因此只要關外層流!

            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Test
    public void test2(){
        long s = System.currentTimeMillis();
        copyFileWithBuffer("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite.txt",
                "D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite_Buffercopy.txt");
        long e = System.currentTimeMillis();
        System.out.println("複製時間: " + (e-s)+ " ms"); // 123 ms
    }
}
