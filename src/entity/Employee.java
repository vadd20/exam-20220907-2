package entity;

import java.util.List;

public class Employee {

    private long id;
    private String name;
    private String surname;
    private String patronymic;

    public Employee(long id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Employee() {
    }

    public static Employee findById(List<Employee> employees, long id) {
        return employees.stream()
                .filter(e -> e.id == id)
                .findFirst().orElse(new Employee());
    }
}
