package HomeWorks.hw1.FamilyTree;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * В этом классе есть смысл сменить типы возвращаемых результатов на ArrayList<Persons>
 * в таком случае мы можем получать дополнительные данные из этого списка или вторично обрабатывать
 * полученные значения
 * ArrayList<String> в нашем случае сильно ограничивает повторное использование
 * полученных данных, т.к. они уже не уникальны и не дают возможность использовать в рекурсивных отборах
 */
public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    /**
     * Получить родственников person с отношением rel
     * *@return - список Person
     */
    public ArrayList<String> spend(Person person, Relationship rel) {
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(person.getFullName()) && t.getRe() == rel) {
                result.add(t.getP2().getFullName());
            }
        }
        return result;
    }

    /**
     * Получаем родителей person
     *
     * @param person .
     * @return список имен родителей
     */
    public ArrayList<String> getParents(Person person) {
        return spend(person, Relationship.children);
    }

    /**
     * Получаем всех детей person
     *
     * @param person .
     * @return - список имен детей
     */
    public ArrayList<String> getChildren(Person person) {
        return spend(person, Relationship.parent);
    }

    /**
     * Получить братьев и сестер
     *
     * @param person .
     * @return - список имен братьев и сестер
     */
    public ArrayList<String> getBrotherSister(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : this.tree) {//собираем список родителей
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);// в parents получили список родителей
                if (parents.size() > 1) break;
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {// находим всех братьев и сестер
            for (Node t : this.tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.parent && //если отношение -> родитель
                        !t.getP2().equals(person)) {//кроме самого person
                    brother_sister.add(t.getP2());
                }
            }
        }
        for (Person p : brother_sister) {
            result.add(p.getFullName());
        }
        return result;

    }

    /**
     * Получить партнеров по браку
     *
     * @param person .
     * @return - возвращает партнеров по браку (муж/жена)
     */
    public ArrayList<String> getPartners(Person person) {
        return spend(person, Relationship.partner);
    }
}

