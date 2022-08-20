/*
* OOP的特徵
* 1. 封裝性 (此處欲探討的特性)
* 2. 繼承性
* 3. 多態性
*  ---------------------
* 1. 封裝性: Java提供了 四種不同的權限修飾子，來呈現 class 與其內部結構調用時的可見性。
* a. 屬性的 private :
* a1. class的屬性，需要符合你預期的類型，另外須透過 "方法" 來使屬性符合額外的條件! 例如: 整數不能大於100
* a2. 同時，為了避免 使用者可以直接"定義"或"調用"屬性，我們會將屬性權限定為 private (用戶端完全看不到該屬性，不能定義也不能調出來看)
* a3. 關閉了原本的"定義與調用"功能後，我們會需要 再建立符合我們要求的 "定義方法 (沒有返回值)" 與 "調用方法 (有返回值)"，以取代原本的功能。
*
* b. 方法的 private
* c. 單例模式
* -------------------------------------
* 權限大小 (小 - 大):
* 1. private : 定義出來的function, variable，1. class 內部使用
* 2. default : 定義出來的function, variable，1. class 內部使用 2. 同一個package使用
* 3. protected: 定義出來的function, variable，1. class 內部使用 2. 同一個package使用 3.不同package使用，但要同一個子類
* 4. public: 定義出來的function, variable，1. class 內部使用 2. 同一個package使用 3.不同package使用，但要同一個子類 4. 同一個 project
* 這四種修飾子，可以用於修飾 a. 屬性 b. 方法 c.構造子 d. 內部類 (類裡面定義的類)； 但是若是 修飾class，則只能用 public or default
*
* */
package Test;

public class Animal_Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "八哥";
        a.age = 12;
        // a.legs = 2;

        a.setLegs(6);
        a.show();
        a.setLegs(9);
        // 如果 我不想要 使用者直接定義 .legs 的值，我希望 使用者可以用setLegs 來定義legs的值
        // 使用權限修飾子 private
        // a.legs = 20; // java: legs has private access in Test.Animal，代表你只能在 class Animal 調用legs
        // System.out.println(a.legs); // java: legs has private access in Test.Animal，代表你只能在 class Animal 調用legs
        System.out.println(a.getLegs());

    }

}

class Animal {
    // Field
    String name;
    int age;
    private int legs;

    // Method
    public void eat(){
        System.out.println("動物進食!");
    }

    public void show(){
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("legs: " + legs);
    }

    public void setLegs(int l){
        if (l >= 0 && l % 2 == 0){
            legs = l;
        }else{
            legs = -999;
            System.out.println("legs設定錯誤!");
        }

    }

    public  int getLegs(){
        return legs;
    }
}
