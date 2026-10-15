package lab05;

import java.util.Arrays;

/**
 * Лабораторна робота №5. Варіант 2.
 * Метод 1: Сортування вибором (Selection sort) для масиву short[] за спаданням.
 */
public class SelectionSort {

    public static void main(String[] args) {
        System.out.println("=== Сортування вибором (Selection sort) ===");
        System.out.println("Порядок: по спаданню | Тип: short[]\n");

        // Тести на коректних даних
        printResults(new short[]{5, -2, 18, 0, 42, -9, 7});
        printResults(new short[]{50, 40, 30, 20, 10, 0, -10});
        printResults(new short[]{-15, -5, 0, 12, 34, 89});
        printResults(new short[]{7, 3, 7, 1, 3, 7, 0});
        printResults(new short[]{5, 5, 5, 5});
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
     * Сортування масиву short[] за спаданням методом вибору на місці.
     */
    public static void sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length <= 1) {
            return;
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            // шукаємо індекс найбільшого елемента в невідсортованій частині
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // якщо знайшли більший елемент — міняємо місцями
            if (maxIndex != i) {
                short temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
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
        int step = 1;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                short temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
                System.out.printf("Крок %d: max=%d на індексі %d -> обмін з індексом %d: %s%n",
                        step++, array[i], maxIndex, i, Arrays.toString(array));
            } else {
                System.out.printf("Крок %d: max=%d вже на індексі %d: %s%n",
                        step++, array[i], i, Arrays.toString(array));
            }
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
