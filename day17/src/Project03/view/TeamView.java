package Project03.view;

import Project03.Data.AllEmployeeArrayData;
import Project03.Data.TeamArrayData;
import Project03.service.TeamService;

import java.util.Scanner;

public class TeamView {
    boolean is_open = true;
    AllEmployeeArrayData allEmployeeArrayData = new AllEmployeeArrayData();
    TeamArrayData teamArrayData = new TeamArrayData();


    // 展現 AllEmployeeArrayData 的資料
    public int showAllEmployee(){
        System.out.println("-------------------------------------員工總表--------------------------------------");
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-12s\t%-15s\t%-12s\t%-12s\t%-12s\t%-15s",
                "ID", "姓名", "年齡", "薪水" , "職位" , "狀態" , "獎金", "股票", "使用設備"));
        for (int i = 0; i < allEmployeeArrayData.EMPLOYEES.length; i++){
            allEmployeeArrayData.EMPLOYEES[i].printAllInfo();
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("1-團隊列表  2-添加團隊成員  3-刪除團隊成員 4-退出 請選擇(1-4)： ");
        int select_num = TSUtility.inputInt(1,4);
        return select_num;
    }

    // 選項1: 展現 TeamArrayData 的資料
    public void showTeam(){
        System.out.println("-------------------------------------團隊成員列表--------------------------------------");
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-12s\t%-12s\t%-12s\t%-1s",
                "TID/ID","姓名","年齡","薪水","職位","獎金","股票"));
        for (int i = 0; i < teamArrayData.TeamData.length ; i++){
            if (teamArrayData.TeamData[i] != null){
                teamArrayData.TeamData[i].printTeamInfo();
            } else {
                break;
            }
        }
        System.out.print("按Enter繼續...");
        new Scanner(System.in).nextLine();
    }

    //選項2: 添加團隊成員/
    public void addTeamMember(){
        System.out.println("-----------------------------------添加團隊成員------------------------------------");
        System.out.print("請輸入欲添加之員工ID: ");
        int addID = TSUtility.inputInt(1,AllEmployeeArrayData.EMPLOYEES.length);
        TeamService.Team_2(addID,teamArrayData);

    }

    //選項3: 移除團隊成員
    public void removeTeamMember(){
        System.out.println("-----------------------------------移除團隊成員------------------------------------");
        System.out.print("請輸入欲移除之員工ID: ");
        int removeID = TSUtility.inputInt(1,AllEmployeeArrayData.EMPLOYEES.length);
        System.out.print("確認是否要刪除 (Y/N)?: ");
        String ans = TSUtility.inputYN(new String[]{"Y", "N" });
        if (ans.equals("Y")){
            TeamService.Team_3(removeID,teamArrayData);
        } else{
            System.out.println("已取消!");
            System.out.print("按Enter繼續...");
            new Scanner(System.in).nextLine();
        }
    }

    //選項4: 退出
    public void quit(){
        System.out.print("確認是否要離開 (Y/N)?: ");
        String ans = TSUtility.inputYN(new String[]{"Y", "N" });
        if (ans.equals("Y")){
            is_open = false;
        }else if (ans.equals("N")){
            return;
        }else {
            System.out.println("無法辨識");
        }
    }

    public static void main(String[] args) {
        TeamView menu = new TeamView();
        while(menu.is_open){
           int select =  menu.showAllEmployee();
           switch (select){
               case 1:
                   menu.showTeam();
                   break;
               case 2:
                   menu.addTeamMember();
                   break;
               case 3:
                   menu.removeTeamMember();
                   break;
               case 4:
                   menu. quit();
                   break;
           }
        }
    }

}
