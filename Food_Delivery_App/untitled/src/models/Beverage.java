package models;

public class Beverage extends Product{

    private Float volume;

    private Boolean isAlcoholic;

    public Beverage(){

    }

    public Beverage(String name, String description, Float price, Float volume, Boolean isAlcoholic) {
        super(name, description, price);
        this.volume = volume;
        this.isAlcoholic = isAlcoholic;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Boolean getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(Boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    @Override
    public String toString() {
        if (isAlcoholic){
            return "Beverage{" +
                    "alcoholic" +
                    ", volume=" + volume +
                    "} " + super.toString();
        } else {
            return "Beverage{" +
                    "non-alcoholic" +
                    ", volume=" + volume +
                    "} " + super.toString();
        }
    }
}
