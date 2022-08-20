package Project03.view;

import java.util.Scanner;

public class TSUtility {
    public static int inputInt(int min, int max) {
        Scanner scan = new Scanner(System.in);
        int num = -9;
        try {
            num = scan.nextInt();
            if (num < min || num > max) {
                System.out.println("輸入的數值低於最小值 " + min + ";或高於最大值 " + max);
                System.out.print("請重新輸入: ");
                return TSUtility.inputInt(min, max);
            } else {
                return num;
            }
        } catch (RuntimeException e) {
            System.out.print("輸入的數值類型有誤!");
            System.out.print("請重新輸入:  ");
            return TSUtility.inputInt(min, max);
        }
    }

    public static String inputYN(String[] type){
        Scanner scan = new Scanner(System.in);
        String s = "NA";
        try{
            s = scan.next();
            for (int i = 0; i < type.length; i++){
                if (type[i].equals(s)) return s;
            }
            System.out.print("輸入的類型無法辨識!");
            System.out.print("請重新輸入: ");
            return TSUtility.inputYN(type);
        }catch (RuntimeException e) {
            System.out.print("輸入的數值類型有誤!");
            System.out.print("請重新輸入:  ");
            return TSUtility.inputYN(type);
        }
    }


}
