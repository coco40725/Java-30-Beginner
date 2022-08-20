/*
* 編寫
工資系統 實現不同類型員工 多態 的按月發放工資 。 如果當月出現某個
Employee 對象的生日 則將該雇員的工資增加 100 元 。
* */
package Test4;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employee = new Employee[2]; // 為何沒出錯? 因為 你現在new的是 array，而非 Employee!! 因此沒問題!
        employee[0] = new SalariedEmployee("Jack",1002,new MyDate(1995, 6,3),35000);
        employee[1] = new HourlyEmployee("Allen",1003,new MyDate(2005, 4,13),164,8);

        /*方法一: 由用戶端自行輸入
        *
        Scanner scan = new Scanner(System.in);
        System.out.print("請輸入當天月份? ");
        int currentMonth = scan.nextInt();
        * */
        // 方法二: 使用日曆
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH); // 0: 1月 , 1: 2月
        currentMonth++;
        System.out.println(currentMonth);

        for (int i = 0; i < employee.length ; i++) {
            System.out.println(employee[i]);
            if (currentMonth == employee[i].getBirthday().getMonth()){
                System.out.println("本月壽星! 加 3000 元");
                System.out.println("月工資: " + (employee[i].earnings() + 3000));

            }else {
                System.out.println("月工資: " + employee[i].earnings());
            }



        }
    }
}

