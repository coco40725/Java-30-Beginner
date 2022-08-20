package Test8;

public class InnerClassTest1 {
    // 開發中較少見
    class AA{}

    //較常見
   public Comparable getCompareable(){
        // 創建一個實現　comparable 的 局部內部類
       class Mycomparable implements Comparable{

           @Override
           public int compareTo(Object o) {
               return 0;
           }
       }
       // 方法一: return new Mycomparable();
       return new Comparable() {
           @Override
           public int compareTo(Object o) {
               return 0;
           }
       };
    }
}
