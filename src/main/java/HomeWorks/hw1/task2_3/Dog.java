package HomeWorks.hw1.task2_3;

public class Dog extends BaseCreature{
    @Override
    public void speak() {
        System.out.println("Гав! Гав!");
    }

    @Override
    public void eat(Integer meal) {
        System.out.println("Собака поела "+meal+" еды!");
    }

    @Override
    public void reaction() {

    }

    @Override
    public void reply() {

    }

    @Override
    public void metabolizm(){}

}
