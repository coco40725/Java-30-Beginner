/*
* 靜態代理舉例: 直接創建 代理類 與 被代理類，即 在編譯期間兩類都被確定下來。
* 換言之，10個被代理類 就要有 10個對應的代理類，如此非常繁瑣! 因此衍生出另一個做法: 動態代理。
* 動態代理的概念在於 編譯期間我們僅創建 多個"被代理類" 與 1個"用於製造代理類的類" ， 而code執行過程中，會根據你輸入的是什麼樣的 被代理類，
* 來創建對應的代理類。
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-08-16-PM 03:28
 */



public class StaticProxyTest {
    public static void main(String[] args) {
        // 1. 創建被代理類
        ClothFactory nikeClothFactory = new NikeClothFactory();

        // 2. 創建代理類
        ClothFactory proxtClothFactory = new ProxtClothFactory(nikeClothFactory);

        // 3. 調用方法
        proxtClothFactory.productCloth();
    }
}


// 代理類
class ProxtClothFactory implements ClothFactory{

    private ClothFactory factory; // 有實現此interface 之 被代理類



    public ProxtClothFactory(ClothFactory factory){
        this.factory = factory;
    };


    @Override
    public void productCloth() {
        System.out.println("代理工廠做一些準備工作!!");
        factory.productCloth(); // 調用此對象的productCloth()
        System.out.println("代理工廠做一些收尾工作!!");

    }
}

// 被代理類
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike生產一批衣服");
    }
}

interface ClothFactory{
    void productCloth();
}