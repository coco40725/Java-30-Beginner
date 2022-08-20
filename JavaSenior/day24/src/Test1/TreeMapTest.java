/*
* 往 TreeMap 中添加 key-value，key必須來自同一個class 才能根據key 進行排序，包含 自然排序 與 定製排序
*
*
*
* */
package Test1;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Yu-Jing
 * @create 2022-07-25-PM 02:03
 */
public class TreeMapTest {
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        Users users = new Users("Tom",26);
        Users users1 = new Users("Mick", 96);
        Users users2 = new Users("Jesus", 10);

        treeMap.put(users, 96);
        treeMap.put(users1, 70);
        treeMap.put(users2, 26);

        System.out.println(treeMap);


        // 先比名字再比age
        TreeMap treeMap1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Users && o2 instanceof Users){
                    Users tmp1 = (Users) o1;
                    Users tmp2 = (Users) o2;

                    if (tmp1.name.compareTo(tmp2.name) ==0) return Integer.compare(tmp1.age, tmp2.age);
                    return tmp1.name.compareTo(tmp2.name);
                }
                throw new RuntimeException("Wrong class type!");
            }

        });

        treeMap1.put(users, 96);
        treeMap1.put(users1, 70);
        treeMap1.put(users2, 26);

        System.out.println(treeMap1);
    }
}
