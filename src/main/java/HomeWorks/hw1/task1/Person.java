package HomeWorks.hw1.task1;

public class Person {
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
