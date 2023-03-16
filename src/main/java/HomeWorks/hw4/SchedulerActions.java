package HomeWorks.hw4;

import java.util.ArrayList;

public interface SchedulerActions {

    ArrayList<Task> getCurrentTasks();

    ArrayList<Task> getOverdueTasks();

    void addTask(Task task);

    void delTask(Task task);

    void viewTasks();

    ArrayList<Task> searchTasks(String findRequest);

}
