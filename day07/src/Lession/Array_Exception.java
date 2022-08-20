package Lession;

/*
* Array 常見異常
* 1. index 超過 bound: ArrayIndexOutOfBoundsException
* 2. Null 異常: NullPointerException
*
* */

import java.util.Arrays;

public class Array_Exception {
    public static void main(String[] args) {

        // 1. index 超過 bound: ArrayIndexOutOfBoundsException
        int[] arra1 = new int[]{1,2,3,4,5};
        // System.out.println(arra1[6]);  java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
        // for (int i = 1 ; i < 7 ; i++) System.out.println(arra1[i]);  java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5

        // 2. Null 異常: NullPointerException
        // 情況1
        int[] arra2 = new int[]{1,2,3};
        arra2 = null;
        // System.out.println(arra2[0]);  java.lang.NullPointerException: Cannot load from int array because "arra2" is null

        // 情況 2
        int[][] arra3 = new int[4][];
        System.out.println(arra3[0]); // 回傳 null
        // System.out.println(arra3[0][0]); java.lang.NullPointerException: Cannot load from int array because "arra3[0]" is null

        // 情況 3
        String[] arra4 = new String[]{"AA","BB","CC"};
        arra4[0] = null;
        // System.out.println(arra4[0].toString()); java.lang.NullPointerException: Cannot invoke "String.toString()" because "arra4[0]" is null

    }
}
