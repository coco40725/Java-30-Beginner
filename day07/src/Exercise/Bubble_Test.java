package Exercise;

import java.util.Arrays;

public class Bubble_Test {
    public static void main(String[] args) {
        int[] arra1 = new int[]{34, 5, 22, -98, 6, -76, 0, -3};

        // 第 i 輪
        for (int i = 0; i < arra1.length; i++){
            // 相鄰比較
            for (int j = 0; j < arra1.length - (i + 1); j++){
                if (arra1[j] > arra1 [j + 1]){
                    int tmp = arra1[j];
                    arra1[j] = arra1 [j + 1];
                    arra1 [j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arra1));


     }
}
