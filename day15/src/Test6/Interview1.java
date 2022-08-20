package Test6;

public class Interview1 {
}

interface  A{
    final static int x = 1;
    final static int x1 = 2;
}

class B {
    int x = 0;
    int x2 = 3;
}

class C extends B implements A{
   public void pX(){
       // System.out.println(x); error，程式不知道x是誰的，因為 class 與 interface的地位相同
       // 若想要調用的是 B 的 x:
       System.out.println(super.x);


       //若想要調用的是 C 的 x:
       System.out.println(A.x);

       //沒有重名的話 可以直接調
       System.out.println(x1);
       System.out.println(x2);
   }

    public static void main(String[] args) {
        new C().pX();
    }
}