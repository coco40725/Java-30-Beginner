package Test55;

/**
 * @author Yu-Jing
 * @create 2022-08-17-PM 01:09
 */
public class Person implements ability{
    @Override
    public void say(String str) {
        System.out.println("人類可以說: " + str);
    }

    public void eat(){
        System.out.println("人類吃飯!!!");
    }
}

interface ability{
    void say(String str);
}