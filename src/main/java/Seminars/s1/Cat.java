package Seminars.s1;

public class Cat extends Animal {
    private String name;


    public Cat(String name) {
        super("Кот");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String animalClass = super.toString();
        return animalClass + " " + this.name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//    public String voice() {
//        return "Кошка " + this.name + " говорит мяу";
//    }
}
