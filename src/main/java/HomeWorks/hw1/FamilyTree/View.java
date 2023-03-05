package HomeWorks.hw1.FamilyTree;

public class View {
    GeoTree gTree;

    public View(GeoTree geoTree) {
        this.gTree = geoTree;
    }

    public void viewBrotherSister(Person person) {
        System.out.printf("%s | братья/сёстры --> ", person.getFullName());
        System.out.println(new Reserch(this.gTree).getBrotherSister(person));
    }

    public void viewParent(Person person) {
        System.out.printf("%s | родители --> ", person.getFullName());
        System.out.println(new Reserch(this.gTree).getParents(person));
    }

    public void viewChildren(Person person) {
        System.out.printf("%s | дети --> ", person.getFullName());
        System.out.println(new Reserch(this.gTree).getChildren(person));
    }

    public void viewPartners(Person person) {
        System.out.printf("%s | брак --> ", person.getFullName());
        System.out.println(new Reserch(this.gTree).getPartners(person));
    }

}
