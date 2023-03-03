package HomeWorks.hw1.FamilyTree;

public class Node {

    public Person getP2() {
        return p2;
    }

    public Node(Person person, Relationship re, Person relative) {
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    public Person getP1() {
        return p1;
    }

    public Relationship getRe() {
        return re;
    }

    private Person p1;//персона
    private Relationship re; //родственное отношение
    private Person p2;//родственник

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }


}
