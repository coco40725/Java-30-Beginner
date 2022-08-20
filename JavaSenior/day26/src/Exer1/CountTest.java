package Exer1;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yu-Jing
 * @create 2022-08-08-AM 11:17
 */
public class CountTest {
    @Test
    public void test1(){
        FileReader fis = null;
        HashMap<String, Integer> map = null;
        try {
            fis = new FileReader("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day26\\testWrite.txt");
            char[] bchar = new char[20];
            map = new HashMap<>();
            int len;
            while( (len = fis.read(bchar)) != -1){
                for(Character c : bchar){
                    switch (c){
                        case ' ':
                            map.put("空格", map.getOrDefault("空格",0) + 1);
                            break;
                        case '\n':
                            map.put("換行", map.getOrDefault("換行",0) + 1);
                            break;
                        default:
                            map.put(c.toString(), map.getOrDefault(c.toString(),0) + 1);


                    }

                }
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
        }
        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry);
        }


    }
}
