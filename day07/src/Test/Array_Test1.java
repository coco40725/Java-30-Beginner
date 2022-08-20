package Test;

/*
* 使用二維dimension array做出 10行楊輝三角形
* 1. 先建立10個不指定數字的 array
* 2. 第一個 內層array~第10個內層array 開始賦值
* 3. 賦值方式:
* 先建立這一個內層的array大小。
* 這一個內層array 的 第 j個 element = 上一個內層array 的 第j 個 element + 上一個內層array 的 第j-1 個 element
*
* */

public class Array_Test1 {
    public static void main(String[] args) {
        int num = 10;

        // 先建立10個不指定數字的 array
        int[][] tri_array = new int[num][];

        for (int i = 0; i < num; i++){

            // 先建立這一個內層的array大小。
             tri_array[i] = new int[i + 1];

            // 這一個內層array 的 第 j個 element = 上一個內層array 的 第j 個 element + 上一個內層array 的 第j-1 個 element
            for (int j = 0; j < tri_array[i].length; j++){
                if (j > 0 && j < i){ // 非邊 j > 0, 且 j < i
                    tri_array[i][j] = tri_array[i - 1][j] + tri_array[i - 1][j - 1] ;
                } else {
                    tri_array[i][j] = 1;
                }
                System.out.print(tri_array[i][j] + " ");

            }
            System.out.println();



        }


    }
}
