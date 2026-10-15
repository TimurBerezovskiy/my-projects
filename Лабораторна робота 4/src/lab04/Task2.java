package lab04;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ ЗАВДАННЯ 2 (for-each) ===");
        System.out.println("Знайти суму елементів, що більші 3:\n");

        // Дозволені комбінації аргументів
        printResults(new double[]{1.5, 4.0, 2.8, 5.5, 3.0, 10.2});
        printResults(new double[]{-2.0, 0.0, 1.0, 2.9, 3.0});
        printResults(new double[]{3.0001, 3.5, 100.0});
        printResults(new double[]{-10.5, 7.2, -3.1, 4.8, 1.0});
        printResults(new double[]{10.0});
        printResults(new double[]{2.0});

        System.out.println("\n--- Заборонені комбінації (обробка виключень) ---");
        // Заборонені комбінації (null, порожній масив, NaN)
        printResults(null);
        printResults(new double[]{});
        printResults(new double[]{4.5, Double.NaN, 6.0});
    }

    /**
     * Знаходить суму елементів масиву, які строго більші за 3.
     * За умовою лабораторної роботи використано цикл «for-each».
     *
     * @param array масив дійсних чисел
     * @return сума елементів, більших за 3
     * @throws NullPointerException якщо передано null
     * @throws IllegalArgumentException якщо масив порожній або містить NaN
     */
    public static double sumGreaterThanThree(double[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        double sum = 0.0;
        // Обов'язкове використання циклу for-each згідно з вимогами ЛР
        for (double element : array) {
            if (Double.isNaN(element)) {
                throw new IllegalArgumentException("Елемент масиву не може бути NaN");
            }
            if (element > 3.0) {
                sum += element;
            }
        }
        return sum;
    }

    static void printResults(double[] array) {
        String arrayStr = (array == null) ? "null" : Arrays.toString(array);
        System.out.print("Масив: " + arrayStr + " -> Результат: ");
        try {
            double result = sumGreaterThanThree(array);
            System.out.println(result);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
