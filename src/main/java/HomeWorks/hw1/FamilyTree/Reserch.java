package HomeWorks.hw1.FamilyTree;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashSet;

public class Reserch {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    /**
     * Получить родственников person с отношением rel
     *
     * @return - список Person
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
     * Получить родителей person
     *
     * @param person
     * @return
     */
    public ArrayList<String> getChildren(Person person) {
        for (Node n: this.tree) {
                if (n.getP1().equals(person) && n.getRe()==Relationship.children){
                    result.add(n.getP2().getFullName());
                }
            }

        return result;
    }


    /** Получить братьев и сестер
     * @param person
     * @return
     */
    public  void getBrotherSister(Person person){
        ArrayList<Person> parents = new ArrayList<>();

        for (Node parent: this.tree){//собираем список родителей
            if (parent.getRe()==Relationship.parent && parent.getP2().equals(person) ){
                parents.add(parent.getP1());// в parents получили список родителей
            }
        }
        HashSet<Person> brother_sister = new HashSet<>();
        for (Node t: this.tree) {
            if (t.getP1().equals())
        }
        }



}

