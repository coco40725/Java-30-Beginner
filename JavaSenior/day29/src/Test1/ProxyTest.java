/*
* 動態代理舉例: 僅創建 "被代理類 (可能有很多個)" 與 "用於製造代理類的類"，在執行期間，根據"被代理類"的類型來創建代理類與其對象
*
* 問題1: 如何根據加載到記憶體中的 "被代理類" 來創建 代理類 與其對象?
* 問題2: 當通過代理類的對象調用方法A時，如何動態的調用 "被代理類"中的同名方法A?
* */
package Test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yu-Jing
 * @create 2022-08-16-PM 03:39
 */
public class ProxyTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 1. 創建被代理類對象
        Superman superman = new Superman();

        // 2. 根據被代理類 創建 代理類對象
        Object proxyInstance = ProxyFactory.getProxyInstance(superman); // 可以看成 Object proxyInstance = new 代理類(含有interface)，

        //接著，我想調用代理類的中override interface的方法
        // 3. Object 強轉成 interface，才能調用
        Human proxyInterface = (Human) proxyInstance;

        String str = proxyInterface.getBelief();

        proxyInterface.eat("水果!"); // 代理類的interface method 是 寫成 "調用被代理類的method"
        System.out.println(str);

        System.out.println("*******************************************");

        // 以下體現 代理類產生器 的廣用性!!
        // 完全不同的 被代理類，也是使用"同一個代理類產生器"!
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        Object clothInstance = ProxyFactory.getProxyInstance(nikeClothFactory);
        ClothFactory clothInterface = (ClothFactory) clothInstance;
        clothInterface.productCloth();





    }
}

// interface
interface Human{
    String getBelief();
    void eat(String food);
}


class HumanUtil{
    public  void method1(){
        System.out.println("固定方法1");
    }

    public void method2(){
        System.out.println("固定方法2");
    }
}

// 被代理類
class Superman implements Human{

    @Override
    public String getBelief() {
        return "I AM STRONG!!";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜歡吃" + food);

    }
}

// 不創建代理類
// 創建 用來生產代理類的 一個 class
class ProxyFactory{

    // 通過此方法，返回代理類的對象
    public static Object getProxyInstance(Object obj) throws InstantiationException, IllegalAccessException { // obj 為 被代理類的對象
        MyinvocationHandler handler = new MyinvocationHandler(); // 需要引入 invoke()
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyinvocationHandler implements InvocationHandler{
    private Object obj; //需要使用被代理類的對象進行賦值
    public void bind(Object obj){
        this.obj = obj;
    }

    // 當我們通過 代理類的對象 調用 方法A時，便會自動調用以下的方法: invoke()
    // 將 被代理類 要執行的方法A，聲明在 invoke() 中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();

        util.method1();
        // 代理類對象所調用method，而 我們實質是調用  被代理類對象(obj)的method
       Object returnValue = method.invoke(obj,args);

        util.method2();
       return returnValue;
    }
}