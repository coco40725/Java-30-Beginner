/*
* 利用 Vector 代替 array，Vector可以不斷累加，不用先指定大小
*
*
* */
package Exercise1;


import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        keyBorad typeScore = new keyBorad();
        Util_tool cal = new Util_tool();
        Vector allStudentScore = new Vector();

        // 輸入成績
        while (true){
            System.out.print("請輸入成績 (-9為退出): ");
            int score = typeScore.typeInt(100,0);
            if (score == -9) break;
            allStudentScore.addElement(score); // allStudentScore.addElement(new Integer(score));
        }

        // 輸出結果
        if (allStudentScore.size() > 0){
            int max = cal.findHighest(allStudentScore);
            System.out.println("最高分: " + max);
            cal.printLevel(allStudentScore);
        } else {
            System.out.println("未輸入成績，無法計算");
        }

    }
}

class keyBorad{
    Scanner scan = new Scanner(System.in);

    public int typeInt(int high_limit, int low_limit){
        int score  = scan.nextInt();
        if (score == -9) return score;

        while (score > high_limit || score < low_limit) {
            System.out.println("score is out of limit! your score > " + high_limit + " or score < "+ low_limit +", but not -9" + ". 請重新輸入: ");
            score  = scan.nextInt();
            if (score == -9) return score;
        }
        return score;
    }

}

class Util_tool{

    public int findHighest(Vector vec){
        Object obj_max = vec.elementAt(0);
        int max = (int) obj_max; // 自動拆箱
        // 或者
        //Integer int_max = (Integer)obj_max;
        //int max = int_max;

        for (int i = 1;i < vec.size(); i++){
            Object obj_value = vec.elementAt(i);
            int value = (int) obj_value; // 自動拆箱
            //Integer int_value = (Integer)obj_value;
            //int value = int_value;
            if (value > max) max = value;
        }
        return max;
    }

    public void printLevel(Vector vec){
        System.out.println("成績" + "\t" + "等級");
        int max = findHighest(vec);
        for (int i = 0 ; i < vec.size(); i++){
            Object obj_value = vec.elementAt(i);
            int value = (int) obj_value; // 自動拆箱
            //Integer int_value = (Integer)obj_value;
            //int value = int_value;
            if (max - value < 10) {
                System.out.println(value + "\t" + "A等");
            }else if (max - value < 20 && max - value >= 10){
                System.out.println(value + "\t" + "B等");
            } else if (max - value < 30 && max - value >= 20){
                System.out.println(value + "\t" + "C等");
            } else {
                System.out.println(value + "\t" + "D等");
            }
        }

    }
}