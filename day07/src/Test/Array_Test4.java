package Test;
/*
* 1.建立array1 = {2, 3, 5, 7, 11, 13, 17, 19}
* 2. 建立array2 空的
* 3. 並顯示array 1 內容
* 4.  array2 = array1
* 5. 修改array2 偶數位置的元素為 0, 2, 4, 6, 8, 10,...
* 6. 再print一次 array1 內容
* 結果變成 array1 也跟著改了，變成跟array2一模一樣。 why? 因為array 1 與 array2 的記憶體位值相同!!!
* https://www.youtube.com/watch?v=VWKCltikDmI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=160
* 其實第4 step， 這裡是 把 array1的地址 給 array2 ，整個stack 只有一個 array!!! 這個操作不是所謂的"賦值" ，只是建立了快捷鍵
* 請問怎麼真正的複製array1 ? 請見 Array_Test5
* */


public class Array_Test4 {
    public static void main(String[] args) {

        // 建立 array 1 and array 2
        int[] arra1 = new int[]{2,3,5,7,11,13,17,19}; //
        System.out.println(arra1); // [I@16b98e56
        int[] arra2 = new int[8];
        System.out.println(arra2); // [I@7ef20235

        // print 出 array 1
        for (int i = 0; i< arra1.length ;i++ ) System.out.print(arra1[i] + " ");

        // 使 array2的值 等於  array1 (這一step是關鍵，他其實是把 array2的地址覆蓋成array1)
        arra2 = arra1;
        System.out.println(arra2); //[I@16b98e56 ，arra2地址變成arra1，由於[I@7ef20235消失，其對應的array亦消失

        // 修改array2 偶數位置的元素為 arra2[0] = 0, arra2[2] = 2, 4, 6, 8, 10,...
        System.out.println();
        for (int i = 0; i < arra1.length; i++) {
            if ( i % 2 == 0){
                arra2[i] = i;
            }
            System.out.print(arra2[i] + " ");
        }

        System.out.println();
        // print 出 array 1
        for (int i = 0; i< arra1.length ;i++ ) System.out.print(arra1[i] + " ");




    }
}
