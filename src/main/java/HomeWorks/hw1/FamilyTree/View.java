package HomeWorks.hw1.FamilyTree;

public class View {
    public static void viewBrotherSister(Person person, GeoTree gt) {
        System.out.printf("%s | братья/сёстры --> ", person.getFullName());
        System.out.println(new Reserch(gt).getBrotherSister(person));
    }

    public static void viewParent(Person person, GeoTree gt) {
        System.out.printf("%s | родители --> ", person.getFullName());
        System.out.println(new Reserch(gt).getParents(person));
    }

    public static void viewChildren(Person person, GeoTree gt) {
        System.out.printf("%s | дети --> ", person.getFullName());
        System.out.println(new Reserch(gt).getChildren(person));
    }

    public static void viewPartners(Person person, GeoTree gt) {
        System.out.printf("%s | брак --> ", person.getFullName());
        System.out.println(new Reserch(gt).getPartners(person));
    }

}
