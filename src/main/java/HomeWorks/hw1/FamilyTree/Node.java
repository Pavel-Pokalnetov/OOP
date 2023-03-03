package HomeWorks.hw1.FamilyTree;

public class Node {
    private  Person p1;//персона
    private  Relationship re; //родственное отношение
    private  Person p2;//родственник

    public Node( Person person, Relationship re, Person relative) {
        if (person==null || relative==null) return;
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }
    //геттеры
    public Person getP1() {
        return p1;
    }
    public Person getP2() {
        return p2;
    }
    public Relationship getRe() {
        return re;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

    /** является ли дочерним к relative
     * @param relative
     * @return
     */
    public boolean isCildren(Person relative){
        return (this.re==Relationship.children && relative.equals(this.p2));
    }

    /** является ли родителем для relativ
     * @param relative
     * @return
     */
    public boolean isParent(Person relative){
        return (this.re==Relationship.parent && relative.equals(this.p2));
    }

}
