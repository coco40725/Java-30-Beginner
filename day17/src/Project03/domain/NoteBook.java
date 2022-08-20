package Project03.domain;

public class NoteBook implements Equipment{
   final private String model;
    final private double price;

    public NoteBook(String model, double price){
        this.price = price;
        this.model = model;
    }

    @Override
    public String deviceDescription() {
        return model + " (" + price + ")";
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

}
