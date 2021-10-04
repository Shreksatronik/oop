import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SubstringSearchTest {
    @Test
    public void work_or_not_test() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] ans = KMP.KMP("test1.txt", "pirog");
        assert (ans[0] == 9);

    }

   @Test
    public void no_file() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        Throwable thrown = assertThrows(IOException.class, () -> {
            Integer[] ans = KMP.KMP("test0.txt", "pirog");
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void null_string() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] ans = KMP.KMP("test1.txt", "");
        Integer[] arr = {};
        assertArrayEquals(ans,arr);

    }
    @Test
    public void errorString() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] ans =KMP.KMP("test1.txt", "baklagan");
        Integer[] arr = {};
        assertArrayEquals(ans,arr);
    }

}
