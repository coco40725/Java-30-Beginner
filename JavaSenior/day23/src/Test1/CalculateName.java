package Test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yu-Jing
 * @create 2022-07-27-PM 01:42
 */
public class CalculateName {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\Java_lession\\1_basic\\code\\JavaSenior\\day23\\src\\Test1\\StudentName.txt"));
        HashMap hashMap = new HashMap<>();

        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            str = str.split(" ")[0];

            if (hashMap.get(str) == null ){
                hashMap.put(str,1);
            }else if (hashMap.get(str) instanceof Integer){
                Integer num = (Integer) hashMap.get(str);
                hashMap.put(str, num + 1);
            }

        }
        System.out.println(hashMap);
    }
}
