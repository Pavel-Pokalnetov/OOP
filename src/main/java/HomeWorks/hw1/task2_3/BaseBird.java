package HomeWorks.hw1.task2_3;

public abstract class BaseBird implements Flying {
    boolean stateFly;
    int speedFly;
    int heightFly;

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
        if (isInFly()){
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
        stateFly=true;
    }

    /**
     *
     */
    @Override
    public void stopFly() {
        stateFly=false;
    }
}
