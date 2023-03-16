package HomeWorks.hw1.task2_3;

public class Dog extends BaseCreature {

    public Dog(String name, Sex sex, int age) {
        super(name, sex, age);
        this.safety = 100; //начальная сытость
        this.mood = 100; //начальное настроение
        this.stage = Stage.fun;
    }

    @Override
    public void speak() {
        System.out.println("Гав! Гав!");
    }

    @Override
    public void eat(Integer meal) {
        System.out.println(name +" поел(а) " + meal + " еды!");
    }

    @Override
    public void reaction() {
        System.out.println(name + " виляет хвостом.");
        speak();
    }

    @Override
    public void reply() {
        System.out.println(name +" подходит.");
        speak();
    }

}
