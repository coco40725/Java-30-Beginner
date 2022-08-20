package Test;
/*
* 1. 建出一個方法: 可以 print中 10*8 的 "*" 長方形，並在main方法調用
* 2. 修改上一個方法，除print出長方形外，請計算面積並output 面積
* 3. 修改上一個方法: 在method中提供m n兩變數，print中 m*n 的 "*" 長方形，並在main方法調用，計算面積並output 面積
*
*
* */


public class Method_Test1 {
    public static void main(String[] args) {
        Method_Test1 m1 = new Method_Test1();
        int area;

        area = m1.calArea(5,16);
        System.out.println(area);



    }

    // Method
    public int calArea(int m, int n){
        // print 出 圖片
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        // 計算面積
        return m * n;

    }
}
