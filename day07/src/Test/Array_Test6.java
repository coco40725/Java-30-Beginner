package Test;
/*
* array 的 reverse
*
* */

public class Array_Test6 {
    public static void main(String[] args) {
        String[] arr = new String[]{"JJ", "DD", "MM", "BB", "GG", "AA"};
        String[] arr1 = new String[arr.length];

        for (int i = 0; i < arr.length; i++){
            arr1[(arr.length - 1) - i] = arr[i];
        }
        for (int i = 0; i < arr1.length; i++) System.out.print(arr1[i] + " ");
    }
}
