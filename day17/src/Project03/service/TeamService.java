package Project03.service;

import Project03.Data.AllEmployeeArrayData;
import Project03.Data.TeamArrayData;
import Project03.domain.Employee;
import Project03.domain.Programmer;

import java.util.Scanner;

public class TeamService {
    // 選項2 對於 TeamData 的操作: 將特定員工加入 Team
    public static void Team_2(int id, TeamArrayData teamArrayData){
        try{
            NameListService.AllEAD_2(id,teamArrayData);
            teamArrayData.setCurrentNum(teamArrayData.getCurrentNum() + 1);
            teamArrayData.addInit();
            Programmer tmp = (Programmer) AllEmployeeArrayData.getEmployee(id);
            tmp.setMemberId(teamArrayData.getInit()); // 新增 memberId
            teamArrayData.TeamData[teamArrayData.getCurrentNum() - 1] =  AllEmployeeArrayData.getEmployee(id);
            System.out.println("添加成功!");
            System.out.println("按Enter繼續...");
            new Scanner(System.in).nextLine();

        }catch(TeamException e){
            System.out.println(e.getMessage());
            System.out.println("按Enter繼續...");
            new Scanner(System.in).nextLine();

        }
    }

    // 選項3 對於 TeamData 的操作: 將特定員工移出 Team
    public static void Team_3(int id, TeamArrayData teamArrayData){
        try{
            NameListService.AllEAD_3(id,teamArrayData);
            int remove_loc = teamArrayData.findMember(id);
            teamArrayData.TeamData[remove_loc] = null; // TeamData 那個位置 初始化
            Programmer tmp = (Programmer) AllEmployeeArrayData.getEmployee(id);
            tmp.setMemberId(0); // memberId 初始化

            System.out.println("移除成功!");

            // 將資料往上移，補空位
//            Employee[] tmp_array = new Employee[6];
//            int remainElement = teamArrayData.getCurrentNum() - remove_loc;
//            //System.arraycopy(來源, 起始索引, 目的, 起始索引, 長度)
//            System.arraycopy(teamArrayData.TeamData, 0 ,tmp_array,0,remove_loc);
//            System.arraycopy(teamArrayData.TeamData, remove_loc + 1 ,tmp_array,remove_loc,remainElement);
//            teamArrayData.TeamData = tmp_array;
            for (int j = remove_loc + 1 ; j < teamArrayData.getCurrentNum();j++){
                teamArrayData.TeamData[j - 1] =  teamArrayData.TeamData[j];
                }
            teamArrayData.TeamData[teamArrayData.getCurrentNum() - 1] = null;
            teamArrayData.setCurrentNum(teamArrayData.getCurrentNum() - 1);

            System.out.print("按Enter繼續...");
            new Scanner(System.in).nextLine();

        }catch(TeamException e){
            System.out.println( e.getMessage());
            System.out.println("按Enter繼續...");
            new Scanner(System.in).nextLine();

        }
    }

}
