package HomeWorks.hw1.task1;

public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", Sex.woman, "12.07.1934");
        Person nikolay = new Person("Николай", Sex.man, "28.11.1929");
        Person vasja = new Person("Вася", Sex.man, "07.05.1957");
        Person elena = new Person("Елена", Sex.woman, "15.06.1959");
        Person masha = new Person("Маша", Sex.woman, "14.06.1960");
        Person jane = new Person("Женя", Sex.woman, "03.07.1981");
        Person ivan = new Person("Ваня", Sex.man, "23.11.1983");
        Person anton = new Person("Антон", Sex.man, "13.07.1986");
        Person gala = new Person("Галя", Sex.woman, "15.12.2008");
        Person jura = new Person("Юра", Sex.man, "05.03.2013");
        Person jan = new Person("Ян", Sex.man, "03.03.1940");
        Person anna = new Person("Анна", Sex.woman, "24.06.1938");
        Person sonya = new Person("Соня", Sex.woman, "15.06.1959");

        GeoTree gt = new GeoTree();

        gt.addPartner(jan, anna);
        gt.addParent(jan, elena);
        gt.addParent(jan, sonya);
        gt.addParent(anna, elena);
        gt.addParent(anna, sonya);
        gt.addPartner(irina, nikolay);
        gt.addParent(irina, vasja);
        gt.addParent(nikolay, vasja);
        gt.addParent(irina, masha);
        gt.addPartner(vasja, elena);
        gt.addParent(vasja, jane);
        gt.addParent(elena, jane);
        gt.addParent(vasja, ivan);
        gt.addParent(elena, ivan);
        gt.addParent(vasja, anton);
        gt.addParent(elena, anton);
        gt.addParent(ivan, gala);
        gt.addParent(ivan, jura);

        new View(gt).viewParent(vasja);
        new View(gt).viewChildren(irina);
        new View(gt).viewBrotherSister(vasja);
        new View(gt).viewPartners(vasja);
        new View(gt).viewChildren(vasja);
        new View(gt).viewBrotherSister(ivan);
        new View(gt).viewParent(ivan);
        new View(gt).viewGrandParent(ivan);
        new View(gt).viewAllAncestors(ivan);
        new View(gt).viewAllAncestors(sonya);
        new View(gt).viewIsRelative(ivan, sonya);
    }
}
