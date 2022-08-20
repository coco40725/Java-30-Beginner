package Project03.domain;

public class Designer  extends Programmer{
    private final double bonus;


    public Designer(int id, String name, int age, double salary, String status, String position, Equipment equipment, double bonus) {
        super(id, name, age, salary, status, position, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }


    @Override
    public void printAllInfo() {
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                getId(), getName(), getAge(), getSalary(), getPosition(), getStatus(), getBonus(), "", getEquipment().deviceDescription()));

    }


    @Override
    public void printTeamInfo() {
        System.out.println(String.format("%-2s%s%-5s\t%-15s\t%-5s\t%-15s\t%-10s\t%-15s",
                getMemberId(),"/", getId(), getName(), getAge(), getSalary(), getPosition(),getBonus()));

    }
}
