package Test5;

public class EcmDef {
    public static void main(String[] args) {
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int result = ecm(num1, num2);
            System.out.println(result);
        } catch (NumberFormatException e){
            System.out.println("數據類型不一致");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少參數");
        } catch (ArithmeticException e){
            System.out.println("分母是0");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }
    }

    public static int ecm(int i, int j) throws EcDef{
        if (i < 0  || j < 0){
            throw new EcDef("分子分母不得為負數");
        } else {
            return i / j;
        }
    }
}

class EcDef extends Exception{
    static final long serialVersionUID = -3387516993124229948L;
    public EcDef(){}
    public EcDef(String msg){
        super(msg);
    }

}
