package Test;

/*
* Class中的methods
* 1. 用於刻劃一個class應有甚麼功能，例如 Scanner.nextInt(), Math.sqrt(), Math.random(), Arrays.sort()
* 2. Method 的格式:
* [方法的權限修飾子] [其他修飾子, static, final,... (可選)] [方法output的數據類型] [方法名稱] ([參數1類型] [參數1名稱], [參數2類型] [參數2名稱]){
*  .... code ....
*  return [變數];
* }
* a. 權限修飾子: public, private, protected, 默認。 決定了這個方法 能在哪些class可以用 (封裝性時會細談)
* b. 方法output的數據類型:
*    b1. 不要返回值: void,不需要return,若一定要寫，則可以寫return; 代表方法中止;
*    b2. 要返回值: int, char,.... ， 一定要搭配return
*    b3. return; 後面不能再寫code
* c. 方法名稱: 遵守名稱規定
* d.參數表 [參數1類型] [參數1名稱]: 可有可無
*
* 3. Method使用說明
* a. 可以在方法內調用當前class的屬性 (變數)
* b. 可以在方法內調用當前class的方法，特殊用法:遞歸方法 (方法A中又調用方法A)
* c. 不可以在方法中 定義一個方法
*
*
* */

public class Customer_Test {
}

class Customer{

    // Field
    int age;
    String name;
    boolean isMale;

    // Methods
    public void eat(){
        System.out.println("客戶吃飯");
    }

    public  void sleep(int hours){
        System.out.println("休息了" + hours + "小時");
    }

    public  String getName(){
        return name;
    }

    public String getNation(String nation){
        String info = "我的國籍是" + nation;
        return info;
    }
}