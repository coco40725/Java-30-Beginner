package Test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu-Jing
 * @create 2022-07-28-AM 10:03
 */


public class Order<T> {
    String name;
    int id;
    private T orderT; // 不確定屬性是哪種類型，T 代表某一個類型，但不包含 異常類!!!

    public Order(){
        // 如何創建 T[]?
//        T[] t = new T[10]; 錯誤
        T[] t = (T[]) new Object[10];
    }
    public Order( String name, int id, T orderT){
        this.name = name;
        this.id = id;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return this.orderT;
    }


    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

   // 不能在靜態方法裡面調用 泛型，因為泛型類型是在 建立對象時才決定好，而靜態方法卻在建立對象前即可調用，因此出現錯誤!
//    public static void show(){
//        System.out.println(orderT);
//    }

    // 泛型方法，可以用靜態方法!
    public <E> List<E> copyFromArraytoList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr){
            list.add(e);
        }
        return list;

    }



}
