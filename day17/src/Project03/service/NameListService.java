package Project03.service;

import Project03.Data.AllEmployeeArrayData;
import Project03.Data.TeamArrayData;
import Project03.domain.Programmer;

public class NameListService {

    // 選項2 對於 AllEmployeeArrayData 的操作: 將特定員工加入 Team，狀態更動
    public static void AllEAD_2(int id, TeamArrayData teamArrayData) throws TeamException{
        AllEmployeeArrayData.getEmployee(id).joinTeam(teamArrayData);
        Programmer tmp = (Programmer) AllEmployeeArrayData.getEmployee(id);
        tmp.setStatus("BUSY"); // 成功加入!
    }

    // 選項3 對於 AllEmployeeArrayData 的操作: 將特定員工從 Team中移除，狀態更動
    public static void AllEAD_3(int id, TeamArrayData teamArrayData) throws TeamException{
        AllEmployeeArrayData.getEmployee(id).leaveTeam(teamArrayData);
        Programmer tmp = (Programmer) AllEmployeeArrayData.getEmployee(id);
        tmp.setStatus("FREE"); // 成功移除!
    }

}
