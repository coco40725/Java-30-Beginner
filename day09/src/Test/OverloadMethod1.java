package Test;

public class OverloadMethod1 {
    public static void main(String[] args) {
        OverloadMethod1 m1 = new OverloadMethod1();
        m1.max(1,30);
        m1.max(12,30.5);

    }

    public int max (int i, int j){
        return (i >= j) ? i : j;

    }
    public double max (double i, double j){
        return (i >= j) ? i : j;

    }
    public double max (double i, double j, double k){
        double maxV = (i >= j) ? i : j;
        return (maxV >= k) ? maxV : k;

    }

}


