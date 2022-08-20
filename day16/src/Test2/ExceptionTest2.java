/*
*  2.2 throws + 異常類型: (多應用在 unchecked exception)
*  a. 聲明在方法名那裏，主要是聲明 可能會出現的異常，一旦執行時出現異常，則會出現對應的異常類型類，
*     若此類與throws的異常類型匹配，則會跳出此方法，並將異常丟給下一個調用此方法的 方法。
* */
package Test2;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {

    public static void main(String[] args) {
        try {
            test2();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void test2() throws IOException{
        test1();
    }

    public static void test1() throws FileNotFoundException, IOException {
        FileInputStream files = null;
        File file = new File("D:/Java_lession/1_basic/code/day16/src/Test2/hellow1.txt");
        files = new FileInputStream(file);
        int dat = files.read();
        while (dat != -1) {
            System.out.print((char) dat);
            dat = files.read();
        }
        files.close();
        System.out.println("cool");
    }
}
