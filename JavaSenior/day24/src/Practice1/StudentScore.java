/*
* 請把學生名與考試 分數錄入到集合中 ，並按分數顯示前三名成績學員的 名字 (成績 --> id --> 名字)。
* */
package Practice1;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @author Yu-Jing
 * @create 2022-07-27-AM 10:09
 */
public class StudentScore {
    public static void main(String[] args) {
        Student student = new Student("MeatBall", 52, 12);
        Student student1 = new Student("HE'S BACK", 98, 3);
        Student student2 = new Student("MUSHROOM", 75, 10);
        Student student3 = new Student("MEATBALL", 23,6);
        Student student4 = new Student("Tumble Rumble", 50,3);
        Student student5 = new Student("Jack", 60,47);

        TreeSet treeSet = new TreeSet();
        treeSet.add(student);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);

        int i = 0;
        for (Object o : treeSet){
            System.out.println(o);
            i++;
            if (i == 3) break;

        }


    }


}

class Student implements Comparable{
    private  String name;
    private int Score;
    private int id;

    public Student(String name, int score, int id) {
        this.name = name;
        Score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Score=" + Score +
                ", id=" + id +
                '}' ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Score, id);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student o_stu = (Student) o;
            if (Integer.compare(Score, o_stu.getScore()) == 0) {
              if (Integer.compare(id, o_stu.getId()) == 0) {
                  return name.compareTo(o_stu.getName());
              }
              return Integer.compare(id, o_stu.getId());
            }
            return - Integer.compare(Score, o_stu.getScore());
        }
        throw new RuntimeException("Wrong class type!");
    }
}