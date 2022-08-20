package Test;

// 先輸入幾位學生
// 再輸入其分數
// 找出最高分者
// 對學生分數進行ABCD分級: A = [100, 90] B = [89, 80] C = [79, 70] D = [69, 60] F

import java.util.Scanner;

public class Array_Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 先輸入幾位學生
        System.out.print("請輸入學生數目: ");
        int num = scan.nextInt();

        // 再輸入其分數 並同時 找到最高分
        System.out.print("請輸入" + num + "個學生的成績: ");

        int[] score = new int[num];
        int max = 0;
        for (int i = 0; i < num; i++) {
            int a = scan.nextInt();
            score[i] = a;
            if (score[i] > max){
                max = score[i];
            }
        }

        // 找出最高分者

        System.out.println("最高分為 " + max + "分!");

        // 對學生分數進行ABCD分級
        for (int i = 0; i < num; i++){
            System.out.println("學生" + i + "的成績為" + score[i] +", 等級為" + ClassScore(score[i]));
        }


    }

    public static char ClassScore(int score){
        score = score / 10;
        char ScoreClass;
        switch (score){
            case 10:
            case 9:
                ScoreClass = 'A';
                break;

            case 8:
                ScoreClass = 'B';
                break;

            case 7:
                ScoreClass = 'C';
                break;

            case 6:
                ScoreClass = 'D';
                break;

            default:
                ScoreClass = 'F';
                break;

        }


        return ScoreClass;
    }
}
