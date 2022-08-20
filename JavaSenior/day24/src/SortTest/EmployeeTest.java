package SortTest;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Yu-Jing
 * @create 2022-07-15-PM 03:45
 */
public class EmployeeTest {
    @Test
    public void test1(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee tmp1 = (Employee) o1;
                    Employee tmp2 = (Employee) o2;

                    return -tmp1.getName().compareTo(tmp2.getName());

                }
                throw new RuntimeException("Not available Object type!");
            }
        };

        Set set = new TreeSet(comparator);
        Employee employee1 = new Employee("Andy", 23, new MyDate(1996,2,3));
        Employee employee2 = new Employee("Nick", 63, new MyDate(1980,12,13));
        Employee employee3 = new Employee("Zip", 10, new MyDate(2001,7,19));
        Employee employee4 = new Employee("BTC", 42, new MyDate(1956,4,10));
        Employee employee5 = new Employee("ROB", 47, new MyDate(1954,10,25));
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
