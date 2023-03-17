package HomeWorks.hw4;

public class Main {
    public static void main(String[] args) {

        Scheduler sc = new Scheduler();
        firsLoad(sc); //для отладки
        Controller controller = new Controller(sc);
        controller.run();
        System.out.println("Работа завершена");
    }
    
    /**
     * методля за заполнения одной задачи
     * чисто для отладки
     *
     * @param sc
     */
    private static void firsLoad(Scheduler sc) {
        Employee autor = new Employee("Покальнетов Павел Сергеевич", "студент");
        Employee teacher = new Employee("Гилев Aнтон", "преподаватель");
        sc.addTask(new Task(autor,
                teacher,
                "Работа над домашним заданием №4",
                Priority.higt,
                "2023.03.13",
                "2023.03.20"));
    }
}
