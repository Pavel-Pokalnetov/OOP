package HomeWorks.hw7;

/**
 * класс планировщика задач
 */
public interface Scheduler{
    void alert();
    void addTask();
    void delTask();
    Task[] getTask();
}
