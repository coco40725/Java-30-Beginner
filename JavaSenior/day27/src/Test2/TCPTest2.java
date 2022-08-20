/*
 * 實現TCP的網路編程
 * 例子2: 客戶端發送文件給伺服器，伺服器將文件存在本地
* */
package Test2;

import org.testng.annotations.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 09:12
 */
public class TCPTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
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

            System.out.println( "來自 " + socketFromClient.getInetAddress().getHostAddress() + "接收成功!");
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
