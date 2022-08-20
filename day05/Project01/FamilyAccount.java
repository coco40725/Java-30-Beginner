/*
已經建好function用的class,可以直接調用!
javac -encoding UTF-8  -classpath D:\Java_lession\1_basic\code\day05\Project01  D:\Java_lession\1_basic\code\day05\Project01\FamilyAccount.java
java -classpath D:\Java_lession\1_basic\code\day05\Project01 FamilyAccount
記住! 要指定好class 位置，java才找的到!
*/
public class FamilyAccount{
    public static void main (String args[]){

     int money = 10000;  
     String detailed = ""; 
     boolean isOut = false;

    FirstDo : do {
         System.out.println("-----------------家庭收支紀錄程式-----------------");
         System.out.println();
         System.out.println("                 1 顯示收支明細");
         System.out.println("                 2 輸入收入");
         System.out.println("                 3 輸入支出");
         System.out.println("                 4 退出");
         System.out.print("請輸入項目(1-4): ");

         char type = Utility.readMenue();
         switch (type){
             case '1':
               System.out.println("-----------------目前的收支紀錄-----------------");
               System.out.println("收支 \t 帳戶餘額 \t 收支金額 \t 說明");
               System.out.println(detailed);
               System.out.println();
			         System.out.println("---------------------------------------------");
               break;


             case '2':
               System.out.println("本次收入金額");
               int money_in = Utility.readNumber();
               System.out.println("說明");
               String str_in = Utility.readComment(8);
               money += money_in;
               str_in = "收入" + " \t " + money + " \t\t " + money_in + " \t\t "+ str_in;
               detailed = detailed + "\n" + str_in;
               System.out.println("---------------------紀錄完成-------------------");
               break;
               

             case '3':
               System.out.println("本次支出金額");
               int money_out = Utility.readNumber();
               System.out.println("說明");
               String str_out = Utility.readComment(8);
               money -= money_out;
               str_out = "支出" + " \t " + money + " \t\t " + money_out + " \t\t " + str_out;
               detailed = detailed + "\n" + str_out;
               System.out.println("---------------------紀錄完成-------------------");
               break;

             case '4':
               System.out.println("確定要退出 (Y/N)? ");
               char ans = Utility.readConfirmSelection();
               if (ans == 'Y'){
                   isOut = true;
                   break;
               } 
               


         }

            
        } while(isOut == false);



    }
}