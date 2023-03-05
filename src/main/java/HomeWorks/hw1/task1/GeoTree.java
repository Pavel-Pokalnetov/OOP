package HomeWorks.hw1.task1;

import java.util.ArrayList;

public class GeoTree {
    private final ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    /**
     * Отношения родитель <--> потомок
     * @param parent
     * @param children
     */
    public void append(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children)); //  parent родитель для children
        tree.add(new Node(children, Relationship.children, parent)); // children ребенок для parent %(
    }

    /**
     * Отношения супруг <-> супруга (партнер)
     * @param partner1
     * @param partner2
     */
    public void addPartner(Person partner1,Person partner2){
        tree.add(new Node(partner1,Relationship.partner,partner2));
        tree.add(new Node(partner2,Relationship.partner,partner1));

    }




}
