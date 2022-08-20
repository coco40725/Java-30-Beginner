/*
* 搜尋array是否有特定的element，搜尋方式可分成線性 (地毯性搜索)與二分法
*
* */

package Test;

public class Array_Test7 {
    public static void main(String[] args) {
        String[] arr = new String[]{"JJ", "DD", "MM", "BB", "GG", "AA"};

        // 想找 "BB";
        // 1. 線性搜索 (地毯式尋找)
        int[] pos = new int[arr.length];
        String dest = "BB";
        boolean is_Flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (dest == arr[i]) { //dest.equals(arr[i])
                System.out.println("找到的元素了, 位置: " + i);
                is_Flag = false;
                break;
            }
        }
        if (is_Flag) System.out.println("沒找到!");

        // 2. 二分法找 (相較線性搜尋，速度較快)
        // Array 先排序，然後取中間值，問: 目標值大於中間還是小於?
        int[] arr1 = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        int dest1 = 123;


        boolean keep_Find = true;
        int i = 0;
        int head = 0;
        int end = arr1.length;

        while (head <= end){
            int mid_pos = (head + end) / 2;

            if (arr1[mid_pos] > dest1){
                end = mid_pos - 1 ;

            } else if ( arr1[mid_pos] < dest1){
                head = mid_pos + 1;

            }else if (arr1[mid_pos] == dest1){
                System.out.println("找到的元素了, 位置: " + mid_pos);
                keep_Find = false;
                break;
            }



        }
        if (keep_Find) System.out.println("找不到!");


    }

}
