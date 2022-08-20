package Test1;

public class MainDemo {
    public static void main(String[] args) { // 可以從 run configuration那裏操作
        for (int i = 0; i < args.length; i++){
            System.out.println("******************"+args[i]);
            int num = Integer.parseInt(args[i]);
            System.out.println("####" + num);
        }
    }
}
