package Lession;

public class Woman extends Person{
    boolean isBeauty;

    public void goShopping(){
        System.out.println("女人喜歡購物");
    }

    @Override
    public void eat() {
        System.out.println("女人減肥少吃");
    }
}
