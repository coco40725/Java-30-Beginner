/*
* * B. 集合框架
 *   | ----- Collection interface : 單列接口，用來存一個一個的object
 *       |----- List interface : 存有序可重複的數據，又可稱為 動態Array (因為可以修改)
 *           |----- ArrayList, LinkedList, Vector 實現類
 *
 *       |----- Set interface : 存無序不可重複的數據，也就是 "set"
 *           |----- HashSet 實現類: 作為set interface的主要實現類，thread not safe，可存取null
 *                      |----- LinkedHashSet 實現類: 為HashSet子類，增加了雙向鏈，使的遍歷其內部資料時，會按照"你添加資料的順序" 來遍歷，適用於對數據頻繁的遍歷操作
 *           |----- TreeSet 實現類: 必須"存放同樣類型"的物件，必依照物件的特定屬性來"排序"
*
* */

/*
* Set
* 1. 無序性 : 不等於隨機性。以 HashSet為例，無序性指的是 在存取數據時，並非是按照順序的排入array中，如下
*            第3次add的數據 --- 第1次add的數據 --- 第5次add的數據 --- 第18次add的數據 --- 第2次add的數據 ---
*           但也不是到完全隨機性的放，他是根據數據的hashvalue來決定數據要擺在array的哪個位置
*
* 2. 不可重複  : 根據hashcode + equal method判斷物件的異同，相同的元素只能存在一個。先使用hashcode再用equals去進行判斷
*              因此 override equals method:
*                 @Override
                    public boolean equals(Object o) {
                        System.out.println("equals override!!");
                        if (this == o) return true;
                        if (o == null || getClass() != o.getClass()) return false;
                        Person person = (Person) o;
                        return age == person.age && Objects.equals(name, person.name);
                    }
                    this == o 比較  兩個物件之間的memory pointer
                    *

                    *
*
* 3. Set是如何存放數據的?
*   a. 創建一個預設大小為16的Array;
*   b. 創建一個數據，並得到該數據的hashcode x
*   c. 透過特定的function f(.) 可以算出這個數據應當放在Array中第 y 的位置； y = f(x)
*   d. 接著，當有新的數據加入，其hashcode為 x1，y1 = f(x1) 並存放在第y1的位置
*   e. 若 y1 的位置沒有元素佔據，則直接填入 --> 新增成功
*      若 y1的位置有元素佔據，則進一步 比較佔據的元素 與 新元素 之 hashcode  是否相同；
*           若不相同，則代表新元素是非重複元素，接著會以鏈狀的方式與此位置的元素串接 --> 新增成功
*           若相同，則進一步去 使用 "equals" 去比較內容物: (同一物件 --> hashcode必相同，反過來不必然)
*                   若內容物不相同，則代表新元素是非重複元素，接著會以鏈狀的方式 (舊元素---> 新元素) 與此位置的元素串接 --> 新增成功
*                   若相同，則代表此為新元素是重複元素 --> 不新增元素
*
* 4. 沒有額外定義新的method
* 5. 不建議set出現鏈狀結構，因此hashcode怎麼設計很重要
* 6. Set 裡面的元素必須要 override的method: equals + hashcode，且 比較的規則 與 計算hashcode的規則 要一致!
*
* 7. LinkedHashSet 為何可以依照添加的先後順序輸出?
*   LinkedHashSet 作為HashSet的子類，在添加數據的同時，又保存了順序(雙向鏈狀)。
* */


/*
* 注意: 只要牽扯到override equals, 就一定要跟著override hashCode!!
*
* */



package Test1;


class Users implements Comparable{
    String name;
    int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // 先比age 再比 name
    @Override
    public int compareTo(Object o) {
        if (o instanceof Users){
            Users users = (Users) o;
            if (Integer.compare(age, users.age) != 0)  return -Integer.compare(age, users.age);
            return name.compareTo(users.name);
        }
        throw  new RuntimeException("Wrong class type!!");
    }
}
