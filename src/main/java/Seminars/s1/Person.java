package Seminars.s1;

import java.util.ArrayList;

public class Person {
    private String name;
    ArrayList<Person> family = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Person> getFamily() {
        return family;
    }

    public void setFamily(ArrayList<Person> family) {
        this.family = family;
    }

    public void appendToFamily(Person person) {
        if (person != this && person != null) {
            family.add(person);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
