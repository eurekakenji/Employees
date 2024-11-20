package models;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String position;
    private String salary;
    private LocalDate hireDate;
    private LocalDate quitDate;

    public Employee() {
        this.id = UUID.randomUUID();
    }

    public Employee(UUID id, String position, String salary, LocalDate hireDate, LocalDate quitDate) {
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.quitDate = quitDate;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    public LocalDate getQuitDate() {
        return quitDate;
    }
    public void setQuitDate(LocalDate quitDate) {
        this.quitDate = quitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id.equals(employee.id) && position.equals(employee.position) && salary.equals(employee.salary) && hireDate.equals(employee.hireDate) && quitDate.equals(employee.quitDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + quitDate.hashCode();
        return result;
    }
}
