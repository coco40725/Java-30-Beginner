/*
* A. 枚舉類的使用
*   1. 當有一個類，其"對象" 是有限多且可數，我們稱其為枚舉類。
*   2. 當需要定義"一組常量"時，建議使用枚舉類
*   3. 若枚舉類中，只有一個對象，則可以考慮單例模式
*
* B. 如何定義枚舉類
*   1. JDK 5.0前 必須自定義枚舉類，步驟:
*      - 1. 自訂 private final field
*      - 2. private constructor
*      - 3. 枚舉出所有對象，且為 public final static
*      - 4. 額外需求
*
*   2. JDK 5.0後，使用enum來定義 (An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables))
*       - 1. 自訂 private final field
*       - 2. private constructor
*       - 3. 一定要寫在最前面! 枚舉出所有對象，對象之間用"，"區隔開來，結束後用"；"
*       - 4. 額外需求
*  enum  是繼承 Enum，而ENUM有override toString method，默認是print出對象名稱
* ---------------------------------------------------------------------------------------------------------
* C. Enum 常見的方法:
*  1. values(): 返回枚舉類的對象名稱數組，可用於遍歷所有枚舉對象
*  2. valueOf(String str): 根據str調出這個同名對象，若找不到，則會報錯:java.lang.IllegalArgumentException
*  3. toString(): print出當前枚舉類對象之名稱
*
* D. 使用 enum 來實現interface 的情況:
*    情況一: 直接用implement interface，然後把abstract method override 即可 (跟一般的class用法一樣)
*    情況二: 在對象的層次上，把abstract method override，換言之，不同對象，調出來的方法會有差!
*            SPRING(){
*               @override
*               .....
*            },
* */
package Test1;

/**
 * @author Yu-Jing
 * @create 2022-07-05-PM 02:23
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        // Enum: 展示toString()
        System.out.println(Season_enum.SUMMER);
        System.out.println("*******************************");

        // Enum: 展示values()
        Season_enum[] season_arr = Season_enum.values();
        for (int i = 0 ; i < season_arr.length; i ++){
            System.out.println(season_arr[i]);
        }
        System.out.println("*******************************");
        Thread.State[] states = Thread.State.values();
        for (int i = 0; i< states.length; i++){
            System.out.println(states[i]);
        }
        System.out.println("*******************************");

        //  Enum: valueOf(String str)
        Season_enum winter = Season_enum.valueOf("WINTER");
        System.out.println(winter);

        Season_enum.SUMMER.show();
    }

}
// 自定義枚舉類
class Season{

    // 1. 自訂 private final field
    private final String seasonName;
    private final String seasonDesc;

    // 2. private constructor
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 枚舉出所有對象，且為public final static
    public final static Season SPRING = new Season("春天","春暖花開");
    public final static Season SUMMER = new Season("夏天","夏日炎炎");
    public final static Season AUTUMN = new Season("秋天","秋高氣爽");
    public final static Season WINTER = new Season("冬天","冰天雪地");


    // 4. 額外需求: 可以get其field value

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    //4. 額外需求: toString

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


interface Info{
    public abstract void show();
}

// 使用enum來定義
enum Season_enum implements Info {

    // 3. 一定要寫在最前面! 枚舉出所有對象，對象之間用"，"區隔開來，結束後用"；"
    SPRING("春天","春暖花開"){
        @Override
        public void show() {
            System.out.println("這是春天! 櫻花");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("這是夏天! 去游泳");
        }
    },
    AUTUMN("秋天","秋高氣爽"){
        @Override
        public void show() {
            System.out.println("這是秋天! 楓葉");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("這是冬天! 來去滑雪");
        }
    };

    // 1. 自訂 private final field
    private final String seasonName;
    private final String seasonDesc;

    // 2. private constructor
    private Season_enum(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 額外需求: 可以get其field value
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


//    // 情況一:
//    @Override
//    public void show() {
//        System.out.println("這是一個季節 YEE!");
//    }
}

