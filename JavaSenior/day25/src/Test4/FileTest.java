/*
* File class 的使用
* 1. File() : 對象是 檔案路徑(絕對路徑) 或 檔名 (相對路徑，為module為基準)
* 2. 創建方式:
* File file = new File(String pathname)
* File file = new File(String ParentPath, String ChildPath)
* File file = new File(File parentFile, String chilePath)
*
* */
/*
* 以下方法即使文件不存在亦不會報錯
 public String getAbsolutePath() 獲取絕對路徑
 public String getPath 獲取 路徑
 public String getName 獲取名稱
 public String getParent() 獲取上層文件目錄路徑 。 若無 返回 null。 注意這裡的parent path是根據你 "填寫的formal parameter去找的"，換言之，若你填的是相對路徑，
*                           則會找不到$
 public long length 獲取 文件 長度 即：字節數 。 不能獲取目錄的長度 。
 public long lastModified 獲取 最後一次的修改時間 毫秒值
*
* 以下的方法是用於文件目錄，且目錄要存在
 public String[] list 獲取 指定目錄下的所有文件或者 文件 目錄 的 名稱數組
 public File[] listFiles 獲取 指定目錄下的所有文件或者 文件 目錄 的 File 數組

File 類的重命名功能
 public boolean renameTo(File dest) 把文件重命名為指定的文件 路徑
* 要保證成功，須滿足以下條件:
* file1.renameTo(file2)
* 1. file1 必須存在
* 2. file2 必須不存在
*
* */
package Test4;

import org.testng.annotations.Test;

import java.io.File;
import java.util.Date;

/**
 * @author Yu-Jing
 * @create 2022-07-29-AM 11:37
 */
public class FileTest {

    @Test
    public void test(){
        File file = new File("Test.txt");
        File file1 = new File("D:\\Java_lession\\1_basic\\code\\test.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent()); // 根據pathname，它抓不到 Parent path!
        System.out.println(file.length());
        Date date = new Date(file.lastModified());
        System.out.println(date);

        System.out.println("************************************");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

    }

    @Test
    public void test2(){
        File file = new File("D:\\Java_lession\\1_basic\\code");
        String[] list = file.list();
        for (String s :  list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }

        File file1 = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\src\\Test4\\Test.txt");
       File file2 = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\testNew.txt");
        file1.renameTo(file2);

    }
}
