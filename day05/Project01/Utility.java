/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\Project01\Utility.java
java -classpath D:\Java_lession\1_basic\code\day05\Project01 Utility
*/

/*
將工具做成funciton 直接調用:
1. 讀取keyboard
2. 輸出 使用者所選擇的 功能項，包含輸入錯誤該如何處理等等。
3. 輸出 使用者所打的 支出收入金額，包含輸入錯誤該如何處理等等。
4. 輸出 使用者所打的 支出收入說明。
5. 輸出 使用者所打的 Yes/ No，包含輸入錯誤該如何處理等等。

*/

import java.util.Scanner;

public class Utility {
    public static Scanner scanner = new Scanner (System.in);

    // 1. 讀取keyboard readKeyBorad，回傳 string 類型的變數
    private static String readKeyBorad (int limit){ 
        String line;
        while (true){
            line = scanner.next();
            if (line.length() > limit || line.length() < 1) {
                System.out.print("輸入長度不可大於 " + limit +" ，請重新輸入: ");
                continue;
            }
            break;
        }
        return line;
    }


    // 2. 輸出 使用者所選擇的 功能項，包含輸入錯誤該如何處理等等。 readMenue，回傳使用者選擇的功能項目類型， char類型的變數
    
    public static char readMenue (){
        char c;
        while (true){
             String str = readKeyBorad(1);
             c = str.charAt(0);
             if (c != '1' && c != '2' && c != '3' && c != '4'){
                 System.out.print("輸入錯誤，請重新輸入：");
             } else break;
             
        }

        return c;

    }  

    // 3. 輸出 使用者所打的 支出收入金額，包含輸入錯誤該如何處理等等。 readNumber，回傳金額，int
    public static int readNumber (){
        int n;
        while (true){
           String str = readKeyBorad(4);
           // 如果輸入的金額不是數字，則要求使用者重新輸入，而非直接結束應用程式: 使用 try catch
           try{
            n = Integer.parseInt(str);
            break;
           } catch (NumberFormatException e){
             System.out.print("數字輸入錯誤，請重新輸入: ");
           }

        }
        return n;

    }

    // 4. 輸出 使用者所打的 支出收入說明。 readComment
    public static String readComment (int limit){
        String str = readKeyBorad(limit);
        return str;
    }

    // 5. 輸出 使用者所打的 Yes/ No，包含輸入錯誤該如何處理等等。readConfirmSelection
    public static char readConfirmSelection() {
        String str = readKeyBorad(1);
        char c = str.charAt(0);

        while (true){
         if (c == 'Y' || c == 'N'){
            break;
        } else {
            System.out.print("選擇錯誤，請重新輸入: ");
            str = readKeyBorad(1);
            c = str.charAt(0);
        }

        }
       return c;

    } 

    
}
