public class Metrics {
    private static HasPrimeMultiThread hasPrimeMultiThread;
    private static HasPrimesParallelStream hasPrimesParallelStream;
    private static HasPrimesSingleThread hasPrimesSingleThread;
    private static Integer[] array;
    private static final int ARRAY_SIZE = 1000000;
    private static final int TESTS_AMOUNT = 5;
    private static final int AVAILABLE_THREADS = Runtime.getRuntime().availableProcessors();
    private static long runningTime;
    private static long bestTime;


    public static void init() {
        hasPrimeMultiThread = new HasPrimeMultiThread();
        hasPrimesParallelStream = new HasPrimesParallelStream();
        hasPrimesSingleThread = new HasPrimesSingleThread();
        array = new Integer[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            array[i] = 1048561;
        }
        array[ARRAY_SIZE - 1] = 1048571;
        hasPrimeMultiThread.setThreadsAmount(1);
        bestTime = 999999999;
    }

    private static void singleThread(){
        System.out.println("========== SINGLE THREAD ==========");
        for (int i = 0; i < TESTS_AMOUNT; i++) {
            hasPrimesSingleThread.run(array);
            runningTime = hasPrimesSingleThread.getTime();
            if (runningTime < bestTime) {
                bestTime = runningTime;
            }
        }
        System.out.println("Best time for single thread is " + bestTime);
        System.out.println("===================================");
        bestTime = 999999999;
    }

    private static void parallelStream(){
        System.out.println("\n========= PARALLEL STREAM =========");
        for (int i = 0; i < TESTS_AMOUNT; i++) {
            hasPrimesParallelStream.run(array);
            runningTime = hasPrimesParallelStream.getTime();
            if (runningTime < bestTime) {
                bestTime = runningTime;
            }
        }
        System.out.println("Best time for parallel stream is " + bestTime);
        System.out.println("===================================");
        bestTime = 999999999;
    }

    private static void multiThread() throws InterruptedException {
        System.out.println("\n========== MULTI THREAD ===========");
        for (int j = 1; j <= AVAILABLE_THREADS; j++) {
            System.out.println("Current amount of threads is " + j);
            hasPrimeMultiThread.setThreadsAmount(j);
            for (int i = 0; i < TESTS_AMOUNT; i++) {
                hasPrimeMultiThread.run(array);
                runningTime = hasPrimeMultiThread.getTime();
                if (runningTime < bestTime) {
                    bestTime = runningTime;
                }
            }
            System.out.println("Best time for multi thread is " + bestTime);
            bestTime = 999999999;
            System.out.println("===================================");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        singleThread();
        parallelStream();
        multiThread();
    }
}
