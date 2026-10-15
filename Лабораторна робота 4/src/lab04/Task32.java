package lab04;

import java.util.Arrays;

public class Task32 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ ЗАВДАННЯ 32 (цикл for) ===");
        System.out.println("Знайти суму парних елементів масиву, що стоять на непарних місцях:\n");

        // 1. Тести за стандартним математичним розумінням "непарних місць" (нумерація з 1: 1-е, 3-є, 5-те місця -> індекси 0, 2, 4...)
        System.out.println("--- Варіант А: Нумерація місць з 1 (1-е, 3-є, 5-те місця -> індекси 0, 2, 4...) ---");
        printResults(new int[]{4, 3, 6, 7, 8, 9}, true);
        printResults(new int[]{1, 2, 3, 4, 5, 6}, true);
        printResults(new int[]{-4, 10, -2, 5, 0, 11}, true);
        printResults(new int[]{2}, true);
        printResults(new int[]{3}, true);

        // 2. Тести за розумінням як "непарні індекси" (індекси 1, 3, 5...)
        System.out.println("\n--- Варіант Б: За непарними індексами (індекси 1, 3, 5...) ---");
        printResults(new int[]{4, 3, 6, 7, 8, 9}, false);
        printResults(new int[]{1, 2, 3, 4, 5, 6}, false);
        printResults(new int[]{1, -8, 3, -4, 5, 0}, false);

        System.out.println("\n--- Заборонені комбінації (обробка виключень) ---");
        printResults(null, true);
        printResults(new int[]{}, true);
    }

    /**
     * Знаходить суму парних елементів масиву, що стоять на непарних місцях.
     * За замовчуванням розглядаються місця за порядковим номером (нумерація з 1: 1-ше, 3-тє, 5-те... тобто індекси 0, 2, 4...).
     *
     * @param array масив цілих чисел
     * @return сума парних елементів на непарних місцях
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static int sumEvenAtOddPlaces(int[] array) {
        return sumEvenAtOddPlaces(array, true);
    }

    /**
     * Знаходить суму парних елементів масиву, що стоять на непарних місцях.
     * За умовою лабораторної роботи використано цикл «for».
     *
     * @param array масив цілих чисел
     * @param oneBasedPlaces true — нумерація місць з 1 (індекси 0, 2, 4...), false — непарні індекси (індекси 1, 3, 5...)
     * @return сума парних чисел на обраних позиціях
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static int sumEvenAtOddPlaces(int[] array, boolean oneBasedPlaces) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int sum = 0;
        int startIndex = oneBasedPlaces ? 0 : 1;

        // Обов'язкове використання звичайного циклу for з індексами
        for (int i = startIndex; i < array.length; i += 2) {
            // Перевірка на парність елемента (ділиться на 2 без остачі)
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    static void printResults(int[] array, boolean oneBasedPlaces) {
        String arrayStr = (array == null) ? "null" : Arrays.toString(array);
        String modeStr = oneBasedPlaces ? "місця 1, 3, 5..." : "індекси 1, 3, 5...";
        System.out.print("Масив: " + arrayStr + " (" + modeStr + ") -> Результат: ");
        try {
            int result = sumEvenAtOddPlaces(array, oneBasedPlaces);
            System.out.println(result);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
