 /*
 * 複習:
 * int p = 10;
 * char[] ch = {'a','b'};
 *
 * 1. function(...) 之 formal parameter p的類型
 *   a. primitive variable (傳遞實際值，僅更動 local variable 的值), 例如: function(int p) p+1;
 *
  *     a1. 在stack產生 "local variable" p = 10，然後對這個 p 進行操作 p + 1，
  *     a2. 此時 local variable p 變成 11。
 *      a3. 操作完畢，離開function，此時這個function所產生的 所有local variable (例如: p)，會刪掉
 *      a4. 由於 "member variable" p 沒被function動過，所以沒事，仍是10。
 *
 *  b. reference variable (傳遞地址值，並且更動此地址值的數據), 例如 function(char[] ch ) ch[0] = 'h';
  *      b1. 在stack中產生 "local variable" ch = 0x123456，並根據此地址值 至 Heap找對應的array 進行操作， ch[0] = 'h'
  *      b2. 此時 0x123456的array 會變成 {'h','b'}
  *      b3. 操作完畢，離開function，此時這個function所產生的 所有local variable (例如: ch)，會刪掉
  *      b4. 由於 0x123456的array  被function動過，故 ch = {'h','0'}
 *
 *
 *
 *
 *
 *
 *
 * */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-06-23-PM 02:00
 */
public class StringTest1 {
    String str = "good";
    int num11 = 10;
    int[] numa = {1,12};
    char[] ch = {'t','e','s','t'};

    public void change(String str1, char[] ch, int num, int[] inta){
        str1 = "test ok";
        ch[0] = 'b';
        num = num + 1;
        inta[0] = 123;

    }

    public static void main(String[] args) {
        StringTest1 ex = new StringTest1();
        ex.change(ex.str, ex.ch ,ex.num11, ex.numa);


        System.out.println(ex.str); // good, function 更動地址值對應的數據，"但是!!!"， String的特定為不變性，故 此地址值的數據不能變動，
                                    // 此case中，function是創在新的數據"test ok" + 新地址值 於string pool，然後function結束後，再刪掉string pool的"test ok"。

        System.out.println(ex.ch); // best, function 更動地址值對應的數據，更此array被變動
        System.out.println(ex.num11); // 10, function僅更動 local variable ， member variable 不會動
        System.out.println(ex.numa[0]); // 123, function 更動地址值對應的數據，更此array被變動
    }

}


