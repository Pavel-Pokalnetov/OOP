package HomeWorks.Scheduler;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Scheduler implements SchedulerActions, TasksLoader, TasksSaver {

    public int getSize() {
        return taskPool.size();
    }

    private ArrayList<Task> taskPool;

    public Scheduler(ArrayList<Task> taskPool) {
        this.taskPool = taskPool;
    }

    public Scheduler() {
        this.taskPool = new ArrayList<>();
    }

    /**
     * Получить текущие задачи
     *
     * @return - список задач
     */
    @Override
    public ArrayList<Task> getCurrentTasks() {
        return null;
    }

    /**
     * Очистка списка задач
     */
    @Override
    public void clear() {
        taskPool = new ArrayList<>();

    }

    /**
     * Получить просроченные задачи
     *
     * @return - список задач
     */
    @Override
    public ArrayList<Task> getOverdueTasks() {
        return null;
    }

    @Override
    public void viewTasks() {
        taskPool.sort(new SortByPriority());
        for (Task t : taskPool) {
            System.out.println(t + "\n");
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

    @Override
    public int deleteTaskBySearch(String searchString) {
        int count = 0;
        Iterator<Task> iteratorTaskPool = taskPool.iterator();
        while (iteratorTaskPool.hasNext()) {
            Task t = iteratorTaskPool.next();
            if (t.findString(searchString)) {
                iteratorTaskPool.remove();
                count++;
            }
        }
        return count;
    }


    @Override
    public boolean tasksLoad(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String f;
            while ((f = reader.readLine()) != null) {
                System.out.print(f);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void tasksSave(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Task t : taskPool) {
                String text = t.getCSV() + "\n";
                writer.write(text);
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("ошибка записи файла " + fileName);
        }
    }

    @Override
    public void addTask(Task task) {
        if (task == null) return;
        taskPool.add(task);
    }
}