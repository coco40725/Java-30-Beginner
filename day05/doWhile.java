/*
Loop 結構:
1. 初始執行程式碼, ex. 定義int i = 0 或者 System.out.println("...")
2. 循環條件: boolean , ex. price > 0
3. 循環過程: ex. price - i
4. 跌代執行程式碼: ex. ++i，若要複數個則以","區隔: ++i, ++j, System.out.println("....")


do-While 寫法:

初始執行程式碼
do{
循環過程
跌代執行程式碼
} while (循環條件);

注意: 
a. do-while 與while的差別在於，
 do-while先做，才去確認條件是否符合再往下做
 while是先確認條件是否符合，才往下做

b. 大部分是使用 for, while 較少使用do-while
*/

/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\doWhile.java
java -classpath D:\Java_lession\1_basic\code\day05 doWhileTest

*/

class doWhileTest {
    public static void main (String args[]){
        // 列出100以內的所有偶數
         
        int i = 0;
        do{
            if (i % 2 == 0){
                System.out.println(i);
            }
            ++i;
        } while (i <= 100);


        

    }
}