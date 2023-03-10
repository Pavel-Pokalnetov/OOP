package HomeWorks.hw1.task1;

public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина",Sex.woman,"12.07.1934");
        Person vasya = new Person("Вася",Sex.man,"07.05.1957");
        Person elena = new Person("Елена",Sex.woman,"15.06.1959");
        Person masha = new Person("Маша",Sex.woman,"14.06.1960");
        Person jane = new Person("Женя",Sex.woman,"03.07.1981");
        Person ivan = new Person("Ваня",Sex.man,"23.11.1983");
        Person anton = new Person("Антон",Sex.man,"13.07.1986");

        Person gala = new Person("Галя",Sex.woman,"15.12.2008");
        Person jura = new Person("Юра",Sex.man,"05.03.2013");

        GeoTree gt = new GeoTree();

        gt.addParent(irina, vasya);
        gt.addParent(irina, masha);

        gt.addPartner(vasya, elena);
        gt.addParent(vasya, jane);
        gt.addParent(elena, jane);
        gt.addParent(vasya, ivan);
        gt.addParent(elena, ivan);
        gt.addParent(vasya, anton);
        gt.addParent(elena, anton);

        gt.addParent(ivan, gala);
        gt.addParent(ivan, jura);

        new View(gt).viewParent(vasya);
        new View(gt).viewBrotherSister(vasya);
        new View(gt).viewPartners(vasya);
        new View(gt).viewChildren(vasya);
        new View(gt).viewBrotherSister(ivan);
        new View(gt).viewParent(ivan);
//        new View(gt).viewAllData();


    }
}
