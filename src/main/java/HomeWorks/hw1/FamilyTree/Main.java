package HomeWorks.hw1.FamilyTree;

public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        Person masha = new Person("Маша");
        Person jane = new Person("Женя");
        Person ivan = new Person("Ваня");
        Person anton = new Person("Антон");
        Person elena = new Person("Елена");

        GeoTree gt = new GeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);
        gt.append(vasya, anton);
        gt.append(elena, anton);
        gt.append(elena, jane);
        gt.append(elena, ivan);

//        System.out.println(new Reserch(gt).spend(irina,Relationship.parent));
//        System.out.println(new Reserch(gt).getChildren(ivan));
        new Reserch(gt).getBrotherSister(anton);
    }

}
