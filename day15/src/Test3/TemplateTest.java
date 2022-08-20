/*
* 抽象類的應用: 模板設計
* 不確定的部分寫成abstract
*
* */
package Test3;


public class TemplateTest {
}

abstract class Template{
    public static void main(String[] args) {
        Template t = new subTemplate();
        t.spendTime();

    }

    // 確定的部分
    public void spendTime(){
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        System.out.println("Time " + (end - start) + " second");

    }

    abstract public void code(); // 不確定的部分 (不同的子類 其code會不同)，用abstract代替
}

class subTemplate extends Template{

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++){
            boolean is_Flag = true;
            for (int j = 2; j <= Math.sqrt(i); i++){
                if (i % j == 0){
                    is_Flag = false;
                    break;
                }
            }
            if (is_Flag == false){
                System.out.println(i);
            }
        }
    }
}