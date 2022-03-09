import static java.lang.Math.sqrt;

public class Validation {
    private static boolean isPrime(long n) {
        for (long i = 2; i <= sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public static boolean isNotPrime(long n) {
        return !isPrime(n);
    }
}
