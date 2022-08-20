/*
* 1.Package
* a. 主要用於管理多個 class，相同類型的class會擺在同一個 package
* b.package 必須最先寫出來
* c. 每一個"." 代表一層文件，例如: java.good.abc --> 實際路徑: java/good/abc
* d. 同一個 package 不能有同名class
* e. 不同package 則可以用同名 class
*
* 2. Import
* a. 在源文件中，導入指定package下的 class 或 Interface
* b. import 寫在 package 下面，若需要多個，則一列一列的寫出來
* c. java.lang.* 是預設就有，不用特別import; 注意: * 代表的是 "任意 class or interface"，換言之，
*   如果路徑是 java/lang/foo/class1 則 class1 還是需要用import再調一次: java.lang.foo.*
* d. 如果使用的 class 或 interface 是在 當前package下，則不用import，直接調用
* e. 如果想要import 兩個同名的class (不同package) 怎麼辦? 這時候就必須把 完整類名附上
* f. import static java.lang.System.*; 這裡"*"代表的是 System class 下的 任一結構: 屬性 方法 結構子
*
* */
package Lession;

import Exercise2.Account;

import java.util.Arrays;
import java.util.HashMap;
// 這裡也可以使用 java.util.*; 代表可以import java.util下的所有結構

public class Package_Import {
    HashMap aa = new HashMap();
    Account as1 = new Account(23);
    Exercise1.Account as33 = new Exercise1.Account(12,20,32);
}


