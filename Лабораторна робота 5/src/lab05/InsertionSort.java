package lab05;

import java.util.Arrays;

/**
 * Лабораторна робота №5. Варіант 2.
 * Метод 2: Сортування вставкою (Insertion sort) для масиву short[] за спаданням.
 */
public class InsertionSort {

    public static void main(String[] args) {
        System.out.println("=== Сортування вставкою (Insertion sort) ===");
        System.out.println("Порядок: по спаданню | Тип: short[]\n");

        // Тести на коректних даних
        printResults(new short[]{5, -2, 18, 0, 42, -9, 7});
        printResults(new short[]{50, 40, 30, 20, 10, 0, -10});
        printResults(new short[]{-15, -5, 0, 12, 34, 89});
        printResults(new short[]{50, 45, 10, 30, 25, 20, 5});
        printResults(new short[]{7, 3, 7, 1, 3, 7, 0});
        printResults(new short[]{8, 8, 8, 8});
        printResults(new short[]{0, Short.MAX_VALUE, -100, Short.MIN_VALUE, 1234});
        printResults(new short[]{42});
        printResults(new short[]{});

        System.out.println("\n--- Обробка помилок ---");
        printResults(null);

        System.out.println("\n--- Покрокова робота алгоритму ---");
        short[] demo = {12, 45, -3, 89, 0, 21};
        System.out.println("Початковий масив: " + Arrays.toString(demo));
        sortWithTracing(demo);
    }

    /**
     * Сортування масиву short[] за спаданням методом вставки на місці.
     */
    public static void sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            short key = array[i];
            int j = i - 1;

            // Зсуваємо праворуч елементи, які менші за key
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static short[] sortCopy(short[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        short[] copy = Arrays.copyOf(array, array.length);
        sort(copy);
        return copy;
    }

    public static void sortWithTracing(short[] array) {
        if (array == null) return;
        int n = array.length;
        for (int i = 1; i < n; i++) {
            short key = array[i];
            int j = i - 1;
            int shifts = 0;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
                shifts++;
            }
            array[j + 1] = key;

            System.out.printf("Крок %d: вставка key=%d (зсувів: %d) -> %s%n",
                    i, key, shifts, Arrays.toString(array));
        }
        System.out.println("Результат: " + Arrays.toString(array));
    }

    static void printResults(short[] array) {
        String str = (array == null) ? "null" : Arrays.toString(array);
        System.out.print("Масив: " + str + " -> ");
        try {
            short[] sorted = sortCopy(array);
            System.out.println("Результат: " + Arrays.toString(sorted));
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
