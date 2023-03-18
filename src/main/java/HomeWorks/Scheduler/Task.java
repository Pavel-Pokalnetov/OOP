package HomeWorks.Scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task implements Comparable<Task> {
    private UUID id;
    private Employee author;
    private Employee controller;
    private String description;
    private Priority priority;
    private Date createDate;
    private String startDate;
    private String deadline;

    @Override
    public String toString() {
        return "Задача id: " + id +
                "\n\t Автор: " + author.getFullName() +
                ",\n\t Контроллер: " + controller.getFullName() +
                ",\n\t Описание: " + description +
                ",\n\t Приоритет: " + priority +
                ",\n\t Создано: " + dateTime2string(createDate) +
                ",\n\t Старт: " + startDate +
                ",\n\t Дедлайн: " + deadline;
    }

//    private static Date string2date(String strDate) throws ParseException {
//        SimpleDateFormat parser = new SimpleDateFormat("yyyy.MM.dd");
//        Date date = parser.parse(strDate);
//        return date;
//    }

    private static Date string2dateTime(String strDate) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy.MM.dd-hh:mm:ss");
        Date date = parser.parse(strDate);
        return date;
    }

//    private String date2string(Date date) {
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
//        return formatForDateNow.format(date);
//    }

    private String dateTime2string(Date date) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd-hh:mm:ss");
        return formatForDateNow.format(date);
    }

    public Task(Employee autor,
                Employee controller,
                String description,
                Priority priority,
                String startDate, String deadline) {
        this.author = autor;
        this.controller = controller;
        this.description = description;
        this.priority = priority;
        createDate = new Date(System.currentTimeMillis());
        this.startDate = startDate;
        this.deadline = deadline;
        id = UUID.randomUUID();
    }

    public Employee getAuthor() {
        return author;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int compareTo(Task o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return author.equals(task.author) &&
                controller.equals(task.controller) &&
                description.equals(task.description) &&
                priority == task.priority &&
                createDate.equals(task.createDate) &&
                startDate.equals(task.startDate) &&
                deadline.equals(task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author,
                controller,
                description,
                priority,
                createDate,
                startDate,
                deadline);
    }

    public boolean findString(String str) {
        String analysedDataStr = getCSV().toLowerCase();
        return analysedDataStr.contains(str.toLowerCase());
    }

    public String getCSV() {
        String analysedDataStr = id + "|" +
                this.author.getFullName() + "|" +
                this.author.getPost() + "|" +
                this.controller.getFullName() + "|" +
                this.controller.getPost() + "|" +
                this.description + "|" +
                this.priority + "|" +
                dateTime2string(createDate) + "|" +
                startDate + "|" + deadline;
        return analysedDataStr;
    }

    /**
     * Парсинг строки в задачу
     *
     * @param readingTaskString
     * @return - new Task()
     * @throws ParseException
     */
    public static Task parse(String readingTaskString) throws ParseException {
        String[] parseArray = readingTaskString.replaceAll("\n", "").split("\\|");
        var id = UUID.fromString(parseArray[0]);
        var author = Employee.getEmployee(parseArray[1], parseArray[2]);
        var controller = Employee.getEmployee(parseArray[3], parseArray[4]);
        var description = parseArray[5];
        var priority = switch (parseArray[6]) {
            case "high" -> Priority.high;
            case "low" -> Priority.low;
            default -> Priority.normal;
        };
        var createDate = string2dateTime(parseArray[7]);
        var startDate = parseArray[8];
        var deadline = parseArray[9];
        Task task = new Task(author, controller, description, priority, startDate, deadline);
        task.setCreateDate(createDate);
        task.setId(id);
        return task;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
