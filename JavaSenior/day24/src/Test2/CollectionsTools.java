/*
* Collections 工具類: 用於操作 Collection and Map, 多為靜態方法
*
*  排序操作 ：：（均為 static 方法）
 reverse(List) 反轉 List 中元素的順序
 shuffle(List) 對 List 集合元素進行隨機排序
 sort(List) 根據元素的自然順序對指定 List 集合元素按升序排序
 sort(List Comparator) 根據指定的 Comparator 產生的順序對 List 集合元素進行排序
 swap(List int int 將指定 list 集合中的 i 處元素和 j 處元素進行交換
*
* */

/*
* 查找、替換
 Object max(Collection) 根據元素的自然順序，返回給定集合中的最大元素
 Object max(Collection Comparator) 根據 Comparator 指定的順序，返回給定集合中的最大元素
 Object min(Collection)
 Object min(Collection Comparator)
 int frequency(Collection Object) 返回指定集合中指定元素的出現次數
 void copy(List dest,List src )：將 src 中的內容 "覆蓋" 到 dest 中，故 dest.size > src.size 注意這裡的size指的是 "元素數量"
 boolean replaceAll (List list Object oldVal Object newVal 使用新值替換List 對象的所有舊值
*
*
* */

/*
Collections 類中提供了多個 synchronizedXxx () 方法，該方法可使將指定集
合包裝成線程同步的集合，從而可以解決多線程並發訪問集合時的線程安全問題
*
* */

package Test2;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Yu-Jing
 * @create 2022-07-25-PM 03:00
 */
public class CollectionsTools {
    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("544");
        arrayList.add("3556");



        // 錯誤的寫法:
        // 1. 因為 dest.size < src.size
        // 2. 為何 arrayList1.size() 也就是 dest.size = 0 ? 因為 List 裡面的size算法是 根據你add幾個元素來算的，而不是單純看 Array的大小!
//         ArrayList arrayList1 = new ArrayList(5);
//         System.out.println(arrayList1.size()); 0
//         Collections.copy(arrayList1, arrayList);

        // 如何讓arrayList1.size 不為0 而是反應出 List本身的大小 ?
        List arrayList1 = Arrays.asList(new Object[arrayList.size()]);// 而這裡 Array
        System.out.println(arrayList1.size()); // 透過asList， 我們可以讓 arrayList1.size = Array.length ，
                                                // 此時的 arrayList1 即使裡面沒元素size也不會是0
        Collections.copy(arrayList1, arrayList);
        System.out.println(arrayList1);

        // 如何使 ArrayList 變成 thread-safe
        List list1 = Collections.synchronizedList(arrayList1); // list1 為 thread-safe list



    }


    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("Spiky Jack");
        arrayList.add("HE'S BACK");
        arrayList.add("MeatBall");
        arrayList.add("Tumble Rumble");
        arrayList.add("MeatBall");
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        Collections.shuffle(arrayList);
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String tmp1 = (String) o1;
                    String tmp2 = (String) o2;
                    return - tmp1.compareTo(tmp2);
                }
                throw new RuntimeException("Wrong class type!");
            }

        });
        System.out.println(arrayList);

        Collections.swap(arrayList, 1,2);
        System.out.println(arrayList);

        System.out.println(Collections.frequency(arrayList,"MeatBall"));

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("Darksouls3");
        arrayList1.add("Darksouls");

        Collections.copy(arrayList, arrayList1);
        System.out.println(arrayList);
    }
}
