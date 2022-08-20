package Test;

public class ArrayUtil_Test {
    public static void main(String[] args) {
        ArrayUtil arraU = new ArrayUtil();
        int[] arra1 = new int[]{2,6,12,1,-2};

        System.out.println("Max = " + arraU.getMax(arra1));
        System.out.println("Min = " + arraU.getMin(arra1));
        System.out.println("Sum = " + arraU.getSum(arra1));
        System.out.println("Average = " + arraU.getAverage(arra1));

        arraU.printArray(arraU.revArray(arra1));
        System.out.println();
        arraU.printArray(arraU.sortArray(arraU.repArray(arra1)));
        System.out.println();
        arraU.printArray(arraU.sortArray(arra1));
        System.out.println(arraU.searchValue(arraU.sortArray(arra1), 1));
        System.out.println(arraU.searchValue(arraU.sortArray(arra1),-22));

    }
}
