package Exer;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yu-Jing
 * @create 2022-08-01-AM 11:18
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\src\\Exer\\hello.txt");
        // 1. 創建一個文件 haha.txt　於同目錄下
        File file1 = new File(file.getParent(), "haha.txt");
        file1.createNewFile();




    }

    @Test
    public void test1(){
        // 2. 判斷指定目錄下是否有 .jpg的文件，若有則輸出
        File file2 = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\src\\Exer");
        for (File s : file2.listFiles()){
            if (".jpg".equals(getExtension(s))) System.out.println(s);
        }
    }

    public static String getExtension(File file){
        if (file.isFile()){
            String str = file.getName();
            int start = str.lastIndexOf(".");
            if (start > 0){
                return str.substring(start, str.length());
            }
        }
        return null;

    }

    @Test
    // 遍歷Exer下所有的資料，並計算佔用空間
    public void test2(){
        File file = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\src\\Exer");
        File[] fileList = file.listFiles();
        int file_size = showFile(fileList,0);
        System.out.println("該目錄下所有檔案大小 (Bytes): " + file_size);



    }
    public int showFile(File[] file, int fileSize){
        for (File f : file){
            if (f.isFile()){
                System.out.println(f);
                fileSize += f.length();
            }else {
                showFile(f.listFiles(), fileSize);
            }
        }
        return fileSize;
    }

    @Test
    // 刪除特定目錄下
    // 注意! 當欲刪除的目錄下有其他文件與目錄，則無法刪除!
    public void test3(){
        File file = new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day25\\src\\Exer\\.jpg\\ddffs");
        deleteFile(file);

    }

    public void deleteFile(File file){
        if(file.isFile()) {
            file.delete();
            System.out.println("成功刪除: " + file);
            return;
        }

        File[] fileList = file.listFiles();
      if (fileList.length != 0){
          for (File f : fileList){
              if (f.isFile()){
                  f.delete();
                  System.out.println("成功刪除: " + f);
              }else{
                  deleteFile(f);
              }
          }
          file.delete();
          System.out.println("成功刪除: " + file);
      }else {
          file.delete();
          System.out.println("成功刪除: " + file);
      }

    }

}
