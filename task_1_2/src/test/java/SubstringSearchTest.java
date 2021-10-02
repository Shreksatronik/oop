import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        assert (ans==null);

    }
    @Test
    public void errorString() throws IOException {
        SubstringSearch KMP = new SubstringSearch();
        Integer[] a =KMP.KMP("test1.txt", "baklagan");
        assert(a==null);
    }
    
}
