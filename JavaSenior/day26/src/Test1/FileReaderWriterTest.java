package Test1;

/*
* 一、流的分類
* 1. 操作數據單位: 字節流、字符流
* 2. 數據的流向: 輸出流、輸入流
* 3. 流的角色: 節點流、處理流
*
* 二、流的體系結構
* 抽象父類                      節點流 (文件流)                                         緩衝流 (屬於處理流)
* 1. InputStream            FileInputStream: read(bype[] buffer)                    BufferInputStream: read(bype[] buffer)
* 2. OutputStream           FileOutputStream: write(bype[] buffer, 0, len)          BufferOutputStream: write(bype[] buffer, 0, len)
* 3. Reader                 FileReader: read(char[] buffer)                         BufferReader: read(char[] buffer) / readLine(String str)
* 4. Writer                 FileWriter: write(char[] buffer, 0, len)                BufferWriter: write(char[] buffer, 0, len) / write(String str) ; newLine()
*
* 三、 讀入資料須注意的點
* 1. read(): 返回讀入的第一個字符 (將char 轉成 int，例如 a = 97)，若達文件末尾則返回-1
* 2. 讀資料時會有三個環節會報錯
*       2.1 找到此文件並提供數據流 :  fr = new FileReader(file); 若找不到文件，則此步驟會報錯 FileNotFoundException
*       2.2 讀資料: fr.read()
*       2.3 關資料: fr.close()
* 不論你讀取資料是否成功，我們都需要將資料關閉，因此會採用try/catch-finally， 但是! 若錯誤發生在 2.1 ，代表fr沒有建立，
* 數據流沒有開啟，則不需要close，因此在close前我們須先判斷 數據流是否有建立成功!
*
*
* 四、 read(char[] cbuf) 的讀入過程
* 文件為: helloworld123
* char[] cbuf = new char[5];
* 說明:
* step 1: cbuf = [h,e,l,l,o] ，此時 fr.read(cbuf) = 5
* step 2: cbuf = [w,o,r,l,d] ，此時 fr.read(cbuf) = 5
* step 3: cbuf = [1,2,3,l,d] ，此時 fr.read(cbuf) = 3
*
*
* 五、文件輸出
*  輸出文件時，若文件不存在，則會自動創建，
*            若存在，則 new FileWriter(file, append: true) : 文件不覆蓋，將新內容接著寫入原文件
*                  則  new FileWriter(file, append: false) : 預設，文件直接覆蓋
* write(String, offset, end) : 寫出 String，範圍從 [offset, end)
*
* 六、結論
* 1. 文件類型為 .txt, .java, .c, .cpp 純文字檔案: 使用 字符流 Reader/Writer
* 2. 文件類型為 非純文字檔 (.jpg, .png, .mp3, .mp4, .avi, .doc, .csv, .ppt): 使用字節流 (byte) InputStream/ OutputStream
*
* 用錯的話 print 會出現亂碼! 例如:
* 文件: helloworld台灣桃園醫院
* 如果這個文件用 InputStream來讀的話會出現亂碼，因為中文字的存法是 "一個中文字 用 三個byte 來存"，這樣會導致讀取被截斷，
* ld台 = [5,2,12,23,56]
* 一次讀兩個byte --> [5,2] [12,23] [56] 如此 "台"這個字會變亂碼
*
* 但是! 如果你只是要做複製貼上，那麼純文字檔與非純文字檔 皆可用 InputStream/ OutputStream 進行操作
*
*
*
* */

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-01-PM 02:35
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath()); // Parent Path 是在project --> D:\Java_lession\1_basic\code\JavaSenior\test.txt
        File file1 = new File("\\day26\\test.txt");
        System.out.println(file.getAbsolutePath());
    }

    // 將 test.txt 的內容讀入，並輸出
    @Test
    public void test()  {
        FileReader fr = null;
        try {
            // 1. 實例化欲操作的文件
            File file = new File("test.txt");
            System.out.println(file.getAbsolutePath()); //Parent Path 是在module --> D:\Java_lession\1_basic\code\JavaSenior\day26\test.txt

            // 2. 提供具體的流
            fr = new FileReader(file);

            // 3. 數據的讀入
            // read(): 返回讀入的第一個字符 (將char 轉成 int，例如 a = 97)，若達文件末尾則返回-1
            int data = fr.read();
            while(data != -1){
                System.out.print((char) data);
                data = fr.read(); // 再往下讀
            }
            System.out.println("\n 複製成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 流的關閉 (一定要做!!!)
            try {
                if (fr != null)  fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // read() 更加進階的寫法
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            // 1. File 的實例化
            File file = new  File("test.txt");

            // 2. 找到數據並提供數據流 FileReader
            fr = new FileReader(file);

            // 3. 數據的讀入
            char[] cbuf = new char[5];
            // read(char[] cbuf) : 加快讀取速度，一次讀 cbuf 個字符 (看你cbuf的設定的大小為何)，並將字符array存放於 cbuf裡，
            // 返回的是 從cbuf array中所讀入的 "字符個數", or -1 if the end of the stream has been reached

            int len;
            String str;
            while( (len = fr.read(cbuf)) != -1 ){
                // 方法一:
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                // 方法二:
                str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 4. 關閉數據流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    // 將文件輸出
    @Test
    public void test3(){
        FileWriter fw = null;
        try {
            // 1. File 的實例化，指名要輸出到哪裡
            File file = new File("testWrite.txt");

            // 2. 提供數據流，輸出資料
            fw = new FileWriter(file);

            // 3. 寫出
            fw.write("ala boj jlan daj slm! \n");
            fw.write("Can you speak English? \n");
            fw.write("FUCK YOU! \n");
            fw.write("Yes! He can. \n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 關閉數據流
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 結合 Reader and Writer，進行檔案複製
    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1. File 實例化 (讀入) + File 實例化 (寫出)
            File file1 = new File("testWrite.txt");
            File file2 = new File("testWrite_copy.txt");


            // 2. 提供數據流: 讀入 與 輸出
            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            // 3. 數據的讀入 與 寫出
            int len;
            String str;
            char[] cbuf = new char[5];

            while((len = fr.read(cbuf)) != -1){
//                str = new String(cbuf,0, len);
//                fw.write(str);
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 關閉數據流
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }





    }
}
