package HomeWorks.hw1.FamilyTree;

import java.util.ArrayList;

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

    /** Получить детей
     * @param person
     * @return
     */
    public ArrayList<String> getChildren(Person person) {
        ArrayList<String> result = new ArrayList<>();



        return result;
    }

}
