package HomeWorks.hw4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task implements Comparable<Task> {
    private UUID id;
    private Employee autor;
    private Employee controller;
    private String description;
    private Priority priority;

    private Date createDate;
    private String startDate;
    private String deadline;

    @Override
    public String toString() {
        return "Задача id: " + id + "{" +
                "\n\t Автор: " + autor.getFullName() +
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
        this.autor = autor;
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

    public Employee getAutor() {
        return autor;
    }

    public void setAutor(Employee autor) {
        this.autor = autor;
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
        return autor.equals(task.autor) &&
                controller.equals(task.controller) &&
                description.equals(task.description) &&
                priority == task.priority &&
                createDate.equals(task.createDate) &&
                startDate.equals(task.startDate) &&
                deadline.equals(task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor,
                controller,
                description,
                priority,
                createDate,
                startDate,
                deadline);
    }

    public boolean findString(String str) {
        StringBuilder analisedDataStr = new StringBuilder().
                append(id).
                append(this.autor).
                append(this.controller).
                append(this.description).
                append(this.priority).
                append(createDate).append(startDate).append(deadline);
        return analisedDataStr.indexOf(str) >= 0;
    }
}
