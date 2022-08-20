/*
* Proxy Template
* */
package Test5;

public class NetWorkTest {
    public static void main(String[] args) {
        Sever sever = new Sever();
        ProxySever proxy = new ProxySever (sever); // 多態性
        proxy.browse();
    }

}

interface Network{
    abstract public void browse();

}

// 被代理類
class Sever implements Network{

    @Override
    public void browse() {
        System.out.println("Sever 訪問網路");
    }
}

// 代理類: 執行被代理類域執行的事情
class ProxySever implements Network{
    private Network work;
    public ProxySever(Network work){
        this.work = work;
    }
     public void check(){
         System.out.println("檢查是否可已連線");
     }
    @Override
    public void browse() {
        check();
        work.browse();
    }

}