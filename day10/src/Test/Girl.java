package Test;

public class Girl {
    private String name;
    private int age;

    public Girl(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry (Boy boy){
        System.out.println("想嫁給 " + boy.getName());
        boy.marry(this); // this 當前對象
    }

    /**
     * 比較兩個對象大小
     * @param girl
     * @return 正數 代表當前較大， 負數，當前對象較小
     */
    public  int compare (Girl girl){
          return this.age - girl.age;
    }


}
