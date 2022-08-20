package Test;

import java.util.Random;

/*
* 1. 定義類 Student，且包含三個屬性: number (int); state (int); score (int)
* 2. 建立20個此類的instance，number為1-20， 剩餘2個屬性皆由 隨機數決定
* 3. print出 3年級 學生的資訊
* 4. 排序學生的成績
*
*
*
*
* */
public class Method_Test2 {
    public static void main(String[] args) {

        // 初始化 20 位學生的資料
        Method_Test2 m1 = new Method_Test2();
        Student1[] std = new Student1[20];

        // 將std賦值
        m1.assignValue(std);


        m1.printStd(std);
        System.out.println();

        // Question 1 : print出 3年級 學生的資訊
        m1.searchStdState(std,3);

        // Question 2: 使用冒泡排序將學生根據成績排序
        m1.sortStd(std);

        System.out.println();
        m1.printStd(std);

    }

    // 建構 Method

    /**
     * @Description 找特定年級的學生訊息
     * @param std 欲找的資料
     * @param dist_state 目標年級
     */

    public void searchStdState (Student1[] std,int dist_state){
        for (int j = 0; j < std.length; j++){
            if (std[j].state == dist_state){
                std[j].printInfo();
            }
        }
    }

    /**
     * @Description 根據學生成績以冒泡排序進行排序
     * @param std
     */
    public void sortStd (Student1[] std){
        for (int i = 0; i < std.length; i++){
            for (int j = 0; j < std.length - (i + 1); j++){
                if (std[j].score > std[j + 1].score){
                    Student1 tmp = new Student1();
                    tmp = std[j];// 換記憶體位址
                    std[j] = std[j + 1];
                    std[j + 1] =  tmp;
                }
            }
        }
    }

    /**
     *  @Description 將std賦值
     * @param std
     */
    public void assignValue(Student1[] std){
        for (int i = 0; i < std.length; i++){
            std[i] = new Student1();
            Random rnd = new Random();
            std[i].number = i + 1;
            std[i].score = rnd.nextInt(101);
            std[i].state = rnd.nextInt(6) + 1;
        }
    }

    /**
     *  @Description 將std print 出來
     * @param std
     */
    public void printStd(Student1[] std){
        for (int j = 0; j < std.length; j++) std[j].printInfo();
    }


}

class Student1 {
    // Field
    int number;
    int state;
    int score;

    // Method
    public void printInfo(){
        System.out.println("學號: " + number + "; " + "年級: " + state + "; " + "成績: " + score);
    }


}