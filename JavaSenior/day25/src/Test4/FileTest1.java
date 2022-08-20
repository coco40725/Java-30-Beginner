package Test4;


/*
 public boolean isDirectory 判断 是否 是 文件 目录
 public boolean isFile 判断 是否是文件
 public boolean exists 判断 是否存在
 public boolean canRead 判断 是否可读
 public boolean canWrite 判断 是否可写
 public boolean isHidden 判断 是否隐藏
*
如果出現 File 與 Directory皆出現false代表可能目錄或檔案 根本不存在，
建議操作檔案前，先調用以上方法確定檔案存在
* */

import org.testng.annotations.Test;

import java.io.File;

/**
 * @author Yu-Jing
 * @create 2022-08-01-AM 10:32
 */
public class FileTest1 {
    @Test
    public void test1(){
        File file = new File("test.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        System.out.println("**************************");
        File file1 = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
}
