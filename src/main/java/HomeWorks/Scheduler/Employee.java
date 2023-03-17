package HomeWorks.Scheduler;

import java.util.Objects;

class Employee implements Comparable<Employee> {
    String name;
    String post;

    public Employee(String name, String post) {
        this.name = name;
        this.post = post;
    }

    public static Employee getEmployee(String name, String post) {
        return new Employee(name, post);
    }

    public String getPost() {
        return post;
    }

    public String getFullName() {
        return name;
    }

    @Override
    public int compareTo(Employee obj) {
        return (name + post).compareTo(obj.getFullName() + obj.getPost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return name.equals(employee.name) && post.equals(employee.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post);
    }

    @Override
    public String toString() {
        return name + " " + post;
    }
}
