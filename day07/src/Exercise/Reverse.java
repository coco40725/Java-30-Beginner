package Exercise;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arra1 = new int[]{34, 5, 22, -98, 6, -76, 0, -3};
        int[] arra2 = new int[arra1.length];
        for (int i = 0; i < arra1.length ; i++){
            arra2[i] = arra1[arra1.length - 1 - i];
        }
        System.out.println(Arrays.toString(arra2));
    }


}
