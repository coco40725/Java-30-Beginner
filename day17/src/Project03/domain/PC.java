package Project03.domain;

public class PC implements Equipment {
    final private String model;
    final private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String deviceDescription() {
        return model + " (" + display + ")";
    }

    public String getModel() {
        return model;
    }


    public String getDisplay() {
        return display;
    }

}
