package Project03.Data;

import Project03.domain.*;

public class AllEmployeeArrayData {
    public static Employee[] EMPLOYEES;

    static{
        EMPLOYEES = new Employee[12];
        EMPLOYEES[0] = new Employee(1,"馬雲",22,3000);
        EMPLOYEES[1] = new Architect(2,"馬化騰",32,18000,"VOCATION","架構師", new NoteBook("聯想",6000),15000,2000 );
        EMPLOYEES[2] = new Programmer(3, "李彥宏",23,7000,"FREE","程式工程師",new PC("戴爾","NEC17寸"));
        EMPLOYEES[3] = new Programmer(4, "劉強東",24,7300,"FREE","程式工程師",new PC("戴爾","三星 17寸"));
        EMPLOYEES[4] = new Designer(5,"雷軍",28,10000,"FREE","設計師", new Printer("激光","2000"),5000);
        EMPLOYEES[5] = new Programmer(6, "任志強",22,6800,"BUSY","程式工程師",new PC("華碩","三星 17寸"));
        EMPLOYEES[6] = new Designer(7,"柳傳志",29,10800,"FREE","設計師", new PC("華碩","三星 17寸"),5200);
        EMPLOYEES[7] = new Architect(8,"楊元慶",30,19800,"FREE","架構師", new Printer("針式","愛普生20K"),15000,2500 );
        EMPLOYEES[8] = new Designer(9,"史玉柱",26,9800,"FREE","設計師", new NoteBook("惠普m6",5800),5500);
        EMPLOYEES[9] = new Programmer(10, "丁磊",21,6600,"FREE","程式工程師",new PC("戴爾","NEC17寸"));
        EMPLOYEES[10] = new Programmer(11, "朝陽",25,7100,"FREE","程式工程師",new PC("華碩","三星 17寸"));
        EMPLOYEES[11] = new Designer(12,"楊致遠",27,9600,"FREE","設計師", new NoteBook("惠普m6",5800),4800);
    }

    public static Employee getEmployee(int id){
        for (int i = 0; i < 12; i++){
            if (EMPLOYEES[i].getId() == id) return EMPLOYEES[i];
        }
        return null;
    }
}

