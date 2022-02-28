import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    Notebook notebook = new Notebook();
    JsonBuilder gson = new JsonBuilder();
    @Test
    public void readFromFile() throws IOException {
        List<Note> notes = new ArrayList<>();
        Note note = new Note("Header", "Content");
        notebook.addNote("Header", "Content");
        notes.add(note);
        for (int i = 0; i < notes.size(); i++) {
            Assertions.assertEquals(notes.get(i).getTime().withNano(0), gson.readFromFile().get(i).getTime().withNano(0));
            Assertions.assertEquals(notes.get(i).getHeading(), gson.readFromFile().get(i).getHeading());
            Assertions.assertEquals(notes.get(i).getNote(), gson.readFromFile().get(i).getNote());
        }
    }

    @Test
    public void writeToFile() throws IOException {
        List<Note> notes = new ArrayList<>();
        Note note = new Note("Header", "Content");
        notes.add(note);
        gson.writeToFile(notes);
        for (int i = 0; i < notes.size(); i++) {
            Assertions.assertEquals(notes.get(i).getTime().withNano(0), gson.readFromFile().get(i).getTime().withNano(0));
            Assertions.assertEquals(notes.get(i).getHeading(), gson.readFromFile().get(i).getHeading());
            Assertions.assertEquals(notes.get(i).getNote(), gson.readFromFile().get(i).getNote());
        }
    }
}
