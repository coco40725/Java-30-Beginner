package Instanceof;

public class Man  extends Person{

    boolean smoking;
    int id = 1002;

    public void earnMoney(){
        System.out.println("男生賺錢養家");
    }

    @Override
    public void eat() {
        System.out.println("男生多吃肉");
    }

}
