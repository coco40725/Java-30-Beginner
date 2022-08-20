package Test1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu-Jing
 * @create 2022-07-28-AM 10:09
 */
public class GenericMethod {
  @Test
    public void test1(){
      Order order = new Order();

      // 如果定義了泛型類，但在實例化時沒有指定類型，則預設是 Object
     // 建議: 若使用的是 泛型類，則建議使用泛型，以避開強轉、類型判斷等。
      order.setOrderT("sa");
      order.setOrderT(123);

      Order<String> order1 = new Order<>();
    order1.setOrderT("5dj2");
  }

  @Test
  public void test2(){
    SubOrder subOrder = new SubOrder();
    // 由於子類在繼承帶泛型父類，且已指明了泛型類型，則實例化子類時，不需要再指明泛型
    subOrder.setOrderT(123); // setOrderT(Integer orderT)

    SubOrder1<String> subOrder1 = new SubOrder1<>();
    subOrder1.setOrderT("5s25d");
  }

  @Test
  public void test3() {
    // 泛型類型不同的引用變數，不能互相賦值
    ArrayList<Integer> arr1 = null;
    ArrayList<String> arr2 = null;
    // arr1 = arr2; 這是錯誤的!
  }

  @Test
  public void test4(){
    Order<String> order = new Order<>();
    List<Integer> list = order.copyFromArraytoList(new Integer[]{1,25,13,-5,22});
    System.out.println(list);
  }


}
