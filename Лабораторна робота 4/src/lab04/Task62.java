package lab04;

import java.util.Arrays;

public class Task62 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ ЗАВДАННЯ 62 ===");
        System.out.println("Сформувати новий масив: поділити на min (якщо min != 0), або замінити на -10 (якщо min == 0):\n");

        // Дозволені випадки:
        // 1. min > 0 (ділення націло)
        printResults(new int[]{4, 2, 6, 8, 10});

        // 2. min > 0 (ділення з дробовою частиною)
        printResults(new int[]{3, 5, 7, 2});

        // 3. min == 0 (усі елементи мають стати -10)
        printResults(new int[]{5, 0, 12, 3, 8});

        // 4. min < 0 (від'ємний мінімум)
        printResults(new int[]{10, -5, 20, -10, 15});

        // 5. Одноклітинний масив
        printResults(new int[]{5});
        printResults(new int[]{0});

        System.out.println("\n--- Заборонені комбінації (обробка виключень) ---");
        printResults(null);
        printResults(new int[]{});
    }

    /**
     * Формує новий масив: ділить усі елементи на найменший елемент (якщо min != 0),
     * або замінює всі елементи на -10 (якщо min == 0).
     * Оригінальний масив не змінюється.
     *
     * @param array вхідний масив цілих чисел
     * @return новий сформований масив дійсних чисел (зберігає точність ділення)
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static double[] transformArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        // 1. Пошук найменшого елемента масиву за допомогою for-each
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }

        // 2. Створення нового масиву необхідної розмірності
        double[] result = new double[array.length];

        // 3. Заповнення нового масиву за умовами завдання
        if (min == 0) {
            for (int i = 0; i < array.length; i++) {
                result[i] = -10.0;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                result[i] = (double) array[i] / min;
            }
        }

        return result;
    }

    /**
     * Варіант методу з цілочисельним діленням (int[] -> int[]).
     */
    public static int[] transformArrayInt(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }

        int[] result = new int[array.length];
        if (min == 0) {
            for (int i = 0; i < array.length; i++) {
                result[i] = -10;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i] / min;
            }
        }
        return result;
    }

    static void printResults(int[] array) {
        String arrayStr = (array == null) ? "null" : Arrays.toString(array);
        System.out.print("Вхідний масив: " + arrayStr + " -> ");
        try {
            double[] result = transformArray(array);
            System.out.println("Результат: " + Arrays.toString(result));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
