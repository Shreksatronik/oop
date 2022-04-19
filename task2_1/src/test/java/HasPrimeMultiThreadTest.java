import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasPrimeMultiThreadTest {
    private HasPrimeMultiThread hasPrimeMultiThread;
    private Integer[] array;
    private final int ARRAY_SIZE = 1000000;
    @BeforeEach
    public void init(){
        hasPrimeMultiThread = new HasPrimeMultiThread();
        array = new Integer[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            array[i] = 1048561;
        }
        array[ARRAY_SIZE - 1] = 1048571;
        hasPrimeMultiThread.setThreadsAmount(Thread.activeCount());
    }

    @Test
    public void multiThreadPrimeCheck(){
        Assertions.assertTrue(hasPrimeMultiThread.run(array));
    }
}