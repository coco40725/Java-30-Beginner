package Project03.domain;

public class Programmer extends Employee{
    private  String status;
    private final String position;
    private final  Equipment equipment;
    private int memberId = 0;


    public Programmer(int id, String name, int age, double salary, String status, String position, Equipment equipment) {
        super(id, name, age, salary);
        this.status = status;
        this.position = position;
        this.equipment = equipment;
    }

    public String getStatus() {
        return status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPosition() {
        return position;
    }


    public Equipment getEquipment() {
        return equipment;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void printAllInfo() {
        System.out.println(String.format("%-5s\t%-15s\t%-5s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s",
                getId(), getName(), getAge(), getSalary(), getPosition(), getStatus(), "", "", getEquipment().deviceDescription()));
    }

    @Override
    public void printTeamInfo(){
        System.out.println(String.format("%-2s%s%-5s\t%-15s\t%-5s\t%-15s\t%-15s",
                getMemberId(),"/",getId(), getName(), getAge(), getSalary(),getPosition()));
    }
}
