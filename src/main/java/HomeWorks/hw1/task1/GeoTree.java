package HomeWorks.hw1.task1;

import java.util.ArrayList;

/**
 * Класс дерева узлов Node
 * Здесь нужно ввести проверку на null для person
 * к тому же есть недочеты с хранением данных: у нас нет никакой защиты от дублирования Node,
 * а они должны быть уникальны, для такого случая можно использовать вместо ArrayList<Node> коллекцию HashSet<Node>
 * тогда мы автоматически исключим дубликацию данных
 * <p>
 * Так же нужны методы для удаления связей Node, например при редактировании.
 * <p>
 * Еще мысль сделать один общий метод для добавления связей между "человеками",
 * но пока не домыслил, как это сделать, ведь у нас по сути 2 связи (прямая и обратная)
 * т.е. для связи paretn-children связи разные
 * а для partner-partner связи одинаковые...
 */
class GeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
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
//      Возможно понадобится метод добавления персоны без связи с другими...
//    public void addPersonOne(Person person){
//        tree.add(new Node(person,null,null));
//    }


    /**
     * Замена потомка (для редактирования)
     *
     * @param person      - редактируемый перс
     * @param newChildren - новый потомок
     * @param oldChildren - заменяемый потомок
     * @return - результат выполнения boolean
     */
    public boolean replaceChildren(Person person, Person newChildren, Person oldChildren) {
        if (checkPerson(person, newChildren)) return false;
        for (Node t : tree) {
            if (t.getP1().equals(person) &&
                    Relationship.children == t.getRe() &&
                    t.getP2().equals(oldChildren)) {
                t.setP2(newChildren);
                return true;
            }
        }
        return false;
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
