package Test2;

abstract public class Employee {
    private String name;
    private int id;
    private double salary;

    public  Employee(){}
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    abstract public void work(Employee employee);

}

class Manager extends Employee{
    private double bonus;

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work(Employee employee) {
        System.out.println("管理員工，提升公司運行的效率");
    }
}

class CommonEmployee extends Employee{

    @Override
    public void work(Employee employee) {
        System.out.println("員工生產產品");
    }
}