/*
* Exception: 抓拋模型
* 1. 在運行時若出現異常，會產生一個異常類的對象，並output出來。 一旦出現異常，其後的code不執行
* 2.  異常的處理方式:
*   2.1 try-catch-finally: (多應用在 checked exception)
*        try{
*         可能會出現異常的code，若出現異常，會產生異常類的對象，
*         一旦try中的異常類對應的某個catch時，便會進入catch內進行異常處理。
*
*         } catch (異常類型1 變數名稱1){
*          處理異常1的方式，處理完畢後跳出 try-catch-finally
*         } catch (異常類型2 變數名稱2){
 *          處理異常2的方式，處理完畢後跳出 try-catch-finally
 *        } catch (異常類型3 變數名稱3){
 *          處理異常3的方式，處理完畢後跳出 try-catch-finally
 *        } finally{
 *          必然會執行的code，即使你catch存有異常或有return (或 try 有return)， finally一定會執行!
 *        }
 *
 * a. finally 不一定要寫
 * b. 使用try 將可能會出現異常的code包起來，若出現異常，會產生異常類的對象，
 * c. 一旦try中的異常類對應的某個catch時，便會進入catch內進行異常處理。
 * d. 異常處理完畢後跳出 try-catch-finally
 * e. 可繼續執行後續的code
*  f. catch 異常類型 若沒有子父類關係，聲明順序沒差；但若是有子父類關係，則子類必然聲明在父類上面，否則會報錯 (因為java要求沒一個catch類型都要掃到)
*  g. 常用的異常處理方式: System.out.println()； String getMessage() ； printStackTrace()
*  h. 在try中定義的變數，輸入輸出流、出了try後便無法使用，所以若後續要使用，必須先定義好
*  i. 像是數據連接、網路編成 socket等資源，JVM是無法進行自動回收的，我們需要手動進行，此時的資源釋放便放在finally
*  j. try-catch 可以鑲嵌
*
* -------------------------------------------------------------------------------------------------
*
* 2.2 throws: (多應用在 unchecked exception)
*  a. 聲明在方法名那裏，主要是聲明 可能會出現的異常，一旦執行時出現異常，則會出現對應的異常類型類，
*     若此類與throws的異常類型匹配，則會跳出此方法，並將異常丟給下一個調用此方法的 方法。
*----------------------------------------------------------------------------------------------------
* 3. 開發中，try-catch 與 throws的應用:
* a. 若父類的方法沒有使用throws，則子類之override的方法亦不可以使用throws，若此時 子類方法出現異常，則必須用try-catch-finally
* b. 若方法間有連鎖關係，則建議這幾個方法先使用throws進行處理，最後的方法再try-catch-finally，
*   (因為第一個報錯後面一定全錯，而try-catch-finally只是告訴你有錯誤，並以較人性化的方式呈現，但是本質上並沒有修正，
*    因此即使能往下做，也會是有問題)
*----------------------------------------------------------------------------------------------------------
* 異常產生方式:
* 1. 系統自動生成的異常對象
* 2. 手動產生一個異常對象，並拋出 (throws): throw new +異常類型
* */
package Test2;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionTest1 {
    @Test
    public void test1(){
        String s1 = "abc";
        char c1 = 'a';
        try{
            c1  = s1.charAt(3);
            // 若出現異常則以下不執行
            System.out.println("hello");
            System.out.println(c1);
        } catch (StringIndexOutOfBoundsException e){
            // 處理方式 1: System.out.println()
            System.out.println("StringIndexOutOfBoundsException: 超出範圍了");

            // 處理方式 2: String getMessage()
            System.out.println(e.getMessage());

            // 處理方式 3: printStackTrace()
            e.printStackTrace();

        } catch (Exception e){
            System.out.println("Exception: 超出範圍了");
        }
        System.out.println("hello2");
    }



    @Test
    public void test2(){
        try{
            int a = 1;
            int b = 0;
            System.out.println(a/b);
        }catch (ArithmeticException e){
            //e.printStackTrace();
            int[] arr1 = new int[2];
            System.out.println(arr1[15]);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("coool!");// 若 catch 有異常，這裡仍會執行
        }
        System.out.println("super cool!"); // 若 catch 有異常，這裡不會執行，程式直接中止
    }

    @Test
    public void test_testNum(){
        int num1 = testNum();
        System.out.println(num1);
    }

    public int testNum(){
        try {
            int[] arr1 = new int[10];
            System.out.println(arr1[12]);
            return 1;
        } catch (ArrayIndexOutOfBoundsException e){
            return 2;
        }finally {
            System.out.println("必然執行!");
            return 3; // 最後是output 3，return 1 or 2 會被忽略掉
        }
    }

    @Test
    public void test9(){
        FileInputStream files = null;
        try {
            File file = new File("D:/Java_lession/1_basic/code/day16/src/Test2/hellow.txt");
            files = new FileInputStream(file);
            int dat = files.read();
            while(dat != -1){
                System.out.print((char)dat);
                dat = files.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
               if (files != null) files.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
