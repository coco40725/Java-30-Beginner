/*
* UDP 的網路編程
*
*
*
* */
package Test3;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 10:39
 */
public class UDPTest {

    // 發送端
    @Test
    public void send(){

        DatagramSocket datagramSocket = null;
        try {
            String str = "這是垃圾訊息!";
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            // 1. 建立Socket，並將欲傳輸的內容與 IP 封裝到 DatagramPacket
            datagramSocket = new DatagramSocket();
            InetAddress inet =  InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,inet,9090);

            // 2. 通過Socket 將數據傳出去
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 3. 關閉socket
            try {
                if (datagramSocket != null){
                    datagramSocket.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }




    }

    // 接收端
    @Test
    public void receive(){
        DatagramSocket datagramSocket = null;
        try {
            // 1. 建立 Socket 並指定port
            datagramSocket = new DatagramSocket(9090);

            // 2. 建立空的datagramPacket
            byte[] bbyte = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(bbyte,0,bbyte.length);

            // 3. 使用 datagramSocket 接收
            datagramSocket.receive(datagramPacket);

            // 4. 將數據print出來
            System.out.println(new String(datagramPacket.getData(), 0,datagramPacket.getLength()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 5. 關閉通道
                if (datagramSocket != null){
                    datagramSocket.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



    }
}
