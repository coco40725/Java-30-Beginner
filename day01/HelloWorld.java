/*
1. java 執行過程:
    a. 編寫: 創建 檔名.java 檔，並撰寫code
    b. 編譯: 使用javac.exe 對 檔名.java 進行解析，會ouput出 檔名.java 內所有的class，產生的文件副檔名為 .class   
    ex. javac -encoding UTF-8 D:\course_and_research\Java_lession\1_basic\code\day01\HelloWorld.java  [進行編譯，建立class，每一次更動都要重新編譯]

    c. 執行: 使用java.exe 執行 class檔
    ex.java -classpath D:\Java_lession\1_basic\code\day1 Okay  [用絕對路徑，執行class]
       java -classpath D:\Java_lession\1_basic\code\day1 notGood  [用絕對路徑，執行class]
       java notGood [先cd到有class的位置，然後再執行]
       java Okay [先cd到有class的位置，然後再執行]


2. 註解類型: 單列註解、多列註解、說明文件註解 
    a. 單列註解: 單列內輸入comment
    b. 多列註解: 範圍內輸入comment
    c. 說明文件註解: 範圍內輸入comment，且此區的註解內容是可以讓javadoc進行解析，然後output html文件檔資料夾，
    ex. javadoc -d [生成資料夾路徑] -author -version -encoding [UTF-8，optional] [xx.java的路徑]

3. Java 文件說明: https://docs.oracle.com/javase/8/docs/api/ 

4. java 可以創建複數個class, 但是只能創建 "1個" public class，因為public class 要求 該class的名稱與 java檔名相同，
   ex. HelloWorld.java 
       public class HelloWorld {..}

5. public static void main(String[] args): 程式碼的開頭，JVM的入口，java在執行時首先就是找main() function，然後""從main開始執行 (即使你main放在最後一行，他也是從那裏先執行!)"""
   a.  public: 權限為公開，你可以在其他class調用此function
   在 Java定義的關鍵字中，有3個存取修飾子：
       1. public : 任何狀況皆可調用，public myfunciton() {.....}，接著你可以在其他class中直接調用myfunciton()     
       2. protected: 不同套件的類別中，僅限該類別的子類別可以存取。 是這4種權限中開放範圍第二大的
       3. (預設): 如果沒有寫任何修飾子，就是這種權限，有些人會稱這種權限為 package。 因為在同一個package內的類別都可以存取，不同套件存取不到
       4. private: 只能在當前class中使用
       protected: 不同套件的類別中，僅限該類別的子類別可以存取。 是這4種權限中開放範圍第二大的

   b. static: 在程式載入記憶體的時候，跟著程式一起在記憶體中佔有空間，而不是主程式開始執行後才跟記憶體要空間，當這個vairable 很常使用時，建議可以用static
   c. void: 返回值的屬性, void代表不要返回值
   d. String[] args: 參數(args)儲存格式為string，且參數數目隨意; 
                     當然這部分你也可以不用這樣定，可以根據function狀況來決定你的參數要以哪種格式儲存，
                     只是string比較泛用。

6. 每一行都要以  ;   做結尾!!!!!

7. System.out.print("文字"): 輸出文字
   System.out.println("文字"): 輸出文字後，換行


Q 常見問題:
a. 如果有時候出現中文亂碼，不能編譯的時候，可以使用 javac -encoding UTF-8，此問題可能是VS code的問題
b. Could not find or load main class: 通常是classpath 指定有問題，如果classpath沒有設定環境變數的話，預設是當前路徑 (https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean)

 */





/**
@author YEE
@version 1.0
java 測試版，此區的註解內容是可以讓javadoc進行解析，然後output html文件檔
 */


class notGood { 
    /**
    此處的內容亦可讓 javadoc 解析出來喔!
     */
    
    public static void main(String[] args){
        System.out.println("Hello World!"); 
    }
}

class Okay {
    public static void main(String[] args){
    
        System.out.println("YEE");
    }
}

public class HelloWorld{
    public static void main(String[] args){
    
        System.out.println("YEE");
    }
}