package Test2;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee m1 = new Manager("harry", 1, 5000, 3000);
        Employee e1 = new CommonEmployee();
        m1.work(m1);
        e1.work(e1);

        // 創建 匿名類但有名(名字為 e2) 的對象，注意 e2 是屬於子類(但不知道是哪個子類)，不是子類
        Employee e2 = new Employee() {
            @Override
            public void work(Employee employee) {
                System.out.println("工作");

            }
        };
    }
}
