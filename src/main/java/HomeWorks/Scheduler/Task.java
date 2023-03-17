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
        return "Задача id: " + id + "{" +
                "\n\t Автор: " + author.getFullName() +
                ",\n\t Контроллер: " + controller.getFullName() +
                ",\n\t Описание: " + description +
                ",\n\t Приоритет: " + priority +
                ",\n\t Создано: " + createDate +
                ",\n\t Старт: " + startDate +
                ",\n\t Дедлайн: " + deadline + "}";
    }

    private static Date string2date(String strDate) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy.MM.dd");
        Date date = parser.parse(strDate);
        return date;
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

    public UUID getId() {
        return id;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Employee getController() {
        return controller;
    }

    public void setController(Employee controller) {
        this.controller = controller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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
        String analysedDataStr = getCSV();
        return analysedDataStr.toLowerCase().contains(str);
    }

    public String getCSV() {
        String analysedDataStr = id + "," +
                this.author.getFullName() + "," +
                this.author.getPost() + "," +
                this.controller.getFullName() + "," +
                this.controller.getPost() + "," +
                this.description + "," +
                this.priority + "," +
                createDate + "," +
                startDate + "," + deadline;
        return analysedDataStr;
    }
}
