/*
* 使用同步機制將 懶漢式 改為安全thread!
*
*
* */
package Test2;

/**
 * @author Yu-Jing
 * @create 2022-06-17-PM 02:07
 */
public class BankTest {
}

class Bank{
    private Bank(){}

    private static Bank bank = null;

    public static  Bank getInstance(){
        // 方法1: 效率較差
//        synchronized (Bank.class) {
//            if (bank == null)  bank = new Bank();
//            return bank;
//        }

        // 方法2 : 效率高，只有一部分的threads需要等一下，其它thread會因為第一個if（bank == null）　而直接離開，不會阻塞
        if (bank == null) {
            synchronized (Bank.class) {
            if (bank == null)  bank = new Bank();
            }
        }
        return bank;

    }
}