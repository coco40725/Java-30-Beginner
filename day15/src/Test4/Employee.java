package Test4;

abstract public class Employee {
    private String name;
    private int number;
    private  MyDate birthday;

    public Employee(){}
    public Employee(String name, int number, MyDate birthday){
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    abstract public double earnings();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

}

class MyDate{
    private long year;
    private int month;
    private int day;

    public MyDate(long year, int month,  int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public  String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }

    public long getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(){}
    public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary){
        super(name,number,birthday);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{"+
                "name='" + getName() + '\'' +
                ", number=" + getNumber()  +
                ", birthday=" + getBirthday().toDateString() +
                '}';
    }
}

class HourlyEmployee extends Employee{
    private double wage;
    private double hour;

    public HourlyEmployee(){}
    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour){
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{"+
                "name='" + getName() + '\'' +
                ", number=" + getNumber()  +
                ", birthday=" + getBirthday().toDateString() +
                '}';
    }

}