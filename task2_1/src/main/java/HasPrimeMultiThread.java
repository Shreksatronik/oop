import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HasPrimeMultiThread extends HasPrimes{
    private int threadsAmount;
    private long currentTime;
    private long runningTime;


    public void setThreadsAmount(int threadsAmount) {
        this.threadsAmount = threadsAmount;
    }

    @Override
    boolean run(Integer[] array) {
        int len = array.length;
        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);
        List<Future<Boolean>> futureList = new ArrayList<>();
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < threadsAmount; i++) {
            int threadNumber = i;
            Callable<Boolean> callable = () -> {
                for (int j = threadNumber; j < len; j = j + threadsAmount) {
                    if (PrimeChecker.isPrime(array[j])) {
                        return true;
                    }
                }
                return false;
            };
            Future<Boolean> future = executorService.submit(callable);
            futureList.add(future);
        }
        for (Future<Boolean> future : futureList) {
            try {
                if (future.get()) {
                    runningTime = System.currentTimeMillis() - currentTime;
                    executorService.shutdown();
                    return true;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        runningTime = System.currentTimeMillis() - currentTime;
        executorService.shutdown();
        return false;
    }

    @Override
    long getTime() {
        return runningTime;
    }
}
