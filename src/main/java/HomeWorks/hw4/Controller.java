package HomeWorks.hw4;

import java.util.ArrayList;
import java.util.UUID;

public class Controller {
    Menu mainmenu;
    Scheduler sc;

    public Controller(Scheduler sc) {
        this.sc = sc;
    }

    public void run() {
        mainmenu = new Menu("Главное меню");
        mainmenu.addStop("0", "Выход");
        mainmenu.add("1", "Вывод всех задач", (Runnable) this::viewTasks);
        mainmenu.add("2", "Добавление задач", (Runnable) this::addTask);
        mainmenu.add("3", "Удаление задачи", (Runnable) this::deleteTaskMenu);
        mainmenu.add("4", "Поиск задач", (Runnable) this::searchTasks);
        mainmenu.add("5", "Сохранить", (Runnable) this::searchTasks);
        mainmenu.add("6", "Загрузить", (Runnable) this::searchTasks);
        mainmenu.run();
    }

    private void deleteTaskMenu() {
        Menu menu = new Menu("Удаление задачи");
        menu.add("1", "Удаление по строке поиска", (Runnable) this::deleteTaskSearch);
        menu.addStop("0", "Выход");
        menu.run();
    }

    private void deleteTaskSearch() {
        System.out.println("Удаление по строке поиска.");
        String stringForSearch = KeyScanner.getText("Строка для поиска: ");
        ArrayList<Task> searchResult = sc.searchTasks(stringForSearch);
        if (searchResult != null && searchResult.size() > 0) {
            System.out.println("Найдены задачи для удаления");
            for (Task i : searchResult) {
                System.out.println(i);
            }
            String response = KeyScanner.getText("Удаляем (да - д|y):").toLowerCase();
            if ("д".equals(response) || "y".equals(response)) {
                System.out.printf("удалено %d задач\n", sc.deleteTaskBySearch(stringForSearch));
            }
        } else {
            System.out.println("Ничего не найдено");
        }
    }

    private void deleteTaskId() {

    }

    private void addTask() {
        System.out.println("Добавление задачи");
        String authorName = KeyScanner.getText("Автор (имя): ");
        String authorPost = KeyScanner.getText("Автор (должность): ");
        String controllerName = KeyScanner.getText("Контроллер (имя): ");
        String controllerPost = KeyScanner.getText("Контроллер (должность): ");
        var author = Employee.getEmployee(authorName, authorPost);
        var controller = Employee.getEmployee(controllerName, controllerPost);
        String description = KeyScanner.getText("Задача: ");
        String startDate = KeyScanner.getText("Дата начала (YYYY.MM.DD): ");
        String deadline = KeyScanner.getText("Дата окончания (YYYY.MM.DD): ");
        String prt = KeyScanner.getText("Приоритет (higt|normal|low)): ");
        Priority priority = switch (prt) {
            case "higt" -> Priority.higt;
            case "low" -> Priority.low;
            default -> Priority.normal;
        };
        sc.addTask(new Task(author, controller, description, priority, startDate, deadline));
    }

    private void viewTasks() {
        sc.viewTasks();
    }


    public void searchTasks() {
        System.out.println("Поиск данных.");
        String stringForSearch = KeyScanner.getText("Строка для поиска: ");
        ArrayList<Task> searchResult = sc.searchTasks(stringForSearch);
        if (searchResult != null && searchResult.size() > 0) {
            System.out.println("Найдены задачи");
            for (Task i : searchResult) {
                System.out.println(i);
            }
        } else {
            System.out.println("Ничего не найдено");
        }
    }
}
