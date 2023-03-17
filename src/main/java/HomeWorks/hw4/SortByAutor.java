package HomeWorks.hw4;

import java.util.Comparator;

public class SortByAutor implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return (o1.getAuthor().compareTo(o2.getAuthor()));
    }

    @Override
    public Comparator<Task> reversed() {
        return Comparator.super.reversed();
    }
}
