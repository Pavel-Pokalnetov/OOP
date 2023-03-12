package HomeWorks.hw1.task1;

import javax.crypto.spec.PSource;
import java.util.ArrayList;

/**
 * класс для визуализации данных в консоли
 */
public class View {
    Reserch gTree;


    public View(Reserch geoTree) {
        this.gTree = geoTree;
    }

    private ArrayList<String> arrayPerson2String(ArrayList<Person> arrayListPersons){
        ArrayList<String> result = new ArrayList<>(arrayListPersons.size());
        for (Person itemPerson: arrayListPersons) {
            result.add(itemPerson.toString());
        }
        return result;
    }

    public void viewBrotherSister(Person person) {
        System.out.printf("%s | братья/сёстры --> ", person);
        System.out.println(arrayPerson2String(this.gTree.getBrotherSister(person)));
    }

    public void viewParent(Person person) {
        System.out.printf("%s | родители --> ", person);
        System.out.println(arrayPerson2String(this.gTree.getParents(person)));
    }

    public void viewChildren(Person person) {
        System.out.printf("%s | дети --> ", person);
        System.out.println(arrayPerson2String(this.gTree.getChildren(person)));
    }

    public void viewPartners(Person person) {
        System.out.printf("%s | брак --> ", person);
        System.out.println(arrayPerson2String(this.gTree.getPartners(person)));
    }

    public void viewAllData(){
        System.out.println(this.gTree.toString());
    }

    public void viewGrandParent(Person person) {
        System.out.printf("%s | бабушки и дедушки --> ", person);
        System.out.println(arrayPerson2String(this.gTree.getGrandParents(person)));
    }

    public void viewAllAncestors(Person person){
        System.out.printf("%s | все предки --> ",person);
        System.out.println(arrayPerson2String(this.gTree.getAllAncestors(person)));
    }

    public void viewIsRelative(Person person1, Person person2) {
        System.out.printf("%s и %s - ",person1,person2);
        if (!this.gTree.isRelative(person1,person2)){
            System.out.print("не ");
        }
        System.out.println("родственники");
    }
}
