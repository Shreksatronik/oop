public class HasPrimesSingleThread extends HasPrimes{
    private long currentTime;
    private long runningTime;

    @Override
    boolean run(Integer[] array) {
        currentTime = System.currentTimeMillis();
        for (int i : array) {
            if (PrimeChecker.isPrime(i)) {
                runningTime = System.currentTimeMillis() - currentTime;
                return true;
            }
        }
        return false;
    }

    @Override
    long getTime() {
        return runningTime;
    }
}
