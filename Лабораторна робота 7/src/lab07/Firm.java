package lab07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Лабораторна робота №7 (у методичці №10). Варіант 2.
 * Клас "Фірма" (назва, директор, список відділів).
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Firm {
    private String name;
    private Employee director;
    private List<Department> departments;

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    /**
     * Задача 1: Знайти значення максимальної заробітної платні з усіх працівників,
     * включаючи начальників та директора.
     * Спосіб перегляду за Варіантом 2: а) нетипізований ітератор.
     */
    @SuppressWarnings("rawtypes")
    public double findMaxSalary() {
        double maxSalary = director.getSalary();

        // а) Нетипізований ітератор для обходу відділів
        Iterator deptIt = departments.iterator();
        while (deptIt.hasNext()) {
            Department dept = (Department) deptIt.next();

            // Перевіряємо зарплату начальника відділу
            if (dept.getHead() != null && dept.getHead().getSalary() > maxSalary) {
                maxSalary = dept.getHead().getSalary();
            }

            // а) Нетипізований ітератор для обходу працівників відділу
            Iterator empIt = dept.getEmployees().iterator();
            while (empIt.hasNext()) {
                Employee emp = (Employee) empIt.next();
                if (emp.getSalary() > maxSalary) {
                    maxSalary = emp.getSalary();
                }
            }
        }
        return maxSalary;
    }

    /**
     * Задача 2: Визначити відділ, в якому хоча б один з співробітників
     * отримує заробітну платню вищу за платню свого начальника.
     * Спосіб перегляду за Варіантом 2: c) типізований цикл «for-each».
     */
    public Department findDepartmentWithEmployeeEarningMoreThanHead() {
        // c) Типізований цикл for-each для відділів
        for (Department dept : departments) {
            if (dept.getHead() == null) {
                continue;
            }
            double headSalary = dept.getHead().getSalary();

            // c) Типізований цикл for-each для працівників відділу
            for (Employee emp : dept.getEmployees()) {
                if (emp.getSalary() > headSalary) {
                    return dept; // знайдено такий відділ
                }
            }
        }
        return null;
    }

    /**
     * Задача 3: Скласти список усіх співробітників фірми, включаючи начальників та директора.
     * Спосіб перегляду за Варіантом 2: b) типізований ітератор.
     */
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        if (director != null) {
            allEmployees.add(director);
        }

        // b) Типізований ітератор для відділів
        Iterator<Department> deptIt = departments.iterator();
        while (deptIt.hasNext()) {
            Department dept = deptIt.next();
            if (dept.getHead() != null) {
                allEmployees.add(dept.getHead());
            }

            // b) Типізований ітератор для працівників відділу
            Iterator<Employee> empIt = dept.getEmployees().iterator();
            while (empIt.hasNext()) {
                Employee emp = empIt.next();
                allEmployees.add(emp);
            }
        }
        return allEmployees;
    }

    @Override
    public String toString() {
        return "Фірма \"" + name + "\" (Директор: " + director.getFullName() + ")";
    }
}
