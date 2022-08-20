/*
 * package fruit = { Apple.class, Banana.class, ...}
 * 之後，若想在調用這個class, 則你必須先import fruit; 才能調用fruit旗下的class
 * https://www.796t.com/content/1548151597.html
 *  */

/*
*Java 中的資料型態 (https://blog.marklee.tw/java-interview-jvm-stack-heap/)
分為兩種：
Primitive Type 基本型態
1. 共有 8 種： int 、 short 、 long 、 byte 、 float 、 double 、 boolean 、 char 。
2. 這種類型是通過如 int a = 3; long b = 123L;的方式宣告。
3. 長度及生命週期都為可知 (程式碼區塊執行完就扔掉)。
4. 運算速度快，但長度與內容受限。
*
Class Type / Reference Type 類別型態 / 參考型態
1. 其他大都屬於此類別，如 Integer 、 String 、 Long、 Array 以及自行定義的類別 (ex. User ) 等。
2. 這種類型通常都需要用 new 去創建 (資料存在 Heap，Stack僅存記憶體位址)，如 User user = new User("Mark"); 。
3. 因為是在執行時才動態創建，所以長度及生命週期都不可預知。
4. 靈活但運算較耗時。
*
* 變數可能是 Primitive Type 或 Class / Reference Type 。
* 若是 Primitive Type，則在 Stack 內的變數值為實際值；
* 若是 Class / Reference Type，實例資料會儲存在 Heap 中，Stack 內的變數值為實例在 Heap 中的記憶體位址。
* Stack 內的變數值分為兩種類型，一種為 Value Type 實質類別 ，儲存的是 實際的值 (ex. 123 、 456L )；
* 另一種為 Reference Type 參考類別，儲存的是 資料在 Heap 中的記憶體位址 (ex. 0x1234 16進位)。
* */

/*
* Array特點:
 1. 創建Array時，會在記憶體建立一整塊的連續空間
 2. Array建立後，不能更改Array大小
 3. Array的元素類型: primitive type or reference type
 ex. two-dimension array:
 * 可以視為1個array，裡面的元素亦是一個one-dimension array:
   column1   column2
    學生a       98
    學生b       60
這樣的array相當於: 元素是 1個one-dimension array [學生a, 98] ，因此，以底層來看沒有所謂的多維array!

* one dimension Array:
* 1. 如何建立Array: (變數類型)[],ex. int[] (另外又可分靜態初始化、動態初始化)
* 2. 調用或對特定位置的元素指定值，已被指定的可覆蓋
* 3. 如何得到 Array的長度，使用屬性.length
* 4. 如何print出Array 的所有元素
* 5. Array默認初始化值 :
* byte, int, char, short, long 默認為"數值" 0;
*  float, double 默認0.0; boolean 默認 false;
* reference type 默認為Null
* 6. Array是如何分配記憶體空間
* 詳見 https://www.youtube.com/watch?v=nzYZD5-TaUg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=144
*
*/

package Lession;


public class Array {
    public static void main(String[] args) {
        // 靜態初始化: 建立Array框架並給定數值
        int[] n = new int[]{1001, 1002, 1003, 1004};
        int[] nn = {1, 2, 3, 4}; // 這樣的寫法，Java可以自行推斷 nn屬於 int的Array (Type inference 類型推斷)
        /*
        然而分開，java就無法進行類型判斷，以下code會error!
        * int [];
        * nn = {1, 2, 3 , 4}
        * */

        // 動態初始化: 僅建立Array框架
        String[] id = new String[3]; // 指定Array 長度為 3

        // error: int[] id = new int[4]{1,2,3,4}; // 指定Array 長度為 4

        // 對特定位置的元素指定值
        id[0] = "水杯";
        id[1] = "難過男";
        id[2] = "好笨";
        n[0] = 236;
        System.out.println(n[0]);

        // 調出Array 長度
        System.out.println(id.length);

        // 如何print出Array 的所有元素
        for (int i = 0; i < id.length  ; i++ ){
            System.out.println(id[i]);
        }

        // Array默認初始化值
        //int[] array1 = new int[3];
        boolean[] array1 = new boolean[2];
        //double[] array1 = new double[2];
        //char[] array1 = new char[2];
        for (int i = 0; i < array1.length  ; i++ ){
            System.out.println(array1[i]);
        }
        System.out.println(array1); // [Z@16b98e56 array1這個變數事array，故array1這個變數所存的值為 "記憶體地址"!!!!! (存在Stack)
        System.out.println(array1[0]); // array1[0] 是一個primitive type的變數，故 會直接把值存在stack


    }
}
