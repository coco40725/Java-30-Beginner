/*
* URL 網路編程
* 1.  URL:統一資源定位符，對映著網路上某一段的資源地址
* 2. 格式:
* http://localhost:8080/examples/hello.txt?username=Tom&password=123
*  a. 協議: HTTP、HTTPS
*  b. 主機名 或 IP
*  c. port
*  d. 資源位址
*  e. 參數列表: ?username=Tom&password=123
*     參數列表的格式: ?參數名=參數值&參數名=參數值&....
*
* */
package Test4;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Yu-Jing
 * @create 2022-08-11-AM 11:02
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/hello.txt?username=Tom&password=123");

        // getProtocol(): 獲取協議
        System.out.println(url.getProtocol());

        // getHost(): 獲取主機名
        System.out.println(url.getHost());

        // getPort: 獲取port number
        System.out.println(url.getPort());

        // getPath: 獲取文件路徑
        System.out.println(url.getPath());

        // getFile: 獲取文件名
        System.out.println(url.getFile());

        // getQuery: 獲取參數列表
        System.out.println(url.getQuery());


    }
}
