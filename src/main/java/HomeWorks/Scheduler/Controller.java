package HomeWorks.Scheduler;

import java.util.ArrayList;

public class Controller {
    Menu mainmenu;
    Scheduler sc;
    String fileName;
    Boolean modify = true;

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
            modify = false;
            getInfo();
        } else {
            System.out.println("данные не загружены");
        }
    }

    /**
     * запись файла
     */
    private void saveScMenu() {
        Menu menu = new Menu("Сохранить данные");
        menu.add("1", "Сохранить", this::saveScDefaultName);
        menu.add("2", "Сохранить как...", this::saveScAs);
        menu.addStop("0", "Выход");
        menu.run();
    }

    private void saveScDefaultName() {
        if ("".equals(fileName)) {
            saveScAs();
            return;
        }
        if (sc.tasksSave(fileName)) {
            System.out.println("данные записаны");
            modify = false;
        }
    }

    private void saveScAs() {
        System.out.println("Задайте имя файла");
        String fName = KeyScanner.getText("Имя: ");
        if ("".equals(fName)) {
            System.out.println("отмена...");
            return;
        }
        this.fileName = fName;
        if (sc.tasksSave(fileName)) {
            System.out.println("данные записаны");
            modify = false;
        }
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
                System.out.println("--------------------------------------------");
            }
            String response = KeyScanner.getText("Удаляем (да - д|y):").toLowerCase();
            if ("д".equals(response) || "y".equals(response)) {
                System.out.printf("удалено %d задач\n", sc.deleteTaskBySearch(stringForSearch));
            }
            this.modify = true;
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
            case "high" -> Priority.high;
            case "low" -> Priority.low;
            default -> Priority.normal;
        };
        sc.addTask(new Task(author, controller, description, priority, startDate, deadline));
        modify = true;
    }

    /**
     * Просмотр всех задач
     */
    private void viewTasks() {
        if (sc.getSize()==0){
            System.out.println("Задач нет");
            return;
        }
        sc.viewTasks();
    }

    /**
     * Поиск задачи по введенной строке
     */
    public void searchTasks() {
        System.out.println("Поиск данных.");
        String stringForSearch = KeyScanner.getText("Строка для поиска (пусто для отмены): ");
        if (stringForSearch.isBlank()) return;
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
        System.out.printf("\tВсего записей: %d\n", sc.getSize());
        System.out.print("\tФайл: ");
        if (!"".equals(fileName)) {
            System.out.println(fileName);
        } else {
            System.out.println(" --- ");
        }
        if (modify) {
            System.out.println("\tИзменения не записаны");
        } else {
            System.out.println("\tИзменения записаны");
        }
    }
}