package Test4;

/**
 * @author Yu-Jing
 * @create 2022-07-04-PM 03:52
 */
public class Gooods implements Comparable{
    private String name;
    private double price;

    public Gooods() {
    }

    public Gooods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gooods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // 自行定義Gooods的排序方式: 根據價格從低到高排序，再按照產品名稱排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Gooods){
            Gooods goods = (Gooods) o;
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else {
                return this.name.compareTo(goods.name);
            }
           // 或 return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("Invaild data type!");

    }
}
