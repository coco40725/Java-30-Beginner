/*
* * two dimension Array:
 * 1. 如何建立Array: (變數類型)[array本身的長度][元素array的長度],ex. int[][] (另外又可分靜態初始化、動態初始化)
 * 2. 調用或對特定位置的元素指定值，已被指定的可覆蓋
 * 3. 如何得到 Array的長度 (element 元素)，使用屬性.length
 * 4. 如何print出Array 的所有元素
 * 5. Array默認初始化值 :
 * 外層Array 元素: array[0], array[1]
   內層Array 元素: array[0][0], array[1][0]
  針對第一種初始化: int [][] array = int[4][2]
   * array[0] 初始化值 為 記憶體地址
   * array[0][0] 初始值 是看 變數類型
  針對第二種初始化: int [][] array = int[4][]
  * array[0] 初始化值 為 null (注意，array[0]的元素不是 int，而是 int[] reference type)
  * array[0][0] 初始值 是無法調用的!!!
 *
 * byte, int, char, short, long 默認為"數值" 0;
 *  float, double 默認0.0; boolean 默認 false;
 * reference type 默認為Null
 *
 * 6. 記憶體存取結構:https://www.youtube.com/watch?v=c2BhEDzWHSw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=151
 * */

package Lession;

public class Array1 {
    public static void main(String[] args) {

        // 靜態初始化: 建立Array框架並給定數值
        int[][] n = new int[][]{{1,2,3},
                                {4,5},
                                {1,1,1,1}};

        int[][] nn = {{1,2,3}, {4,5}, {1,1,1,1}};

        // 動態初始化: 僅建立Array框架
        String[][] id = new String[4][5]; // 指定Array 長度為 4，array元素的長度為 5
        String[][] ids = new String[2][]; // 指定Array 長度為 4，元素尚未初始化，也就是還沒在heap開空間給元素array
        // error : String[][] = new new String[][4]


        // 調用或對特定位置的元素指定值，已被指定的可覆蓋
        System.out.println(nn[0][2]); // {1,2,3} 的 3
        System.out.println(ids[0]); // 回報Null
        //System.out.println(ids[0][1]); // 會報錯! .NullPointerException ，因為是ids[0]是存Null 而非存一個 "{null, null, null}"，所以自然會有問題

        ids[0] = new String[3]; // ids[0] 存成 {null, null, null}
        ids[1] = new String[4];//  ids[1] 存成 {null, null, null, null}
        System.out.println(ids[0][1]); // null , no error

        // 如何得到 Array的長度，使用屬性.length
        System.out.println(n.length); // 3個元素
        System.out.println(n[1].length); // 2個元素
        System.out.println();


        // 如何print出Array 的所有元素
        for (int i = 0; i < n.length; i++){
            for (int j = 0; j < n[i].length; j++){
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
        System.out.println(n);
        System.out.println(n[1]);

        /*
        Array默認初始化值
        外層Array 元素: array[0], array[1]
        內層Array 元素: array[0][0], array[1][0]
        * */
        int[][] mm = new int[4][3];
        System.out.println(mm[0]); // mm[0] 這個變數是array，故mm[0]存的是 記憶體地址 [I@16b98e560 (存在stack)， [代表 array是1維的, I代表這個array 的最底層元素是int
        System.out.println(mm[0][0]); //mm[0][0] 這個變數是 int變數，故 mm[0][0]存的是 0
        System.out.println(mm); // mm這個變數是 array ,故 mm存的是 記憶體地址 [[I@7ef20235 (存在stack), [[ 代表array是2維的, I代表這個array 的最底層元素是int


        int [][] mm1 = new int[4][];
        System.out.println(mm1[0]); // null，mm1[0] 尚未初始化
        // System.out.println(mm1[0][1]); error








    }
}
