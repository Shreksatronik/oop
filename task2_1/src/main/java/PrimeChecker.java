public class PrimeChecker {
    public static boolean isPrime(int i){
        if (i < 2) {
            return false;
        }
        for (int j = 2; j < Math.sqrt(i) + 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
