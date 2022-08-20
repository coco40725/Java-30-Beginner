package SortTest;

/**
 * @author Yu-Jing
 * @create 2022-07-15-PM 03:42
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee tmp = (Employee) o;
            return this.name.compareTo(tmp.name);
        }
        throw new RuntimeException("Not available Object type! ");
    }
}

class MyDate{
    private int year;
    private int month;
    private int daty;

    public MyDate(int year, int month, int daty) {
        this.year = year;
        this.month = month;
        this.daty = daty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDaty() {
        return daty;
    }

    public void setDaty(int daty) {
        this.daty = daty;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", daty=" + daty +
                '}';
    }
}

