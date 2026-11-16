package lab07;

import java.util.ArrayList;
import java.util.List;

/**
 * Лабораторна робота №7 (у методичці №10). Варіант 2.
 * Клас "Відділ" (назва, начальник відділу, список працівників).
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Department {
    private String name;
    private Employee head;
    private List<Employee> employees;

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Відділ \"" + name + "\" [Начальник: " + head.getFullName() + ", працівників: " + employees.size() + "]";
    }
}
