/*
 * Java Objective
 * 1. Java 類別(class) 與其成員，成員包含: 屬性、方法、建構子 (這3者較常用); 代碼塊、內部類別
 * 2. 物件導向的特徵: 封裝性 (Encapsulation)、繼承性 (Inheritance )、多型性 (Polymorphism) ，有時候會有 抽象型
 * 3. 其他關鍵字: this, super, static, final, abstract, interface, package, import
 *
 * 物件導向程式 (Object Oriented Programming, OOP): 強調具備功能的對象，以類/對象為最小單位，考慮由哪個對象來執行此功能
 * 程序導向程式 (Process-oriented programming,POP ):強調功能 Function 行為，以函數為最小單位
 * 以下以 "人把大象裝冰箱" 為例來討論OOP與POP差異:
 * 1. POP:
 * a. 建一個function: 開冰箱
 * b. 建一個function: 把大象放進去
 * c. 建一個function: 關冰箱
 *
 * 2. OOP:
 * 首先先找出對象，並且決定好這個對象有甚麼功能
 * 對象:
 * 人 {
 *   打開(冰箱){
 *     冰箱.門開()
 *   }
 *   抬起 (大象){
 *      大象.進入(冰箱)
 *   }
 *   關閉(冰箱){
 *     冰箱.門關()
 *    }
 * }
 *
 * 冰箱 {
 *   門開(){}
 *   門關(){}
 * }
 *
 * 大象{
 *   進入(冰箱){
 *    }
 * }
 * -----------------------------------------------
 */

/*
* OOP 兩個要素:
* 1. 類: 對一事物的"描述"， 偏向抽象與概念上的定義，例如: 人
* 2. 對象: 確切存在的物件，稱為實例 (instance)，例如: 馬英九 (屬於類: 人)、蔡英文 (屬於類: 人)
* OOP的重點在於 "如何設計類? 且設計 類 有甚麼功能"，而屬於該類的 "對象" 皆有此功能
*
*
* */



package Lession;

public class OOP {

}
