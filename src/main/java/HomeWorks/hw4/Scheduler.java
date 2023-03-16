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
        taskPool.add(task);
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


        return null;
    }

    @Override
    public void searchTasks() {
        System.out.println("Поиск данных.");
        String stringForSearch = KeyScanner.getText("Строка для поиска: ");
        ArrayList<Task> searchResult = searchTasks(stringForSearch);
        if (searchResult!=null && searchResult.size() > 0) {
            System.out.println("Найдены задачи");
            for (Task i : searchResult) {
                System.out.println(i);
            }
        }else{
            System.out.println("Ничего не найдено");
        }
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

    public void addTask() {
        taskPool.add(Task.getTaskManualInput());
    }
}
