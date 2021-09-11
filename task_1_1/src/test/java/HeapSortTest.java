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
    @Test
    public void test2(){
        HeapSort sort = new HeapSort();
        int []ans = {1,2,3,4,2147483647};
        int []arr = {3,1,4,2,2147483647};
        sort.sort(arr);
        Assertions.assertArrayEquals(ans,arr);
    }
    @Test
    public void test3(){
        HeapSort sort = new HeapSort();
        int []ans = {-2147483647,1,2,3,4};
        int []arr = {3,1,4,2,-2147483647};
        sort.sort(arr);
        Assertions.assertArrayEquals(ans,arr);
    }
    @Test
    public void test4(){
        HeapSort sort = new HeapSort();
        int []ans = {1};
        int []arr = {1};
        sort.sort(arr);
        Assertions.assertArrayEquals(ans,arr);
    }
    @Test
    public void test5(){
        HeapSort sort = new HeapSort();
        int []ans = {};
        int []arr = {};
        sort.sort(arr);
        Assertions.assertArrayEquals(ans,arr);
    }
}

