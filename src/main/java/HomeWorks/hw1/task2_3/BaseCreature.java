package HomeWorks.hw1.task2_3;

/**
 * базовый класс живых существ
 */
public abstract class BaseCreature implements CreatureAction {

    String name;
    int age;
    Sex sex;
    int safety;
    int mood;
    Stage stage;

    String getName(){
        return name;
    }

}
