package Test;

public class ArrayUtil {

    // 求 Array Max value
    public int getMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max) max = array[i];
        }
        return max;
    }


    // 求 Array Min value
    public int getMin(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) min = array[i];
        }
        return min;
    }


    // 求 Array Sum
    public int getSum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 求 Array Average
    public double getAverage(int[] array){
        double sum = 0.0;
        double average = 0.0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        return average;
    }

    // Reverse Array
    public int[] revArray(int[] array){
        int[] revA = new int[array.length];
        for (int i = 0; i < array.length; i++){
            revA[i] = array[array.length - (i + 1)];
        }
        return revA;
    }

    // Replicate Array
    public int[] repArray(int[] array){
        int[] repA = new int[array.length];
        for (int i = 0 ; i < array.length; i++){
            repA[i] = array[i];
        }
        return  repA;
    }



    // Print Array
    public void printArray(int[] array){
        for (int i = 0 ; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    // Sort Array: Bubble sort
    public int[] sortArray(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - (i + 1); j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    // Search specific value and print location:  Binary Search, Please sort first
    public int searchValue(int[] array, int value){
        int start = 0;
        int end = array.length - 1;
        int middle = (start + end) / 2;
        int loc = -9;
        while(start <= end){
            if (value > array[middle]){
                start = middle + 1;
                middle = (start + end) / 2;
            }else if (value < array[middle]){
                end = middle - 1;
                middle = (start + end) / 2;
            }else {
                loc = middle;
                break;
            }

        }
        return loc;
    }
}
