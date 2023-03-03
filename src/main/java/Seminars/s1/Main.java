package Seminars.s1;

public class Main {

    public static void main(String[] args) {
//        Animal anotherCat = new Cat("Мурка");
//        System.out.println(anotherCat.voice());

        Person first = new Person("Вася");
        Person second = new Person("Миша");
        Person third = new Person("Маша");


        first.appendToFamily(second);
        first.appendToFamily(third);
        first.appendToFamily(null);

        view(first);
    }

    public static void view(Person rootPerson) {
        System.out.println(rootPerson);
        for (Person person : rootPerson.getFamily()) {
            view(person);
        }
    }
}
