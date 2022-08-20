package Lession;

import java.util.Arrays;
public class Array_package {
    public static void main(String[] args) {
        // 1. 判斷兩個輸出array是否相等: boolean equals(array1, array2) 兩個array 類型要相同
        int[] arra1 = new int[]{1,2,3,4};
        int[] arra2 = new int[]{1,2,3,4};
        int[] arra3 = new int[]{1,10,3,-2};
        boolean a12 = Arrays.equals(arra1, arra2);
        boolean a13 = Arrays.equals(arra1, arra3);
        System.out.println(a12);
        System.out.println(a13);

        // 2. 輸出array 內容: String toString(array1)
        System.out.println(Arrays.toString(arra1));

        // 3. 將array值全部替換成value 中: void fill(array, value)
        Arrays.fill(arra1, 12);
        System.out.println(Arrays.toString(arra1));

        // 4. 對array進行排序: void sort(int[] a)
        Arrays.sort(arra3);
        System.out.println(Arrays.toString(arra3));


        // 5. 使用二分法找數值: int binarySearch(int[] a, int key)
        int loc = Arrays.binarySearch(arra3, 32);
        System.out.println(loc); //若返回的是負數，則代表沒找到



    }
}
