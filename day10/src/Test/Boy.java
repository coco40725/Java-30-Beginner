package Test;

public class Boy {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry (Girl girl){
        System.out.println("想娶 " + girl.getName());

    }

    public void shout (){
        if (this.age >= 22){
            System.out.println("可以結婚");
        } else {
            System.out.println("只能談戀愛");
        }
    }

}
