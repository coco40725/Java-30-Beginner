package Test2;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.regist(-12);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s);
    }
}

class Student{
    private int id;
    public void regist(int id) throws Exception{
        if (id > 0){
            this.id = id;
        }else {
            // System.out.println("輸入有誤!");
            // 手動拋出異常對象
            // throw new RuntimeException("輸入有誤!!!");
            throw new MyException1("輸入異常");
        }

    }
}