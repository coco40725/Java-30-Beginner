package Test4;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-01-AM 10:39
 */
/*
 public boolean createNewFile 創建文件 。 若 文件 存在 則不創建 返回 false
 public boolean mkdir 創建文件目錄 。 如果 此文件目錄存在 就不創建 了 。如果此文件目錄的上層目錄不存在 也不創建 。
 public boolean mkdirs 創建文件目錄 。 如果 上層 文件 目錄 不 存在 一並 創建
注意事項：如果你創建文件或者文件 目錄沒有 寫 盤符路徑 那麽 默認在項目路徑下

 public boolean delete 刪除 文件或者文件夾刪除
注意事項：
Java中的刪除不走 回收站 。
要刪除一個 文件 目錄 請注意該 文件 目錄 內 不能包含文件或者 文件
*
*
 1. File 僅針對 文件的創建、刪除、移位(無法覆蓋) 與 判斷存在與否 ， 不包含文件的 寫入文件內容或讀取文件內容，要達到後者的功能，需要使用 IO流
 2. 開發中， File 較常做為 formal parameter 傳遞至 constructor中，用於指定寫入與讀取的位置
* */



public class FileTest2 {

    // 文件創建
    @Test
    public void test() throws IOException {
        File file = new File("cool.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("創建成功");
        }else {
            file.delete();
            System.out.println("刪除!");
        }

    }

    // 目錄創建
    @Test
    public void test1(){
        File file1 = new File("D:/Java測試用/test");
        boolean mkdir = file1.mkdirs();
        if (mkdir){
            System.out.println("創建成功!");
        }else {
            System.out.println("創建失敗");
        }


    }
}
