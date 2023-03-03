package HomeWorks.hw1.FamilyTree;

import java.util.Calendar;

public class Person {
    private enum Sex {
        man, woman, none
    }

    private String fullName;
    private Sex sex;


    public Person(String fullName) {
        this(fullName, Sex.none);
    }

    public Person(String fullName, Sex sex) {
        this.fullName = fullName;
        this.sex = sex;
    }

    public String getFullName() {
        return fullName;
    }

}
