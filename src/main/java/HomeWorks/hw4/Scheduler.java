package HomeWorks.hw4;

import java.util.ArrayList;

public class Scheduler implements SchedulerActions, TasksLoader, TasksSaver {
    ArrayList<Task> taskPool = new ArrayList<>();

    public Scheduler(ArrayList<Task> taskPool) {
        this.taskPool = taskPool;
    }

    public Scheduler() {
        this.taskPool = new ArrayList<>();
    }


    @Override
    public ArrayList<Task> getCurrentTasks() {
        return null;
    }

    @Override
    public ArrayList<Task> getOverdueTasks() {
        return null;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void delTask(Task task) {

    }

    @Override
    public void viewTasks() {

    }

    @Override
    public ArrayList<Task> findTasks(String findRequest) {
        return null;
    }

    @Override
    public Scheduler tasksLoad(String filename) {
        ArrayList<Task> tasks = new ArrayList<>();
        // вставить метод загрузки из файла
        return new Scheduler(tasks);
    }

    @Override
    public boolean tasksSave(ArrayList<Task> tasksPool) {
        return false;
    }
}
