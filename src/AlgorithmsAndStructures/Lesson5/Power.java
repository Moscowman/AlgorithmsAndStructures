package AlgorithmsAndStructures.Lesson5;

public class Power {
    public static int power(int x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative int");
        }

        if (n == 0) {
            return 1;
        }

        return x * power (x, n -1);
    }
}
