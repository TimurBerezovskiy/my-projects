public class Main {
    public static void main(String[] args) {

        // ===================================================
        // ЗАВДАННЯ №4
        // ===================================================
        double a4 = 3.56;
        double b4 = 1.02;
        double c4 = 3.0;
        double d4 = 2.43;

        // Чисельник: корінь степеня c з tg(a)
        double num4 = Math.pow(Math.tan(a4), 1.0 / c4);

        // Знаменник: 1 + sh(b) / ln|d + c|
        double den4 = 1 + Math.sinh(b4) / Math.log(Math.abs(d4 + c4));

        // Підсумковий результат для завдання 4
        double y4 = num4 / den4;

        System.out.println("Результат завдання 4: y = " + y4);
        System.out.println("--------------------------------------------------");


        // ===================================================
        // ЗАВДАННЯ №5
        // ===================================================
        double a5 = 2.54;
        double b5 = 1.23;
        double c5 = -2.14;
        double d5 = -0.23;

        // Перша частина: 2 * cos(a^b)
        double part1_5 = 2 * Math.cos(Math.pow(a5, b5));

        // Друга частина: | arccos( - sqrt(c / d) ) |
        double part2_5 = Math.abs(Math.acos(-Math.sqrt(c5 / d5)));

        // Підсумковий результат для завдання 5
        double y5 = part1_5 + part2_5;

        System.out.println("Результат завдання 5: y = " + y5);
        System.out.println("--------------------------------------------------");


        // ===================================================
        // ЗАВДАННЯ №6
        // ===================================================
        double a6 = -1.23;
        double b6 = -0.34;
        double c6 = 0.707;
        double d6 = 2.312;

        // Перший доданок у дужках: lg|b / a|
        double term1_6 = Math.log10(Math.abs(b6 / a6));

        // Другий доданок у дужках: sqrt(sin(c) + e^d)
        double term2_6 = Math.sqrt(Math.sin(c6) + Math.exp(d6));

        // Підсумковий результат для завдання 6: 3 * (перший + другий)
        double y6 = 3 * (term1_6 + term2_6);

        System.out.println("Результат завдання 6: y = " + y6);
    }
}
