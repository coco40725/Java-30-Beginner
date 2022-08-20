package Project03.Data;

import Project03.domain.Employee;

public class TeamArrayData {
    private static int currentNum = 0;
    private static int init = 0;
    public static Employee[] TeamData = new Employee[6];

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum =  currentNum;
    }

    public int getInit() {
        return init;
    }

    public void addInit() {
        init += 1 ;
    }


    public int getPositionNum(String position){
        int tmp = 0;
        for (int i = 0; i < currentNum; i++){
            if (TeamData[i].getClass().getSimpleName().equals(position)) tmp++;
        }
        return tmp;
    }

    public int findMember(int id){
        for (int i = 0; i < currentNum; i++){
            if (TeamData[i].getId() == id) return i;
        }
        return -9;
    }

}
