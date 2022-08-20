/*
* 冒泡排序:
* 首先從第一個元素開始，兩兩比對，較大的值往後放
* {12, 1, 33, 20, 10} 首先 第1個元素:12 vs 1
* {1, 12, 33, 20, 10} 再來 第2個元素:12 vs 33
* {1, 12, 33, 20, 10} 再來 第3個元素:33 vs 20
* {1, 12, 20, 33, 10} 再來 第4個元素:33 vs 10
* {1, 12, 20, 10, 33} 33為第一大值
* 繼續重複，但下一輪只要比 第1~3個元素
*
*
*
*
* */

package Test;

public class Array_Test8_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{43, 23, 76, -98, 0, 64, 33, -21, 32, 99};

        // 冒泡排序

        // 第i輪
        for (int i = 0; i < arr.length; i++ ) {

            // 互相比對: 第一個 vs 第二個 --> 第二個 vs 第三個
            for (int j = 0; j < arr.length - (i + 1); j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }
        for (int i = 0; i < arr.length ;  i++) System.out.print(arr[i] + " ");

    }
}
