package Test2;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu-Jing
 * @create 2022-07-14-PM 04:21
 */
public class ListInterview {
    @Test
    public void testListRemove(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list); // remove index = 2 的元素，即3
    }

    private static void updateList(List list){
        list.remove(2);
    }
}
