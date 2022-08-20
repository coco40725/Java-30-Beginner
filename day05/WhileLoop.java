/*
Loop 結構:
1. 初始執行程式碼, ex. 定義int i = 0 或者 System.out.println("...")
2. 循環條件: boolean , ex. price > 0
3. 循環過程: ex. price - i
4. 跌代執行程式碼: ex. ++i，若要複數個則以","區隔: ++i, ++j, System.out.println("....")


While 寫法:

初始執行程式碼
while (循環條件){
    循環過程
    跌代執行程式碼

}

For 與 while 兩個可以相互轉換，另外，


*/

/*
javac -encoding UTF-8 D:\Java_lession\1_basic\code\day05\WhileLoop.java
java -classpath D:\Java_lession\1_basic\code\day05 WhileTest

*/

class WhileTest {
    public static void main (String args[]){

        // 列出100以內的所有偶數
        int  i = 0;
        while (i <= 100){
            if (i % 2 == 0){
                System.out.println(i);
            }
            ++i;

        }

    }
}