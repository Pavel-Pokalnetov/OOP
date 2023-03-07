package HomeWorks.hw1.task1;

class Node {
    private Person p1;//персона
    private Relationship re; //родственное отношение
    private Person p2;//родственник

    public Node(Person person, Relationship re, Person relative) {
        if (person == null || relative == null) return;
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    //геттеры
    public Person getP1() {return p1;}
    public Person getP2() {return p2;}
    public Relationship getRe() {return re;}

    @Override
    public String toString() {
        return String.format("<%s(%s)-> %s>", p1, re, p2);
    }

    /**
     * переопределение HashCode для унакальности от p1.name,p2.name и pe
     * так мы можеи проверять ноды на уникальность по этим трем полям
     */
    @Override
    public int hashCode(){
       StringBuilder hash = new StringBuilder();
       hash.append(this.p1.getFullName().hashCode());
       hash.append(this.p2.getFullName().hashCode());
       hash.append(this.re.hashCode());
       return hash.hashCode();
    }
}
