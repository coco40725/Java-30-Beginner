/*
* Scanner.next() 會依據 空白字元、空白鍵、Tab， 將字串分割分別存取；而Enter是結束 Scanner，
* 換言之，你輸入 AA DD CC，Scanner會認定你輸入 3 組數據 ，必須用三組 String str = scanner.next() 來存取，如下
* String str1 = scanner.next(); str1 = AA
* String str2 = scanner.next(); str2 = DD
* String str3 = scanner.next(); str3 = CC
*
* */

/*
* Scanner.next(Pattern.compile(String Regex));
* 根據 Regex 將字串分割分別存取， 若沒有match的會報錯InputMismatchException
* */

/*
* Scanner.nextLine(): 不將字串進行分割
* */

/*
* Scanner.hasNext()
* */
package Test1;

import java.util.Scanner;

/**
 * @author Yu-Jing
 * @create 2022-07-27-AM 11:43
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入字串: ");
        boolean str = scanner.hasNext();
        System.out.println(str);

    }
}
//Hello World! 3 + 3.0 = 6