/*
* Exception :
*
* java.lang.Throwable
*         1. java.lang.Throwable.Error: 不處理問題，僅報錯
*         2. java.lang.Throwable.Exception: 可以進行處理，需要寫code
*                  2.1 ckecked : 編譯時出現的exception (編譯時就會錯，不讓你執行! 必須寫code 應付掉), 例如:
*                                IOException,
*                                 --  FileNotFoundException,
*                                ClassNotFoundException
*                  2.2 unchecked: 運行時出現的exception (編譯會過，運行時才會報錯), 例如:
*                                 RunTimeException
*                                  --NullPointException,
*                                  --ArrayIndexOutOfBoundsException,
*                                  --ClassCastException,
*                                  --InputMismatchException,
*                                  --ArithmeticException,
*                                  --NumberFormatException,
*
*
*
*
* */
package Test1;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class ExceptionTest {

    //********************************************* 以下是 unchecked Exception *****************************************************//
    @Test
    //NullPointException
    public void test1(){
        int[] arr1 = null;
        System.out.println(arr1[1]);

        String s1 = null;
        System.out.println(s1.toLowerCase());
    }

    @Test
    //ArrayIndexOutOfBoundsException
    public void test2(){
        int[] arr1 = new int[3];
        System.out.println(arr1[3]);

    }

    @Test
    //StringIndexOutOfBoundsException
    public void test3(){
        String s1 = "abc";
        System.out.println(s1.charAt(3));
    }

    @Test
    // ClassCastException
    public void test4(){
        Object s1 = new Date();
        String dd = (String) s1;
    }

    @Test
    // NumberFormatException
    public void test5(){
        String s1  = "f5f";
        Integer.parseInt(s1);
    }

    @Test
    // InputMismatchException
    public void test6(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(n);
    }

    @Test
    //ArithmeticException
    public void test7(){
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }

    //********************************************* 以下是 checked Exception *****************************************************//
//     @Test
//    public void test8(){
//        File file = new File("hellow.txt");
//        FileInputStream files = new FileInputStream(file);
//        int dat = files.read();
//        while(dat != -1){
//            System.out.println((char)dat);
//            dat = files.read();
//        }
//         files.close();
//     }
//
//
}
