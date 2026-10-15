package lab03;

public class Task2 {

    public static void main(String[] args) {
        // Дозволені комбінації аргументів
        printResults(-1.0, 4.0, 3);
        printResults(-2.0, 0.0, 5);
        printResults(-0.5, 9.0, 10);
        printResults(-1.0, 1.0, 25);

        // Заборонені комбінації: порушення умов для k (потрібно 2 < k <= 25)
        printResults(-1.0, 4.0, 2);
        printResults(-1.0, 4.0, 1);
        printResults(-1.0, 4.0, 0);
        printResults(-1.0, 4.0, 26);

        // Заборонені комбінації: порушення для t (потрібно t < 0) та s (потрібно s >= 0)
        printResults(0.0, 4.0, 5);
        printResults(1.0, 4.0, 5);
        printResults(-1.0, -4.0, 5);
        printResults(Double.NaN, 4.0, 5);
    }

    /**
     * Обчислює суму ряду: \sum_{i=1}^{k} ln(-t * i) * cos(sqrt(s * (1 / i^2))).
     */
    public static double calculateSum(double t, double s, int k) {
        if (k <= 2 || k > 25) {
            throw new IllegalArgumentException("param k = " + k);
        }
        if (t >= 0 || Double.isNaN(t)) {
            throw new IllegalArgumentException("param t = " + t);
        }
        if (s < 0 || Double.isNaN(s)) {
            throw new IllegalArgumentException("param s = " + s);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.log(-t * i) * Math.cos(Math.sqrt(s / ((double) i * i)));
        }
        return sum;
    }

    static void printResults(double t, double s, int k) {
        System.out.print("t:" + t + " s:" + s + " k:" + k + " result:");
        try {
            System.out.println(calculateSum(t, s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
