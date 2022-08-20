/*
*
* 1. reference type的變數 只能存 "null" 或是 "記憶體位址"
* 2. 匿名對象:
* a. 建立對象時，不給予名稱，例如:
* new Phone();
* b. 基本上只能調用一次，因為沒有把這個class 與 stack 中的變數連結
* c. 但如果是把匿名對象 與 formal parameter連結，則可以重複調用
*
*
* */
package Lession;

public class Instance_Test {
    public static void main(String[] args) {
        // 公開對象，名字叫 p
        Phone p = new Phone();

        System.out.println(p); // 回報 記憶體位址
        p.playGame(); // 對象 p ，進行 playgame
        p.sendMail(); // 對象 p ，進行 sendmail

        // 匿名對象
        new Phone().sendMail(); // 匿名對象1，進行 Send mail
        new Phone().playGame(); // 匿名對象2，進行 Play Game
        new Phone().price = 100.0; // 匿名對象3，進行 price賦值
        new Phone().showPrice(); // 匿名對象4，進行 show Price

        // 匿名對象常用用法
        PhoneMall mail = new PhoneMall();
        mail.show(p);
        mail.show(new Phone());
        // 這裡的 phone.playGame(); 與 phone.sendMail();，這兩個phone 是同一個匿名對象!
        // 這裡的 new Phone 與 formal parameter: phone 連結顧可以重複調用
    }
}

class PhoneMall{
    public void show(Phone phone){
        phone.playGame();
        phone.sendMail();
    }
}


class Phone{
    // Field
    double price;

    // Method
    public void sendMail(){
        System.out.println("發送信件!");
    }

    public void playGame(){
        System.out.println("玩遊戲!");
    }

    public void showPrice(){
        System.out.println("價格為: " + price);
    }

}
