import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SubstringSearchTest {
    @Test
    public void work_or_not_test() throws IOException, SubstringSearch.NoString {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] ans = KMP.KMP("test1.txt", "pirog");
        assert (ans[0] == 9);

    }

   @Test
    public void null_string() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
       SubstringSearch.NoString e = assertThrows(SubstringSearch.NoString.class, () ->
       {Integer[] arr =KMP.KMP("test2.txt", "");});
       assertEquals("The substring is empty",e.getMessage());
    }

    @Test
    public void test_no_file() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        var e = assertThrows(IllegalArgumentException.class, () -> {
            Integer[] arr =KMP.KMP("test0.txt", "pirog");
        });
        assertEquals("No file", e.getMessage());
    }


    @Test
    public void errorString() throws IOException, SubstringSearch.NoString {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] ans =KMP.KMP("test1.txt", "baklagan");
        Integer[] arr = {};
        assertArrayEquals(ans,arr);
    }

}
