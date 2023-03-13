package HomeWorks.hw1.task2_3;

import java.util.Objects;

/**
 * базовый класс живых существ
 */
public abstract class BaseCreature implements CreatureAction,Comparable<BaseCreature> {

    String name;

    public BaseCreature(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    int age;
    Sex sex;
    int safety;
    int mood;
    Stage stage;

    String getName() {
        return name;
    }

    void metabolism() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.hashCode() == ((BaseCreature) o).hashCode();
    }

    /**
     * @param obg
     */
    @Override
    public void call(BaseCreature obg) {
        System.out.println(this.name + " зовет " + obg.getName());
        obg.reply();
    }

    /**
     * компаратор по умолчанию
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(BaseCreature o) {
        return this.age - o.getAge();
    }

    @Override
    public String toString() {
        return String.format("{%s (%s) %s}",this.name,this.sex,this.age);
    }
}
