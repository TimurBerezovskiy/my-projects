package lab03;

public class Task7 {

    public static void main(String[] args) {
        // Дозволені значення для першої гілки (i = 1, 2)
        printResults(1.0, 1);
        printResults(Math.E, 1);
        printResults(10.0, 2);

        // Дозволені значення для другої гілки (i > 2)
        printResults(Math.PI / 2, 3);
        printResults(0.0, 4);
        printResults(1.5, 5);

        // Заборонені значення: некоректне i
        printResults(2.0, 0);
        printResults(2.0, -1);

        // Заборонені значення: t <= 0 для першої гілки
        printResults(0.0, 1);
        printResults(-2.0, 2);

        // Спеціальні некоректні значення
        printResults(Double.NaN, 3);
    }

    /**
     * Обчислює значення функції x(t, i).
     */
    public static double calculateX(double t, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("param i = " + i);
        }
        if (Double.isNaN(t)) {
            throw new IllegalArgumentException("param t = " + t);
        }

        if (i == 1 || i == 2) {
            if (t <= 0) {
                throw new IllegalArgumentException("param t = " + t);
            }
            return Math.log(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
    }

    static void printResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(calculateX(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
