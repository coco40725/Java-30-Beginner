/*
* 如何讓List重複值消失?
* 方法: 將 List --> Set --> List
*
* */
package NoDuplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yu-Jing
 * @create 2022-07-15-PM 04:10
 */
public class NoDuplicateTest {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list1 = remove_deplicateList(list);
        for (Object o : list1){
            System.out.println(o);
        }


    }

    public static List remove_deplicateList(List list){
        Set tmp_set = new HashSet();
        tmp_set.addAll(list);
        return new ArrayList(tmp_set);
    }
}
