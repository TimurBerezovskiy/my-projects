package lab06;

/**
 * Лабораторна робота №6 (в описі завдання №9). Варіант 2.
 * Завдання №1: Перетворити значення int у об’єкт String,
 * що представляє собою число у двійковій системі числення.
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ ЗАВДАННЯ 2 (intToBinaryString) ===");
        System.out.println("Перетворення цілого числа int у двійковий рядок String:\n");

        // Дозволені комбінації аргументів
        printResults(21);                   // Приклад із завдання: очікується "10101"
        printResults(0);                    // Граничний випадок: нуль
        printResults(1);                    // Граничний випадок: одиниця
        printResults(2);                    // "10"
        printResults(7);                    // "111"
        printResults(16);                   // Степінь двійки: "10000"
        printResults(255);                  // Байт: "11111111"
        printResults(511);                  // 9 одиниць: "111111111"
        printResults(1024);                 // "10000000000"
        printResults(Integer.MAX_VALUE);    // 2147483647 -> 31 одиниця

        System.out.println("\n--- Заборонені комбінації (обробка виключень) ---");
        // Заборонені аргументи (від'ємні числа)
        printResults(-1);
        printResults(-21);
        printResults(-100);
        printResults(Integer.MIN_VALUE);
    }

    /**
     * Перетворює невід'ємне ціле число int у двійкове представлення (String).
     * Бізнес-логіка не містить консольного виведення та перевіряє коректність аргументів.
     *
     * @param i ціле число для перетворення (повинно бути >= 0)
     * @return об'єкт String, що містить двійковий запис числа
     * @throws IllegalArgumentException якщо передано від'ємне число
     */
    public static String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Число повинно бути невід'ємним (i >= 0), передано: " + i);
        }

        if (i == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        int number = i;

        // Ділимо число на 2 та накопичуємо остачі
        while (number > 0) {
            binary.append(number % 2);
            number /= 2;
        }

        // Оскільки остачі записувалися від молодшого розряду до старшого, розгортаємо рядок
        return binary.reverse().toString();
    }

    /**
     * Допоміжний метод для безпечного виклику та виведення результатів тестування.
     */
    static void printResults(int i) {
        System.out.print("Аргумент: " + i + " -> Результат: ");
        try {
            String result = intToBinaryString(i);
            System.out.println("\"" + result + "\"");
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
