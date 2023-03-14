package HomeWorks.hw4;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task implements Comparable{
    private UUID id;
    private Employee autor;
    private Employee controller;
    private StringBuilder description;
    private Priority priority;

    private Date createDate;
    private Date startDate;
    private Date deadline;

    @Override
    public String toString() {
        return "Task{" +
                "\n autor=" + autor +
                ",\n controller=" + controller +
                ",\n description=" + description +
                ",\n priority=" + priority +
                ",\n createDate=" + createDate +
                ",\n startDate=" + startDate +
                ",\n deadline=" + deadline +
                "\n}";
    }

    public Task(Employee autor,
                Employee controller,
                StringBuilder description,
                Priority priority,
                Date startDate, Date deadline) {
        this.autor = autor;
        this.controller = controller;
        this.description = description;
        this.priority = priority;
        this.createDate = new Date(System.currentTimeMillis());
        this.startDate = startDate;
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id.equals(task.id) && createDate.equals(task.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate);
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

    public StringBuilder getDescription() {
        return description;
    }

    public void setDescription(StringBuilder description) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public int compareTo(Object o) {
        return this.createDate.compareTo(((Task)o).getCreateDate());
    }
}
