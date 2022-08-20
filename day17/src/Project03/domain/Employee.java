package Project03.domain;

import Project03.Data.TeamArrayData;
import Project03.service.TeamException;

public class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final double salary;
    private String status = null;

    public Employee(int id, final String name, final int age, final double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }


    public void joinTeam(TeamArrayData teamArrayData) throws TeamException{
        // 1. Team 滿員
        if (teamArrayData.getCurrentNum() == 6){
            throw new TeamException("添加失敗! 原因: 成員已滿!");

        } else {
            //2. 非開發人員
            if (this.getStatus() == null)  throw new TeamException("添加失敗! 原因: 非開發成員!");

            //3. 是開發人員，但是休假中
            if (this.getStatus() == "VOCATION")  throw new TeamException("添加失敗! 原因: 此員工正在休假!");

            //4. 是開發人員，但是 busy
            if (this.getStatus() == "BUSY" && teamArrayData.findMember(this.id) >= 0){
                throw new TeamException("添加失敗! 原因: 此員工已在本團隊");
            }else if (this.getStatus() == "BUSY" && teamArrayData.findMember(this.id) <0) {
                throw new TeamException("添加失敗! 原因: 此員工在其他團隊");
            }

            //5. 是開發人員，且free
            if (this.getStatus() == "FREE" && teamArrayData.getCurrentNum() != 0){
                Programmer emp_p = (Programmer) this;
                if (emp_p.getPosition() == "程式工程師"){
                    if (teamArrayData.getPositionNum("Programmer") >= 3) throw new TeamException("添加失敗! 原因: 程式工程師已有3名");
                }else if (emp_p.getPosition() == "設計師"){
                    if(teamArrayData.getPositionNum("Designer") >= 2) throw new TeamException("添加失敗! 原因: 設計師已有2名");
                }else {
                    if(teamArrayData.getPositionNum("Architect") >= 1) throw new TeamException("添加失敗! 原因: 架構師已有1名");
                }
            }

        }

    }

    public void leaveTeam(TeamArrayData teamArrayData) throws TeamException{
        if (teamArrayData.getCurrentNum() == 0){
            throw new TeamException("移除失敗! 原因: 該員工並不在此團隊中");
        } else {
            if (teamArrayData.findMember(this.id) < 0)  throw new TeamException("移除失敗! 原因: 該員工並不在此團隊中");
        }
    }


    public void printAllInfo() {
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-15s",
                id, name, age, salary));
    }

    public void printTeamInfo() {
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-15s",
                id, name, age, salary));
    }

}
