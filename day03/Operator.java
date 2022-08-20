/*
Java Operator
1. 算術運算子(Arithmetic Operator): +、-、*、/、%(除完後取餘數)、++ (自己+1)、--(自己-1)
2. 指派運算子(Assignment Operator):  = 、 += (a +=2 --> a = a+2 )、 -= 、 *= 、 /=
3. 相等性及關係運算子 (Equality & Relational Operator): ==、 >、 <、 <=、 >=、 instanceof (檢查是否為class，output true and false)
4. 邏輯運算子 (Logical Operator，應用在true and false) : &、 &&、 |、 ||、 ! (非)、 ^ (異或)
   a & b,  對於：&   — >  不管怎樣，都會執行”&”符號左右兩邊的程式
   a && b, 對於：&& — >  只有當符號”&&”左邊程式為真(true)後，才會執行符號”&&”右邊的程式
   a | b, 對於: | — > 不管怎樣，都會執行右邊程式
   a || b, 對於: || — > 只有當左邊為false，才會執行右邊程式

   整體來說 && 與 || 效率較高!
   

5. 位元運算子 (Bitwise Operator，應用在整數上，基本上是移動bits): &、 |、 ~、 ^、 >>、 >>>、 <<  注意:沒有<<<
6. 三元運算子 (ternary operator): 
    格式:  (條件表達式, output為 true or false)? 表達式1 : 表達式2
    若條件表達式為 true則執行 表達式1; false 則執行表達式2
    ex.
    int k = (m>n) ? m : n; n與m的變數類型可以不同，但是要可以統一成相同的變數類型k

    另外，如果可以使用三元運算子，那麼一定可以換成if-else，反之不然!
    除外，三元運算子的效率式高於 if-else!

*/

/*
會自動指派回去的運算子，基本上都不會改變原變數的類型，效率較高，例如:
++, --, +=, -=, /=, %=, *=



*/

// javac -encoding UTF-8 D:\Java_lession\1_basic\code\day03\Operator.java
// java -classpath D:\Java_lession\1_basic\code\day03 Arithmetic
// java -classpath D:\Java_lession\1_basic\code\day03 Setvalue
// java -classpath D:\Java_lession\1_basic\code\day03 logicial
// java -classpath D:\Java_lession\1_basic\code\day03 Ternary

class Arithmetic {
    public static void main(String args[]){

        // 除法: /
        int i1 = 12;
        int i2 = 5;
        int i3 = i1 / i2;
        float d1 = (float)i1 / (float)i2;
        double d2 = i1 / (i2 + 0.0); // 0.0預設為double，故d2 也會自動轉double
        System.out.println(i3); // 只顯示整數
        System.out.println(d1); // 可顯示精確小數點
        System.out.println(d2); // 可顯示精確小數點第2位

       // ++ : 分成 b = a++ 與 b = ++a
       int a1 = 10;
       int b1 = ++a1; // b1 = ++a1  相當於 a1 = a1 + 1 再 b1 = a1 (先 進行加一 再 指派)
       System.out.println("a1 = " + a1 + "; " + "b1 = " + b1); //a1 = 11; b1 = 11

       int a2 = 10;
       int b2 = a2++; // b2 = a2++ 相當於 b2 = a2 再 a2 = a2 + 1 (先指派 再 加一)
       System.out.println("a2 = " + a2 + "; " + "b2 = " + b2);  // a2 = 11; b2 = 10

       int a3 = 20;
       ++a3;
       System.out.println("a3 = " + a3 ); // a3 = 21

       short s1_1 = 10;
       short s1_2 = 10;
       // s1_1 = s1_1 + 1 ; error，因為 1 是 int，因此s1_1 + 1會是int
       // s1_1 = short(s1_1 + 1); 通過!
       ++s1_1; // ++ 不會改變變數本身的類型!! 因此效率會比直接 +1 還要好 (因為不用轉換變數類型)
       s1_2++; //
       System.out.println("s1_1 = " + s1_1 ); // s1_1 = 11
       System.out.println("s1_2 = " + s1_2 ); // s1_2 = 11

       // 特殊狀況 1:
       byte bb1 = 127;
       ++bb1;
       System.out.println("bb1 = " + bb1 ); // bb1 = -128 !! 因為要維持8 bits! 因此127 = [0,1,1,1,1,1,1,1] + 1 = [1,0,0,0,0,0,0,0] = -128
        
    }
}

class Setvalue {
    public static void main(String args[]){

        // 指派方式1
        int i1 = 2;
        int j1 = 5;

        //指派方式2
        int i2, j2;
        i2 = j2 = 2;

        //指派方式3
        int i3 = 2, j3 = 5;

        // += 運算:
        short s1 = 12;
        // s1 = s1 + 2; error 
        s1 += 2; //通過! 因為 += 不會改變原變數的類型

        // 練習: 若想要另 int num = 10 進行 +2，有幾種方式?
        // 第一種: int num1 = 10 + 2;
        // 第二種: num += 2;
        // 第三種: num++; num++;





    }
}

class logicial {
    public static void main(String args[]){
        boolean  b1 = false;
        int num1 = 10;
        if (b1 & (num1++>0)){
            System.out.println("num1 = " + num1);
        } else {
            System.out.println("Else: " + "num1 = " + num1);
        }


        boolean b2 = false;
         int num2 = 10;
        if (b1 && (num2++>0)){
            System.out.println("num2 = " + num2);
        } else {
            System.out.println("Else: " + "num2 = " + num2);
        }


    }
}


class Ternary {
    public static void main(String args[]){

        // 獲取兩個整數的較大值
        int m = 12;
        int n = 5;
        int k = (m > n) ? m : n ;
        double k2 = (m > n) ? 2 : 0.001; 
        // String s = (m>2) ? 2 : "n大";  error，因為int 沒辦法直接轉string
        
        System.out.println("較大值 : " + k);
        System.out.println("較大值 : " + k2); // 表達式1 與 2 可以使用不同變數類型，但要可以轉過去!

       // 獲取三個整數中的最大值
       int t1 = 12;
       int t2 = 1;
       int t3 = -43;

       int t_max = (t1 > t2) ? t1 : t2;
       t_max = (t_max > t3) ? t_max : t3;
       System.out.println("最大值 : " + t_max); 
    

    }
}

