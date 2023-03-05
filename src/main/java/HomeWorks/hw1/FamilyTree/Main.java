package HomeWorks.hw1.FamilyTree;

import static HomeWorks.hw1.FamilyTree.View.*;

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
        gt.append(irina, vasya);
        gt.append(irina, masha);

        gt.append(vasya, jane);
        gt.append(vasya, ivan);
        gt.append(vasya, anton);
        gt.append(elena, anton);
        gt.addPartner(vasya,elena);
        gt.append(elena, jane);
        gt.append(elena, ivan);
        gt.append(ivan,gala);
        gt.append(ivan,jura);


        new View(gt).viewParent(vasya);
        new View(gt).viewBrotherSister(vasya);
        new View(gt).viewPartners(vasya);
        new View(gt).viewChildren(vasya);
        new View(gt).viewBrotherSister(ivan);

    }

}
