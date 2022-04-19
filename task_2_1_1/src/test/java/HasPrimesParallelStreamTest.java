import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HasPrimesParallelStreamTest {
    private HasPrimesParallelStream hasPrimesParallelStream;
    private Integer[] array;
    private final int ARRAY_SIZE = 1000000;
    @BeforeEach
    public void init(){
        hasPrimesParallelStream = new HasPrimesParallelStream();
        array = new Integer[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            array[i] = 1048561;
        }
        array[ARRAY_SIZE - 1] = 1048571;
    }

    @Test
    public void parallelStreamPrimeCheck(){
        Assertions.assertTrue(hasPrimesParallelStream.run(array));
    }
}