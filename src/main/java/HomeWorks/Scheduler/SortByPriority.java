package HomeWorks.Scheduler;

import java.util.Comparator;

public class SortByPriority implements Comparator<Task> {

    public SortByPriority() {
        super();

    }

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getPriority()==o2.getPriority())return 0;
        if (o1.getPriority().ordinal()>o2.getPriority().ordinal())return 1;
        return -1;
    }

    @Override
    public Comparator<Task> reversed() {
        return Comparator.super.reversed();
    }
}
