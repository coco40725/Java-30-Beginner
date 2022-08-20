/*
* RandomAccessFile 的使用:
* 1. RandomAccessFile 直接繼承 java.lang.Object，實現了 DataInput 與 DataOutput 接口
* 2. RandomAccessFile 可作為輸出流與輸入流
* 3. Constructor:
*    public RandomAccessFile(File file, String mode)
*    mode為決定訪問模式
*    r: 僅以讀的方式打開
*    rw: 打開以方便讀與寫
*    rwd: 打開以方便讀與寫，並同步文件的內容更新
*    rws: 打開以方便讀與寫，並同步文件內容和元數據更新
* 4. 如果 RandomAccessFile 作為輸出流時，寫出的文件若不存在，則會自動創建； 若已存在，則會對原文件內容進行覆蓋 (默認是從頭)
* 5. 可以用 seek(long pos): 將point調到pos的位置
* 6. 可以通過seek(long pos) 相關操作，達到 "插入" 數據的效果，但是過程較為繁瑣且耗記憶體:
*   a. 先將pointer 移至指 定欲插入的位置
*   b. 將 "指定位置之後的數據" 暫存到 StringBuilder，這個會使用while((len = raf.read(bbyter) )!=-1) ，因此pointer會移動到最後一位
*   c. 將pointer 重新移至指 定欲插入的位置
*   d. 將欲插入的內容寫入，覆蓋原本內容
*   e. 將 存在StringBuilder 的數據寫入
*
*
* */
package Test1;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author Yu-Jing
 * @create 2022-08-09-PM 01:59
 */
public class RandomAccessFileTest {

    @Test
    public void test(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            File fis = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\img.png");
            File fis1 = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\imgRAF.png");
            raf = new RandomAccessFile(fis, "r");
            raf1 = new RandomAccessFile(fis1, "rw");

            byte[] bbyte = new byte[1024];
            int len;
            while((len = raf.read(bbyte)) != -1 ){
                raf1.write(bbyte,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (raf != null){
                    raf.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (raf1 != null){
                    raf.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test1() throws IOException {
        File fis = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\Word.txt");
        RandomAccessFile raf = new RandomAccessFile(fis, "rw");

        raf.seek(fis.length()); // Point 調到 index = 15的位置
        raf.write("喔喔喔喔喔喔喔!!".getBytes(StandardCharsets.UTF_8));

        raf.close();
    }

    // 插入數據
    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            File fis = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\Word.txt");
            raf = new RandomAccessFile(fis, "rw");
            raf.seek(3);

            StringBuilder builder = new StringBuilder((int)fis.length());
            byte[] bbyte = new byte[20];
            int len;

            // 保存 index 3 之後的數據至builder
            while((len = raf.read(bbyte)) != -1){
                builder.append(new String(bbyte, 0, len));

            }

            // 調回 index， 插入內容
            raf.seek(3);
            raf.write("新增此內容".getBytes(StandardCharsets.UTF_8));

            // 將builder 的內容貼上
            raf.write(builder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (raf != null){
                    raf.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }





    }

}
