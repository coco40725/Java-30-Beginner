/*
 * 實現TCP的網路編程
 * 例子3: 客戶端發送文件給伺服器，伺服器將文件存在本地，並返回"成功接收" 給客戶端，最後關閉所有連接
 *
 * 為何這裡的客戶端需要使用 socket.shutdownOutput(); 來強制關閉? TCPTest2 卻不用呢?
 * 因為，TCPTest2 的客戶端是執行完 while(傳照片) 後，便直接關閉通道了，這個時候 伺服器有接收到訊息 "通道關閉，數據已傳完。"，
 * 此時伺服器 while(收照片) 才會跳脫迴圈往下執行。
 * 但是 TCPTest3 不同的點在於客戶端是執行完 while(傳照片) 後便卡在那裡等伺服器傳訊息，而伺服器那頭遲遲沒收到"數據已傳完" 這個訊息，
 * 導致伺服器 while(收照片) 卡住。因此我們需要讓客戶端強制關閉通道，以通知伺服器訊息已傳完。
 *
 * 會有這樣的原因是因為 read() 方法屬於阻塞式方法。
* */
package Test2;

import org.testng.annotations.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 09:30
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        InputStream inputStream = null;

        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,8787);
            os = socket.getOutputStream();

            fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\src\\Test2\\client.png");
            byte[] bbyte = new byte[1024];
            int len;

            while((len = fis.read(bbyte)) != -1){
                os.write(bbyte,0,len);
            }
            socket.shutdownOutput();

            // 接收來自伺服器的訊息，並顯示出來
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            bbyte = new byte[1024];
            while((len = inputStream.read(bbyte)) != -1){
                baos.write(bbyte,0,len);
            }
            System.out.println("伺服器回報: "+ baos.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fis != null){
                    fis.close();
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

            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (baos != null){
                    baos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }


    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socketFromClient = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            serverSocket = new ServerSocket(8787);
            socketFromClient = serverSocket.accept();
            is = socketFromClient.getInputStream();

            fos = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\src\\Test2\\server.png");

            byte[] bbyte = new byte[1024];
            int len;
            while((len = is.read(bbyte)) != -1){
                fos.write(bbyte,0,len);
            }

            // 傳訊息給客戶端
            OutputStream outputStream = socketFromClient.getOutputStream();
            outputStream.write( "已經收到文件了!".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (is != null){
                    is.close();
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
