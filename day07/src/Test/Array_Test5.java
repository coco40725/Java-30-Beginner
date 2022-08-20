package Test;

/*
* 正確的複製array2!
*
* */

public class Array_Test5 {
    public static void main(String[] args) {

        // 建立 array 1 and array 2
        int[] arra1 = new int[]{2,3,5,7,11,13,17,19}; //
        System.out.println(arra1); // [I@16b98e56
        int[] arra2 = new int[8];
        System.out.println(arra2); // [I@7ef20235

        // 將array 1 的值給array2
        for (int i = 0; i < arra1.length; i++){
            if (i % 2 == 0) {
                arra2[i] = i;
            } else {
                arra2[i] = arra1[i];
            }
            System.out.print(arra2[i] + " ");
        }

        // 再print array1
        System.out.println();
        for (int i = 0; i < arra1.length ; i++) System.out.print(arra1[i] + " ");

        // check 兩者的記憶體位址
        System.out.println();
        System.out.println(arra1);
        System.out.println(arra2);

    }
}
