package Seminars.s1;

public class Animal {
    private String model;

    public Animal(String model) {
        this.model = model;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model;
    }

    public String voice() {
        return "Животное говорит";
    }
}