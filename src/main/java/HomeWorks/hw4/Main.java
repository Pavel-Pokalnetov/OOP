package HomeWorks.hw4;

public class Main {
    public static void main(String[] args) {

        Employee autor = new Employee("Покальнетов Павел Сергеевич", "студент");
        Employee teacher = new Employee("Гилев Aнтон", "преподаватель");


        Scheduler sc = new Scheduler();

        sc.addTask(new Task(autor,
                teacher,
                "Работа над домашним заданием №4",
                Priority.higt,
                "2023.03.13",
                "2023.03.20"));




        Menu menu = new Menu("Главное меню");
        menu.addStop("0", "Выход");
        menu.add("1", "Вывод всех задач", (Runnable) sc::viewTasks);
        menu.add("2", "Добавление задач", (Runnable) sc::addTask);
        menu.add("3","Поиск задач",(Runnable) sc::searchTasks);
        menu.run();


    }

}
