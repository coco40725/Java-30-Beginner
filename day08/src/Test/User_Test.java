package Test;

/*
* Class 中的屬性，稱為成員變數" (Member Variable)；而定義在main方法等的變數 屬於 "區域變數" (Local Variable)
*
* A. Member Variable
* 1. 存於 Heap (非 static)
* 2. 定義在class中的 變數 (亦稱為 屬性)
* 3. 可以在定義變數時，直接定義 權限修飾子 (影響此屬性是否可以在這個類以外被調用): public, private, protected, 默認
* ex. public int age = 20;
* ex. 我可以在 class  User_Test 調用 class的 屬性 age嗎?
* 4. 默認值: 整數與char: 0 / 浮點數: 0.0 / boolean: false / String: null
*
* B. Local Variable
* 1. 存於 Stack
* 2. 定義在 方法內(實際參數，actual parameter)、方法內的參數(形式參數,formal parameter)、構造子、代碼塊 內的 變數
* 3. 由於Local Variable是定義在方法上的，因此此變數的權限是取決於你的方法，不可以額外添加權限修飾子!
* ex. public int age = 20; error!
* 4. 沒有默認值! 換言之，調用 Local Variable 前一定要給予值!
* ex. talk("中文"); okay
* ex. talk(); error!!
*
* */

public class User_Test {
}

class User{
    // Member Variable
    int age;
    String name;

    // Method
    public void talk (String language){ // language 是 formal parameter ，屬於Local Variable
        System.out.println("使用的語言為: " + language);
    }

    public void eat(){
        String food = "披薩"; // food 是 actual parameter，屬於Local Variable
        System.out.println("人可以吃 " + food);

    }
}
