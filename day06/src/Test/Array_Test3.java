package Test;


/*
* 得到array 元素的所有和
* 3 5 8 -
* 12 9 - -
* 7 0 6 4
*
*
* */
public class Array_Test3 {
    public static void main(String[] args) {
        int [][] arr1 = new int[][]{
                {3, 5, 8},
                {12, 9},
                {7, 0, 6, 4}
        };

        int sum = 0;
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1[i].length; j ++){
                sum = sum + arr1[i][j];
            }
        }
        System.out.println("總和為: " + sum);

    }
}
