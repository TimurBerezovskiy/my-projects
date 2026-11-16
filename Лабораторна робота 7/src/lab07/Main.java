package lab07;

import java.util.List;

/**
 * Лабораторна робота №7 (у методичці №10). Варіант 2.
 * Головний клас для демонстрації виконання завдань 1, 2, 3.
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №7. Колекції. Списки. Варіант 2 ===");
        System.out.println("Студент: Березовський Тимур | Група: ЦК-41\n");

        // 1. Створення фірми та директора
        Employee director = new Employee("Олександр", "Коваленко", 120000.0);
        Firm firm = new Firm("TechSolutions", director);

        // 2. Створення відділу розробки (співробітник Сидоренко має зарплату 95000 > 85000 у начальника)
        Employee devHead = new Employee("Ігор", "Мельник", 85000.0);
        Department devDept = new Department("Відділ розробки", devHead);
        devDept.addEmployee(new Employee("Андрій", "Шевченко", 60000.0));
        devDept.addEmployee(new Employee("Максим", "Сидоренко", 95000.0));
        devDept.addEmployee(new Employee("Тетяна", "Кравченко", 50000.0));
        firm.addDepartment(devDept);

        // 3. Створення відділу тестування
        Employee qaHead = new Employee("Олена", "Бондаренко", 65000.0);
        Department qaDept = new Department("Відділ тестування", qaHead);
        qaDept.addEmployee(new Employee("Дмитро", "Козак", 45000.0));
        qaDept.addEmployee(new Employee("Юлія", "Лисенко", 48000.0));
        firm.addDepartment(qaDept);

        // Виведення структури фірми
        System.out.println(firm);
        System.out.println("Директор: " + firm.getDirector());
        System.out.println("Відділи фірми:");
        for (Department d : firm.getDepartments()) {
            System.out.println(" * " + d);
        }
        System.out.println();

        // -------------------------------------------------------------
        // Задача 1: максимальна зарплата (нетипізований ітератор)
        // -------------------------------------------------------------
        System.out.println("1) Максимальна заробітна платня (нетипізований ітератор - a):");
        double maxSalary = firm.findMaxSalary();
        System.out.printf("   Результат: %.2f грн\n\n", maxSalary);

        // -------------------------------------------------------------
        // Задача 2: відділ, де працівник отримує більше начальника (типізований for-each)
        // -------------------------------------------------------------
        System.out.println("2) Відділ, де працівник отримує більше за начальника (for-each - c):");
        Department foundDept = firm.findDepartmentWithEmployeeEarningMoreThanHead();
        if (foundDept != null) {
            System.out.println("   Знайдено відділ: " + foundDept.getName());
            System.out.println("   Начальник відділу: " + foundDept.getHead());
            System.out.println("   Працівники відділу:");
            for (Employee emp : foundDept.getEmployees()) {
                String note = emp.getSalary() > foundDept.getHead().getSalary() ? " <-- БІЛЬШЕ НІЖ У НАЧАЛЬНИКА" : "";
                System.out.println("     - " + emp + note);
            }
        } else {
            System.out.println("   Такого відділу немає");
        }
        System.out.println();

        // -------------------------------------------------------------
        // Задача 3: список усіх співробітників (типізований ітератор)
        // -------------------------------------------------------------
        System.out.println("3) Список усіх співробітників фірми (типізований ітератор - b):");
        List<Employee> allEmployees = firm.getAllEmployees();
        int index = 1;
        for (Employee emp : allEmployees) {
            System.out.printf("   %2d. %s\n", index++, emp);
        }
    }
}
