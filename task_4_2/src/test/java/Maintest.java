import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

public class Maintest {

    @Test
    public void parseTest() throws ParseException, IOException, org.apache.commons.cli.ParseException {
        Main Arguments = new Main();
        Notebook notebook = new Notebook();
        String[] line = {"-add", "Header", "Content"};
        Note note = new Note("Header", "Content");
        Arguments.mainCaller(line);
        Note result = notebook.showAllNotes().get(notebook.showAllNotes().size() - 1);
        Assertions.assertEquals(note.getTime().withNano(0), result.getTime().withNano(0));
        Assertions.assertEquals(note.getHeading(), result.getHeading());
        Assertions.assertEquals(note.getNote(), result.getNote());
    }
}
