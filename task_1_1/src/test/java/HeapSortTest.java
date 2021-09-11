import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapSortTest {
    @Test
    public void arraySortTest(){
        HeapSort sort = new HeapSort();
        int []ans = {1,2,3,4,5};
        int []arr = {5,2,3,1,4};
        sort.sort(arr);
        Assertions.assertArrayEquals(ans,arr);
    }
}

