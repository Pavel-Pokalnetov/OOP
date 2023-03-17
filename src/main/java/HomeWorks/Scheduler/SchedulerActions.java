package HomeWorks.Scheduler;

import java.util.ArrayList;

public interface SchedulerActions {
    /**
     * Получить текущие задачи, т.е. выполняемые в данный момент.
     */
    ArrayList<Task> getCurrentTasks();

    /**
     * Очистка списка задач
     */
    void clear();

    /**
     * Получить список просроченных задач
     */
    ArrayList<Task> getOverdueTasks();

    int deleteTaskBySearch(String searchString);

    /**
     * Добавление задачи в список
     */
    void addTask(Task task);

    /**
     * Вывод всех задач в консоль
     */
    void viewTasks();

    /**
     * Получить список задач удовлетворяющих поиску по строке в параметре
     * @param findRequest - строка для поиска в списке
     */
    ArrayList<Task> searchTasks(String findRequest);
}
