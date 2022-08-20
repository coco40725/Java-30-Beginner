package Test2;

import java.io.Serializable;

/**
 * @author Yu-Jing
 * @create 2022-08-16-AM 10:42
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;


    private void breath(){
        System.out.println("生物呼吸");
    }

    public  void eat(){
        System.out.println("生物吃東西");
    }
}
