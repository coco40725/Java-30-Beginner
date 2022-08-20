/*
* 1. PrintStream / PrintWriter : 打印流 (處理流的一種)，將輸出在java上的文字(System.out.print())改輸出到指定檔案中。
* 2. DataInputStream / DataOutputStream : 數據流 (處理流的一種)，寫出與讀入記憶體的variable (例如你想保存特定變數的數值，以供未來使用)，注意! 用數據流所撰寫的文件，必須用數據流打開，且讀的時候必須按照 寫入 的順序讀!!
*
* */

package Test5;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author Yu-Jing
 * @create 2022-08-09-AM 09:06
 */
public class OtherStreamTest {

    // PrintStream
    @Test
    public void test1(){

        PrintStream pr = null;
        try {
            FileOutputStream fis = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\PrintStreamTest.txt");
            pr = new PrintStream(fis, true);
            if (pr != null){
                System.setOut(pr); // activate the PrintStream
            }

            for (int i = 0; i < 255;  i++){
                System.out.print( (char) i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            pr.close();
        }

    }


    // 寫出數據: DataOutputStream
    @Test
    public void test2(){
        DataOutputStream dos = null;
        try {
            FileOutputStream fos  = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\DataStreamTest.txt");
            dos = new DataOutputStream(fos);

            dos.writeUTF("長庚醫院");
            dos.flush();
            dos.writeInt(45);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    // 讀入數據: DataInputStream
    @Test
    public void test3(){
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\DataStreamTest.txt");
            dis = new DataInputStream(fis);

            // 注意! 必須按照 "寫入" 的順序讀
            String name =  dis.readUTF();
            int age = dis.readInt();
            boolean exist = dis.readBoolean();

            System.out.println("name :" + name + " age : " + age + " exist : " + exist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
