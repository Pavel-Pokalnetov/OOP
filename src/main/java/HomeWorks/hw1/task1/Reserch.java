package HomeWorks.hw1.task1;

import java.util.ArrayList;

public interface Reserch {
    ArrayList<String> getParents(Person person);
    ArrayList<String> getChildren(Person person);
    ArrayList<String> getBrotherSister(Person person);
    ArrayList<String> getPartners(Person person);
    ArrayList<String> spend(Person person, Relationship rel);
}
