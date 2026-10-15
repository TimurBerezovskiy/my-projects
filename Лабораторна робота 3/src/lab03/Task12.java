package lab03;

public class Task12 {

    public static void main(String[] args) {
        // Дозволені значення точності
        printResults(0.1);
        printResults(0.01);
        printResults(0.001);
        printResults(1e-5);

        // Заборонені значення (eps <= 0 або NaN)
        printResults(0.0);
        printResults(-0.01);
        printResults(Double.NaN);
    }

    /**
     * Обчислює нескінченну суму ряду 1 / (i * (i + 1)) із точністю eps.
     */
    public static double calculateInfiniteSum(double eps) {
        if (eps <= 0 || Double.isNaN(eps)) {
            throw new IllegalArgumentException("param eps = " + eps);
        }

        double sum = 0;
        int i = 1;
        while (true) {
            double term = 1.0 / ((double) i * (i + 1));
            if (Math.abs(term) < eps) {
                break;
            }
            sum += term;
            i++;
        }
        return sum;
    }

    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(calculateInfiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
