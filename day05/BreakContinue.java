/*
break 
a. 直接跳出整個迴圈
b. 可應用在: switch-case; loop 結構
c. 後面不可再加任何code, ex. 
for (){
    [code...];
    break;
    不能再加東西!
}
d. 可以透過替loop 結構添加標籤，來使break 作用在特定的loop上。不指定的話，是預設作用在最近的loop

continue
a. 直接進下一個循環，類似skip
b. 可應用在 loop 結構，跳過當前循環，直接進下一個循環，類似skip
c. 後面不可再加任何code, ex. 
for (){
    [code...];
    continue;
    不能再加東西!
}
d. 可以透過替loop 結構添加標籤，來使continue 作用在特定的loop上。不指定的話，是預設作用在最近的loop

*/

// javac -encoding UTF-8 D:\course_and_research\Java_lession\1_basic\code\day05\BreakContinue.java
// java -classpath D:\course_and_research\Java_lession\1_basic\code\day05 BreakContinue_Test

class BreakContinue_Test {
    public static void main(String args[]) {
        for (int i = 1 ; i <= 10 ; i++){
            if (i % 4 == 0 ){
                // break; 只顯示1 2 3， 然後結束
                continue;  // 只跳過 4,8
            }
             System.out.println(i);
        }
         System.out.println();

        label : for (int k = 1 ; k <= 4 ; k++) {
            for (int j = 1 ;  j <= 10 ; j++) {
                if (j % 4 == 0){
                    break label; // break label loop
                }
                
            }
            System.out.println(k);
        }
       

    }

}