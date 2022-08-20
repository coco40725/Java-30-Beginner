package Project03.domain;

public class Architect extends Designer{
    private final double stack;


    public Architect(int id, String name, int age, double salary, String status, String position, Equipment equipment,double bonus, double stack) {
        super(id, name, age, salary, status, position, equipment, bonus);
        this.stack = stack;
    }

    public double getStack() {
        return stack;
    }

    @Override
    public void printAllInfo() {
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                getId(), getName(), getAge(), getSalary(), getPosition(), getStatus(),getBonus(), getStack(),getEquipment().deviceDescription()));
    }
    @Override
    public void printTeamInfo() {
        System.out.println(String.format("%-2s%s%-5s\t%-15s\t%-5s\t%-15s\t%-10s\t%-12s\t%-15s",
                getMemberId(),"/",getId(), getName(), getAge(), getSalary(), getPosition(),getBonus(), getStack()));
    }

}
