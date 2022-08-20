package Test2;

/**
 * @author Yu-Jing
 * @create 2022-07-28-AM 11:21
 */

/*
* DAO: Data access  object : 將常用的數據操作功能: 增 刪 改 查 ，放進此 object ；此為所有表的共性操作功能
* 但是實際狀況是我們會有很多張表，一張表通常用一個Class來代替，如此一來，會導致我們不確定操作的屬性類型是啥，因此可以使用泛型
* */
public class DAO <T> {

    // 增加一條紀錄
   public void add(T t){};

    // 刪除一條紀錄
    public void remove(T t){};

    // 修改一條紀錄

    // 查詢一條紀錄

    // 查詢多條紀錄
}
