/*
 * B. 集合框架
 * *   | ----- Collection interface : 單列接口，用來存一個一個的object
 * *       |----- List interface : 存有序可重複的數據，又可稱為 動態Array (因為可以修改)
 * *           |----- ArrayList: 作為list interface的主要實現類 (1.2出現，thread不安全，執行效率高)，底層使用Object[] elementData存取，可以快速存取 ( 可以直接跳到你指定的index ) 並使用較少量的記憶體
 *             |----- LinkedList: 對於頻繁的插入、刪除操作，使用此類比ArrayList高。底層使用雙向鏈表存取 (1.2出現)，存取速度較慢 (每次找指定的index其數值，需要從第一個開始找) 且需要較大空間的記憶體
 *             |----- Vector: 作為list interface的古老實現類 (1.0出現，thread安全，執行效率低)，底層使用Object[] elementData存取
 *
 *
 * ArrayList in JDK1.8 :
 * ArrayList list = new ArrayList(); 底層創建了 Object[] elementData = {}，是空的array ； JDK1.7 則是直接建立長度為10的array,但這種作法會浪費記憶體
 * list.add(123); 第一次使用add，此時底層才會將創建長度為10的array，並將數自填到array中
 * ....
 * list.add(454); 當填寫的數字超過10後，底層會進行長度擴增，它會增加為原來的1.5倍。
 * 故為了避免後續擴增而浪費時間，建議如果你一開始就知道需要多大的長度，就直接指定好: ArrayList list = new ArrayList(int capacity)
 *
 *
 * LinkedList :
 * 資料是以 Node的型式構成，
 * public static class Node<E> {
 *      E item;
 *      Node<E> next;
 *      Node<E> prev;
 *
 *      Node(Node<E> prev, E element, Node<E> next){
 *          this.item = element;
 *          this.next = next;
 *          this.prev = prev;
 *      }
 * }
 *
 * Vector:
 * Vector vec = new Vector(); 底層建立長度為10的array，之後不夠的話會直接增加為原來的兩倍
 */

package Test2;

import org.testng.annotations.Test;

/**
 * @author Yu-Jing
 * @create 2022-07-13-PM 03:43
 */
public class ListTest {

    @Test
    public void test2(){
        System.out.println(12 >> 1);
        System.out.println(-13 >> 1);

    }

    @Test
    public void test1(){
        String s1 = "aa";
        System.out.println("s1_hashcode" + ": " +  s1.hashCode());
        s1+="!";
        System.out.println("s1_hashcode"+ ": " + s1.hashCode());

        StringBuffer s2 = new StringBuffer("Bb");
        System.out.println("s2_hashcode" + ": " + s2.hashCode());
        s2.append("##");
        System.out.println("s2_hashcode" + ": " +  s2.hashCode()); // 直接改這個物件

    }
}

