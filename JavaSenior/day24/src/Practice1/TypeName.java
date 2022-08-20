/*
請從鍵盤隨機輸入 10 個整數保存到 List 中，並按倒序、從大
到小的順序顯示出來

注意: 只有 TreeMap、TreeSet才有 implement Comparator!!!
* */
package Practice1;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-26-AM 08:58
 */
public class TypeName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList(10);
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    int tmp1 = (int) o1;
                    int tmp2 = (int) o2;
                    return - Integer.compare(tmp1, tmp2);
                }
                throw new RuntimeException("Wrong variable type!");
            }
        };

        for (int i = 0; i < 10; i++){
            System.out.print("請輸入第" + (i+1) + "個整數: ");
            int num = scanner.nextInt();
            list.add(num);
        }
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}
