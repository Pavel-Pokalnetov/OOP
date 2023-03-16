package HomeWorks.hw1.task2_3;

public abstract class BaseBird extends BaseCreature implements Flying {
    boolean stateFly;
    int speedFly;
    int heightFly;

    public BaseBird(String name, Sex sex, int age) {
        super(name, sex, age);
    }


    /**
     * @return
     */
    @Override
    public boolean isInFly() {
        return stateFly;
    }

    /**
     * @return
     */
    @Override
    public int getFlySpeed() {
        if (isInFly()) {
            return speedFly;
        }
        System.out.println("Птица не в полете");
        return 0;
    }

    /**
     *
     */
    @Override
    public void startFly() {
        stateFly = true;
    }

    /**
     *
     */
    @Override
    public void stopFly() {
        stateFly = false;
    }

    /**
     *
     */
    @Override
    public void speak() {
        System.out.println("Кто там?");
    }

    /**
     * @param meal
     */
    @Override
    public void eat(Integer meal) {
        System.out.println(name + " поел(а)");
    }

    /**
     *
     */
    @Override
    public void reaction() {
        System.out.println("Кто там?");
    }

    /**
     *
     */
    @Override
    public void reply() {
        System.out.println("Кто там?");
    }
}
