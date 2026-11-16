package lab07;

/**
 * Лабораторна робота №7 (у методичці №10). Варіант 2.
 * Клас "Працівник" (ім'я, прізвище, заробітна платня).
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + salary + " грн)";
    }
}
