package HomeWorks.hw1.FamilyTree;

public class Node {



    public Node(Person person, Relationship re, Person relative) {
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    public Person getP1() {
        return p1;
    }
    public Person getP2() {
        return p2;
    }
    public Relationship getRe() {
        return re;
    }

    private final Person p1;//персона
    private final Relationship re; //родственное отношение
    private final Person p2;//родственник

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }



}
