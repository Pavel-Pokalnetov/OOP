package HomeWorks.hw1.task1;

public class Main {
    public static void main(String[] args) {

        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        Person masha = new Person("Маша");
        Person jane = new Person("Женя");
        Person ivan = new Person("Ваня");
        Person anton = new Person("Антон");
        Person elena = new Person("Елена");
        Person gala = new Person("Галя");
        Person jura = new Person("Юра");

        GeoTree gt = new GeoTree();
        gt.addParent(irina, vasya);
        gt.addParent(irina, masha);

        gt.addParent(vasya, jane);
        gt.addParent(vasya, ivan);
        gt.addParent(vasya, anton);
        gt.addParent(elena, anton);
        gt.addPartner(vasya, elena);
        gt.addParent(elena, jane);
        gt.addParent(elena, ivan);
        gt.addParent(ivan, gala);
        gt.addParent(ivan, jura);
        gt.addParent(ivan, jura);

        new View(gt).viewParent(vasya);
        new View(gt).viewBrotherSister(vasya);
        new View(gt).viewPartners(vasya);
        new View(gt).viewChildren(vasya);
        new View(gt).viewBrotherSister(ivan);
        new View(gt).viewParent(ivan);

        for (Node t : gt.getTree()) {
            System.out.printf("%s %s %s %d\n",t.getP1().getFullName(),t.getRe(),t.getP2().getFullName(),t.hashCode());
        }

    }

}
