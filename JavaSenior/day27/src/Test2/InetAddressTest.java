/*
* 一、網路編程主要的兩個問題
* 1. 如何準確地定位網路上一台或多台主機; 如何定義主機上的特定應用
* 2. 找到主機後如何高效地進行數據傳輸
*
* 二、網路編程的兩個要素
* 1. 對應問題一: IP 與 端口號
* 2. 對應問題二: 網路通信協議: TCP/IP 參考模型 (應用層、傳輸層、網路層、物理+數據鏈路層)；每一詞都有具體的協議
*
*
* 三、通信要素一: IP 與 端口號
*  1. IP : 唯一的標示 internet 上的計算機 (通信實體)
*  2. 在 Java中使用 InetAddress 類來代表IP
*  3. IP分類: IPv4 與 IPv6 ; 公用網路/私有網路
*  4. 域名: https://tw.yahoo.com/
*  5. 本機IP: 127.0.0.1 對應著 localhost (類似域名)
*  6. 如何實例化InetAddress ?
*     - InetAddress 的 constructor為 private ，無法直接創立對象
*     - static method: InetAddress.getByName(String str); str可以是 IP 或 域名
*     - static method: InetAddress.getLocalHost(); 直接抓本機IP
*     - getHostName(): 獲取該對象的域名
*     - getHostAddress(): 獲取該對象的IP
*
*  7. 端口號(Port) : 正在電腦上運行的進程，不同的進程會對應不同的port，規定是一個16位元的整數 0~65535；
*  8. 端口分類: 公認端口(0~1023，給服務器通信使用) / 註冊端口 (1024~49151) / 動態or私有端口 (49152 ~ 65535)
*  9. 端口號 與 IP 組合 會得到 Socket
* */
package Test2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Yu-Jing
 * @create 2022-08-10-AM 10:33
 */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inet1 = null;
        InetAddress inet2 = null;
        InetAddress inet3 = null;
        InetAddress inet4 = null;


        try {
            inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            inet2 = InetAddress.getByName("tw.yahoo.com"); // 域名 --> DNS解析IP --> 回傳IP
            System.out.println(inet2);

            inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
