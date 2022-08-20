package Test4;

public class ReturnExceptionDemo {
    public static void main(String[] args) {
        try {
            methodA();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        methodB();
    }
    static void methodA() {
        try{
            System.out .println("進入A");
            throw new RuntimeException("製造異常");
        }finally{
            System.out .println("用A finally");
        }
    }

    static void methodB(){
        try{
            System.out .println("進入B");
            return;
        }finally{
            System.out .println("用B finally");
        }
    }
}
