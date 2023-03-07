package HomeWorks.hw1.task1;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Класс дерева узлов Node
 * Здесь нужно ввести проверку на null для person
 * Так же нужны методы для удаления связей Node, например при редактировании.
 * <p>
 * Еще мысль сделать один общий метод для добавления связей между "человеками",
 * но пока не домыслил, как это сделать, ведь у нас по сути 2 связи (прямая и обратная)
 * т.е. для связи paretn-children связи разные
 * а для partner-partner связи одинаковые...
 */
class GeoTree {
    private final HashSet<Node> tree = new HashSet<>();

    public HashSet<Node> getTree() {
        return tree;
    }

    /**
     * Отношения родитель <--> потомок
     *
     * @param parent   - родитель
     * @param children - потомок
     */
    public void addParent(Person parent, Person children) {
        if (checkPerson(parent, children)) { //нельзя добавлять null
            return;
        }
        tree.add(new Node(parent, Relationship.parent, children)); //  parent родитель для children
        tree.add(new Node(children, Relationship.children, parent)); // children ребенок для parent %(

    }

    /**
     * Отношения супруг <-> супруга (партнер)
     *
     * @param partner1 - первый супруг(а)
     * @param partner2 - второй супруг(а)
     */
    public void addPartner(Person partner1,Person partner2){
        if (checkPerson(partner1,partner2))return;
        tree.add(new Node(partner1,Relationship.partner,partner2));
        tree.add(new Node(partner2,Relationship.partner,partner1));

    }

    /**
     * Проверка персон на null
     *
     * @param person1 - исходные персоны
     * @param person2 - исходные персоны
     * @return - true(если есть null)
     */
    private boolean checkPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null);
    }
}
