package Practice1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yu-Jing
 * @create 2022-07-29-AM 08:48
 */
public class DAO <T>{
    private Map<String,T> map = new HashMap<>();

    public void save(String id, T entry){
        if (!map.containsKey(id)) {
            map.put(id, entry);
            System.out.println("添加成功");
        }else {
            System.out.println("此ID已存取數值!");
        }

    }

    public T get(String id){
       return map.get(id);
    }

    public void update(String id, T entry){
        if (map.containsKey(id)) {
            map.put(id, entry);
            System.out.println("更新成功");
        }else {
            System.out.println("此ID尚未存取任何數值");
        }
    }

    public List<T> list(){
       return new ArrayList<>(map.values());
    }
    public void delete(String id){
        if (map.containsKey(id)){
            map.remove(id);
            System.out.println("刪除成功");
        }else {
            System.out.println("沒有此ID，無法刪除對應數值");
        }
    }
}
