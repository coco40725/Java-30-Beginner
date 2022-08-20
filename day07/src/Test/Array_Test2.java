package Test;
/*
* 建立一個 含有6個 element的 array，並隨機放入 1-30，且數字不重複
* 1. 建立一個 int[] 6 個 element
* 2. 建立一個 for 迴圈，對每一個element 進行抽取
* 3. 抽隨機數採用while，當抽到的數字與先前相同 (用for 往回看數字)，則重抽
* 4. 若沒有重複的，則給予值
* */

import java.util.Random;

public class Array_Test2 {
    public static void main(String[] args) {
        int[] arr1 = new int[6];

        // 對每一個element進行抽取，共6個
        for (int i = 0; i < arr1.length; i++){
            boolean is_sample = true;

            // 抽隨機數
            resample : while (is_sample) {
                Random rnd = new Random();
                int num = rnd.nextInt(31);

                // 往回檢查隨機樹是否有重複
                for (int j = 0; j < (i+1) ; j++){
                    if (num == arr1[j] || num == 0){
                        continue resample; // 出現一樣的，或出現 0，回到 while 重抽
                    }
                }
                arr1[i] = num; // 都沒有重複的，給予值
                is_sample = false; // 不重抽!
            }

        }


        // Print 數字
        for (int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }

    }

}

