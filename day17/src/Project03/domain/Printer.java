package Project03.domain;

public class Printer implements Equipment{
    final private String name;
    final private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String deviceDescription() {
        return name + " (" + type + ")";
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


}
