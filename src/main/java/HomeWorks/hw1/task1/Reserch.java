package HomeWorks.hw1.task1;

import java.util.ArrayList;
import java.util.PropertyPermission;

/*
 * Изменил типы возвращаемых данных у методов
 * добавил пару дополнительных
 */
public interface Reserch {
    /**
     * получить родителей
     *
     * @param person
     * @return
     */
    ArrayList<Person> getParents(Person person);

    /**
     * получить детей
     *
     * @param person
     * @return
     */
    ArrayList<Person> getChildren(Person person);

    /**
     * получить братьев и сестер
     *
     * @param person
     * @return
     */
    ArrayList<Person> getBrotherSister(Person person);

    /**
     * получить партнеров по браку (супруги)
     *
     * @param person
     * @return
     */
    ArrayList<Person> getPartners(Person person);

    /**
     * получить бабушек и дедушек
     *
     * @param person
     * @return
     */
    ArrayList<Person> getGrandParents(Person person);

    /**
     * получить родственников по типу родственной связи
     *
     * @param person - персона
     * @param rel    - тип родственной связи
     * @return - список родственников типа Person
     */
    ArrayList<Person> spend(Person person, Relationship rel);

    /**
     * получить всех предков
     */
    ArrayList<Person> getAllAncestors(Person person);

    /**
     * являются ли персоны родственниками
     */
    boolean isRelative(Person person1, Person person2);
}
