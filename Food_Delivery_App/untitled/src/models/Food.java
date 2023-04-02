package models;

public class Food extends Product{

    private Boolean isVegetarian;

    private Float weight;

    private int preparationTime;

    public Food(){

    }

    public Food(String name, String description, Float price, Boolean isVegetarian, Float weight, int preparationTime) {
        super(name, description, price);
        this.isVegetarian = isVegetarian;
        this.weight = weight;
        this.preparationTime = preparationTime;
    }

    public Boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(Boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        if (isVegetarian){
            return "Food{" +
                    "non-vegetarian" +
                    ", weight=" + weight +
                    ", preparationTime=" + preparationTime +
                    "} " + super.toString();
        } else {
            return "Food{" +
                    "vegetarian" +
                    ", weight=" + weight +
                    ", preparationTime=" + preparationTime +
                    "} " + super.toString();
        }
    }



}
