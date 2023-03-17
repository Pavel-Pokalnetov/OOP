package HomeWorks.Scheduler;

import java.util.ArrayList;

public class Controller {
    Menu mainmenu;
    Scheduler sc;
    String fileName;

    public Controller(Scheduler sc) {
        this.sc = sc;
        fileName = "";
    }

    /**
     * Главное меню
     */
    public void run() {
        mainmenu = new Menu("Главное меню");
        mainmenu.addStop("0", "Выход");
        mainmenu.add("1", "Вывод всех задач", this::viewTasks);
        mainmenu.add("2", "Добавление задач", this::addTask);
        mainmenu.add("3", "Удаление задачи", this::deleteTaskMenu);
        mainmenu.add("4", "Поиск задач", this::searchTasks);
        mainmenu.add("5", "Сохранить", this::saveScMenu);
        mainmenu.add("6", "Загрузить", this::loadSC);
        mainmenu.add("7", "Инфо", this::getInfo);

        mainmenu.run();
    }

    private void loadSC() {
        System.out.println("Загрузить данные");
        System.out.println("Задайте имя файла");
        String fName = KeyScanner.getText("Имя: ");
        if ("".equals(fName)) {
            System.out.println("отмена...");
            return;
        }

        this.fileName = fName;
        if (sc.tasksLoad(fileName)) {
            System.out.println("Данные загружены");
            this.getInfo();
        } else {
            System.out.println("данные не загружены");
        }
    }

    /**
     * запись файла
     */
    private void saveScMenu() {
        Menu menu = new Menu("Сохранить данные");
        menu.add("1", "Сохранить", (Runnable) this::saveScDefaultName);
        menu.add("2", "Сохранить как...", (Runnable) this::saveScAs);
        menu.addStop("0", "Выход");
        menu.run();
    }

    private void saveScDefaultName() {
        if ("".equals(fileName)) {
            saveScAs();
            return;
        }
        sc.tasksSave(fileName);
    }

    private void saveScAs() {
        System.out.println("Задайте имя файла");
        String fName = KeyScanner.getText("Имя: ");
        if ("".equals(fName)) {
            System.out.println("отмена...");
            return;
        }
        this.fileName = fName;
        sc.tasksSave(fileName);
    }


    private void deleteTaskMenu() {
        Menu menu = new Menu("Удаление задачи");
        menu.add("1", "Удаление по строке поиска", this::deleteTaskSearch);
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


    /**
     * Добавление задачи
     */
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
        String prt = KeyScanner.getText("Приоритет (high|normal|low)): ");
        Priority priority = switch (prt) {
            case "higt" -> Priority.high;
            case "low" -> Priority.low;
            default -> Priority.normal;
        };
        sc.addTask(new Task(author, controller, description, priority, startDate, deadline));
    }

    /**
     * Просмотр всех задач
     */
    private void viewTasks() {
        sc.viewTasks();
    }


    /**
     * Поиск задачи по введенной строке
     */
    public void searchTasks() {
        System.out.println("Поиск данных.");
        String stringForSearch = KeyScanner.getText("Строка для поиска (пусто для отмены): ").toLowerCase();
        if ("".equals(stringForSearch)) return;
        ArrayList<Task> searchResult = sc.searchTasks(stringForSearch);
        if (searchResult != null && searchResult.size() > 0) {
            System.out.println("Найдены задачи");
            for (Task i : searchResult) {
                System.out.println(i);
                System.out.println("--------------------------------------------");
            }
        } else {
            System.out.println("Ничего не найдено");
        }
    }

    public void getInfo() {
        System.out.println("Сводная информация");
        System.out.printf("Всего записей: %d\n", sc.getSize());
        System.out.print("Файл: ");
        if (!"".equals(this.fileName)) {
            System.out.println(fileName);
        } else {
            System.out.println(" --- ");
        }
    }
}
