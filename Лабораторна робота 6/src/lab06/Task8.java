package lab06;

/**
 * Лабораторна робота №6 (в описі завдання №9). Варіант 2.
 * Завдання №2 (№8 у списку): Підрахувати кількість чисел у реченні.
 * Речення містить слова (a-z, A-Z), цілі числа (0-9) та комбінації літер і цифр.
 *
 * Студент: Березовський Тимур
 * Група: ЦК-41
 */
public class Task8 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ ЗАВДАННЯ 8 (Підрахунок кількості чисел) ===");
        System.out.println("Підрахунок кількості цілих чисел у реченні:\n");

        // Приклад з методичних вказівок (очікується 2: числа "3" та "4")
        String sampleText = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
        printResults(sampleText);

        // Додаткові дозволені речення
        printResults("Room 101 has 2 big windows and 1 wooden door");
        printResults("10 20 300 4000");
        printResults("Hello world from Java program");
        printResults("koala757677 croco181dile920 bot2026");
        printResults("   42   ");
        printResults("Only one number 7 in the center");
        printResults("Year 2026 month 11 day 9");

        System.out.println("\n--- Заборонені комбінації (обробка виключень) ---");
        // Заборонені комбінації (null, порожній рядок, лише пробіли, сторонні спецсимволи)
        printResults(null);
        printResults("");
        printResults("   ");
        printResults("The price is 100$ and bonus 20#");
        printResults("Email test@example 123");
    }

    /**
     * Підраховує кількість цілих чисел (що складаються виключно з цифр 0-9) у заданому реченні.
     * Відповідно до вимог, метод перевіряє аргументи та не взаємодіє з консоллю напряму.
     *
     * @param sentence речення для аналізу
     * @return кількість знайдених чисел
     * @throws NullPointerException якщо передано null
     * @throws IllegalArgumentException якщо рядок порожній або містить недозволені символи
     */
    public static int countNumbers(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Рядок не може бути null");
        }

        // Прибираємо пробіли на початку та в кінці
        String trimmed = sentence.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім або містити лише пробіли");
        }

        // Розбиваємо речення на лексеми за пробільними символами (split)
        String[] tokens = trimmed.split("\\s+");
        int count = 0;

        for (String token : tokens) {
            if (isNumber(token)) {
                count++;
            } else if (!isWord(token) && !isAlphanumericCombination(token)) {
                // Якщо токен не є ані числом, ані словом, ані їхньою комбінацією — викидаємо виключення
                throw new IllegalArgumentException("Рядок містить недопустиму лексему або спецсимвол: \"" + token + "\"");
            }
        }

        return count;
    }

    /**
     * Перевіряє, чи складається лексема виключно з цифр 0-9 (ціле число).
     */
    public static boolean isNumber(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        for (char c : token.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Перевіряє, чи є лексема словом (містить лише літери a-z, A-Z).
     * Використовує toLowerCase() та toCharArray().
     */
    public static boolean isWord(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        for (char c : token.toLowerCase().toCharArray()) {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    /**
     * Перевіряє, чи є лексема комбінацією літер та цифр (містить хоча б одну літеру та хоча б одну цифру).
     */
    public static boolean isAlphanumericCombination(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : token.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                hasLetter = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else {
                return false; // знайдено сторонній символ
            }
        }
        return hasLetter && hasDigit;
    }

    /**
     * Допоміжний метод для безпечного виклику та форматованого виведення результатів тестування.
     */
    static void printResults(String sentence) {
        String display = (sentence == null) ? "null" : "\"" + sentence + "\"";
        System.out.print("Речення: " + display + " -> Кількість чисел: ");
        try {
            int result = countNumbers(sentence);
            System.out.println(result);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
