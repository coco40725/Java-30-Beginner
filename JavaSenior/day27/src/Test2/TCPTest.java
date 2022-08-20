/*
* 實現TCP的網路編程
* 例子1: 客戶端發送訊息給伺服器，伺服器將訊息顯示出來
*
* */
package Test2;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 08:35
 */
public class TCPTest {

    // 客戶端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;

        try {
            // 1. 填入欲 連接的伺服器 IP 或 域名
            InetAddress inet = InetAddress.getByName("127.0.0.1");

            // 2. 填入欲 連接的 伺服器其InetAddress 與 其port number
            socket = new Socket(inet,8899);

            // 3. 使用socket建立通道
            os = socket.getOutputStream();

            // 4. 輸出訊息
            os.write("客戶端發送了訊息!".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 5. 關閉通道與 socket
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    // 伺服器
    @Test
    public void sever(){
        ServerSocket serverSocket = null;
        Socket socketFromClient = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            // 1. 指明欲開放連接的port
            serverSocket = new ServerSocket(8899);

            // 2. 接收來自客戶端的Socket
            socketFromClient = serverSocket.accept();

            // 3. 接受後，建立輸入通道
            inputStream = socketFromClient.getInputStream();

            // 4. 將數據挖出來
            // 不建議以下的寫法，當有中文時容易有亂碼 (中文一個字 要用3 bytes 去表示，會有中文字被批兩半的問題)
//        byte[] bbyte = new byte[20];
//        int len;
//        while((len = inputStream.read(bbyte)) != -1){
//            System.out.println(new String(bbyte,0, len));
//        }
            // 使用 ByteArrayOutputStream，他會先把數據讀入的數據存在 Array中，全讀完後再拼接起來。
            byte[] bbyte = new byte[4];
            int len ;
            baos = new ByteArrayOutputStream();
            while((len = inputStream.read(bbyte)) != -1){
                baos.write(bbyte,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("來自: " + socketFromClient.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 5. 關閉通道
            try {
                if (baos != null){
                    baos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (socketFromClient != null){
                    socketFromClient.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
