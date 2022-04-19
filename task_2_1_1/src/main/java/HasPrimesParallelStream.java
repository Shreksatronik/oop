import java.util.Arrays;
import java.util.Collections;

public class HasPrimesParallelStream  extends HasPrimes{
    private long currentTime;
    private long runningTime;

    @Override
    boolean run(Integer[] array) {
        currentTime = System.currentTimeMillis();
        boolean res = Arrays.stream(array).parallel().anyMatch(PrimeChecker::isPrime);
        runningTime = System.currentTimeMillis() - currentTime;
        return res;
    }

    @Override
    long getTime() {
        return runningTime;
    }
}
