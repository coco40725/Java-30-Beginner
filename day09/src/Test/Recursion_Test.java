package Test;

public class Recursion_Test {
    // 使用遞迴法:
    // 已知 f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n+1) + f(n)
    // 求 f(10)
    public static void main(String[] args) {
        Recursion_Test r1 = new Recursion_Test();
        int ans = r1.fun(10);
        System.out.println(ans);
    }

    public int fun(int n){
        if (n == 0){
            return 1;
        } else if (n == 1){
            return 4;
        } else {
            return 2* fun(n - 1) + fun(n - 2);
        }
    }
}
