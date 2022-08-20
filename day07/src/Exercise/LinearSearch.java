package Exercise;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arra1 = new int[]{34, 5, 22, -98, 6, -76, 0, -3};
        int dist = 22;
        boolean  keep_Found = true;


        for (int i = 0; i < arra1.length; i++){
            if (arra1[i] == dist) {
                System.out.println("找到元素，位置: " + i);
                keep_Found = false;
                break;
            }

        }
        if (keep_Found){
            System.out.println("找不到元素!");
        }
    }
}
