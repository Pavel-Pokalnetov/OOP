package HomeWorks.hw4;

import java.util.ArrayList;
import java.util.Iterator;

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
    public void delTask(Task task) {
        taskPool.remove(task);
    }

    @Override
    public void viewTasks() {
        taskPool.sort(new SortByPriority());
        for (Task t : taskPool) {
            System.out.println(t);
        }
    }


    @Override
    public ArrayList<Task> searchTasks(String findRequest) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : taskPool) {
            if (t.findString(findRequest)) result.add(t);
        }
        if (result.size() > 0) return result;
        return null;
    }

    public int deleteTaskBySearch(String searchString) {
        int count = 0;
        Iterator<Task> iterTaskPool = taskPool.iterator();
        while (iterTaskPool.hasNext()) {
            Task t = iterTaskPool.next();
            if (t.findString(searchString)) {
                iterTaskPool.remove();
                count++;
            }
        }
        return count;
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

    public void addTask(Task task) {
        if (task == null) return;
        taskPool.add(task);
    }
}
