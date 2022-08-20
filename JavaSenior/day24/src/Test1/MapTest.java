package Test1;
/*
* |------ Map : 雙列數據，儲存key-value的數據，類似 y = f(x)
*         |---- HashMap : 作為Map的主要實現類，thread not-safe 效率高，可以存取 null 的key或value。一樣要override equals與 Hashcode
*               |----- LinkedHashMap : 保證在遍歷map的元素時，是依據添加順序來遍歷。因為它在原有的HashMap中添加了指針去指向前一與後一的元素。
*                                      在頻繁進行數據操作時，效率高於LinkedHashMap
*         |---- TreeMap : 按照 key進行排序 (可使用自然排序或定製排序)，實現排序。底層使用紅黑樹。
*         |---- Hashtable : 為古老的實現類，thread safe 效率低，不可以存取 null 的key或value
*               |----- Properties : 常用於配置文件，key-value 皆是string type.
*
*
*
* 1. Map中的key 為 無序且不可重複，並使用Set來存取key --> 存取的類要override equals與 Hashcode
* 2. Map中的value 為無序且可重複的，使用Collection來存取value --> 存取的類要override equals
* 3. key + value 可以構成 Entry，而 Entry 亦為無序不可重複 ，使用Set來存取
*
* 4. HashMap底層實現原理 (jdk7 以前):
*     HashMap map = new HashMap();
*     在實例化以後，底層創建了長度 16 一維Array數組 Entry[] table。
*     ..... 可能已經執行了map.put() .....
*     map.put(key1, value1):
*     首先，調用 key1.hashCode() 計算key1 的hashCode() 得到在數組的存放位置。
*     若 此處的數據 是空的，則 key1-value1 使用 NewNode() 進行添加
*     若 此處的數據 非空 (一個數據或多個數據且以鏈表方式呈現)，則比較 key1 與 以存在之數據 雙方的hashcode 與內容物，
*     if (p.hash == hash && (   (k = p.key) == key || (key != null && key.equals(k)))   ) then 添加失敗
*     若hashcode相同，且key的equals亦判定相同，則添加失敗
*
*  補充: 若索引位置上已有數據，則 此時key1-value1 與原來的數據 以鏈表方式存取。
*  擴增: 將大小增加為原來的2倍，並將原本的數據copy過來。
*       當 目前的array size超過 threshold 時，並判斷新加入的元素是否將會以鏈表方式存取，
*           若否，則暫不擴增。
*           若是，則擴增 (因為鏈表不利於查找，盡可能避開鏈表存取)
*       擴增後，會重新計算元素的擺放位置，重新擺放!!
*
* JDK8 相較於 JDK7 不同的點:
*       1. new HashMap(): 不創造長度 16 一維Array數組
*       2. 底層的數組是使用 Node[] 而非 Entry[]，Entry class 之field : key, value, next, hash
*       3. 首次調用put()方法時，才會創建長度16的數組 (類似ArrayList的做法)
*       4. JDK7 的底層結構: 數組 + 鏈表
*          JDK8 的底層結構: 數組 + 鏈表 (搜尋速度較慢，但較不佔用空間) + 紅黑數 (加速了搜尋速度，但增加了佔據空間)
*       當某一個索引位置上的元素以鏈表方式存在的數據超過 8 個 且當前數組長度 > 64 ，則此時 此索引位置上的數據改為紅黑樹存取
*
*
*
DEFAULT_INITIAL_CAPACITY :HashMap 的默認容量， 16
MAXIMUM_CAPACITY: HashMap 的最大支持容量， 2^30
DEFAULT_LOAD_FACTOR: HashMap 的默認加載因子
TREEIFY_THRESHOLD: Bucket 中鏈表長度大於該默認值，轉化為紅黑樹，TREEIFY_THRESHOLD = 8
UNTREEIFY_THRESHOLD: Bucket 中紅黑樹存儲的 Node 小於該默認值，轉化為鏈表
MIN_TREEIFY_CAPACITY: 桶中的 Node 被樹化時最小的 hash 表容量。（當桶中 Node 的數量大到需要變紅黑樹時，若 hash 表容量小於 MIN_TREEIFY_CAPACITY 時，此時應執行
resize 擴容操作這個 MIN_TREEIFY_CAPACITY 的值至少是 TREEIFY_THRESHOLD 的 4倍。） ；MIN_TREEIFY_CAPACITY = 64
table: 存儲元素的數組，總是 2 的 n 次冪
entrySet: 存儲具體元素的集
size: HashMap 中存儲的鍵值對的數量
modCount: HashMap 擴容和結構改變的次數。
threshold: 擴容的臨界值= 容量 * 填充因子 ； 預設是 12，為何要提早擴? 因為Map 不一定會全部放滿，而我們又希望資料盡可能不要呈現鏈表結構，因此才會提早擴增同時打散鏈表。
loadFactor: 填充因子
*
*
* */

/*
* LinkedHashMap 底層實現:
* 基本上跟HashMap差不多，差別在於 LinkedHashMap override NewNode() method，其中，LinkedHashMap 是使用 Entry (繼承Hashmap.Node) 存取，多含了 before與 after的Node，
* 因此才能連結前後。
*
* HashMap.Node 包含:
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

* LinkedHashMap.Entry 包含:
*  HashMap.Node
*  Entry<K,V> before;
*  Entry<K,V> after;
* */

import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yu-Jing
 * @create 2022-07-20-PM 02:58
 */
public class MapTest {

    @Test
    public void test1(){
        Map map = new LinkedHashMap();
        map.put("Name","GG");
        map.put("Age",123);
        map.put("Food","Apple");

        System.out.println(map);

    }
}
