/*
* 對象的使用
* 1. ObjectInputStream 與 ObjectOutputStream
* 2. 作用: 用於存取或讀取 primitive variable 或 Class 的處理流
* 3. 如何使 Class 可以序列化?
*   (1) implements Serializable (較常用) 或 implements Externalizable
*  值得注意的是 Serializable 是屬於標示接口，也就是接口內部甚麼都沒寫，只是拿來標示用的
*   (2) 當前class需提供 static final long serialVersionUID，值正負隨意: 545121L 或 -41245L
*   (3) 保證內部 Field也需要可序列化，另外，primitive variable 可序列化。
*
* 4. 解釋serialVersionUID:
*    serialVersionUID可以看做是這個類的"標籤"，雖然JVM本身會自行根據Class的內容自行生成，但每更動一次class，這個號碼就會改。因此，
* 還是建議自行提供這個id。
*
*    範例1 : 不提供id ，系統自行生成
*           1. 序列化 Person class (系統生成 ID = 123L)，存在硬碟中
*           2. 修改 Person class， 系統生成 ID 也跟著變動為 256L。
*           3. 反序列化 (1) 的 Person class ，這時系統會去找 Person class + ID = 123L 的 Class，
*              這時發現找不到，因為 Person class ID更動了。
*
 *    範例2 : 提供id
 *           1. 序列化 Person class ，自行寫 ID = 123L，存在硬碟中
 *           2. 修改 Person class， ID 仍然是 123L。
 *           3. 反序列化 (1) 的 Person class ，這時系統會去找 Person class + ID = 123L 的 Class，
 *              找到 Person class + ID = 123L。
 *
 * 5. ObjectInputStream 與 ObjectOutputStream 不能序列化 static與 transient 所修飾的member variable，
 * 過程中不會報錯，但是那個variable的值不會存取，會直接存成預設值。 因此，如果你不想要序列化，可以可慮添加這個標籤。
* */
package Test1;

import org.testng.annotations.Test;

import java.io.*;

/**
 * @author Yu-Jing
 * @create 2022-08-09-AM 10:15
 */
public class InputOutputStreamTest {
    /*
    * 序列化過程: 將記憶體中的class 保存到硬碟中 或 通過網路傳輸。
      使用ObjectOutputStream 實現
    *
    * */

    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fis = new FileOutputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\TestClass.dat");
            oos = new ObjectOutputStream(fis);
            oos.writeObject(new String("FUCK YOU! 很酷!"));
            oos.writeObject(new Person("桃園",153,true));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null){
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    /*
    * 反序列化: 將硬碟中的class 讀進JVM, 即記憶體中。
    * 使用 ObjectInputStream 實現
    *
    *
    * */
    @Test
    public void test1(){
        ObjectInputStream ois = null;
        String str;
        try {
            FileInputStream fis = new FileInputStream("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day27\\TestClass.dat");
            ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            Object obj1 = ois.readObject();
            str = (String) obj;
            Person person = (Person) obj1;
            System.out.println(person);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(str);


    }
}
