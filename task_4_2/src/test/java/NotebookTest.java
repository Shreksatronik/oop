import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotebookTest {
    @BeforeEach
    public void init() throws IOException {
        notebook.removeNote("Header");
    }
        Notebook notebook = new Notebook();
        @Test
        public void addTest() throws IOException {
            Notebook notebook = new Notebook();
            notebook.addNote("Header", "Note Content");
            Note note = new Note("Header", "Note Content");
            Assertions.assertEquals(note.getTime().withNano(0), notebook.showAllNotes().get(0).getTime().withNano(0));
            Assertions.assertEquals(note.getHeading(), notebook.showAllNotes().get(0).getHeading());
            Assertions.assertEquals(note.getNote(), notebook.showAllNotes().get(0).getNote());
        }

    @Test
    public void removeTest() throws IOException {
        notebook.addNote("Stay", "with me");
        Note note = new Note("Stay", "with me");
        notebook.addNote("Header", "The new note content");
        notebook.removeNote("Header");
        Assertions.assertEquals(note.getTime().withNano(0), notebook.showAllNotes().get(0).getTime().withNano(0));
        Assertions.assertEquals(note.getHeading(), notebook.showAllNotes().get(0).getHeading());
        Assertions.assertEquals(note.getNote(), notebook.showAllNotes().get(0).getNote());
    }

        @Test
        public void showAllNotes() throws IOException {
            Notebook notebook = new Notebook();
            List<Note> notes = new ArrayList<>();
            notebook.addNote("Header", "Content");
            notes.add(new Note("Header", "Content"));
            notebook.addNote("Header", "Content");
            notes.add(new Note("Header", "Content"));
            for (int i = 0; i < notes.size(); i++) {
                Assertions.assertEquals(notes.get(i).getTime().withNano(0), notebook.showAllNotes().get(i).getTime().withNano(0));
                Assertions.assertEquals(notes.get(i).getHeading(), notebook.showAllNotes().get(i).getHeading());
                Assertions.assertEquals(notes.get(i).getNote(), notebook.showAllNotes().get(i).getNote());
            }
        }




        @Test
        public void showNotesPeriod () throws IOException, InterruptedException {
            Notebook notebook = new Notebook();
            notebook.addNote("Header", "Content");
            notebook.addNote("Header", "Content");
            LocalDateTime timeToTest = LocalDateTime.now();
            Thread.sleep(1000);
            Note note = new Note("Hello", "This is the note");
            notebook.addNote("Hello", "This is the note");
            Note result = notebook.showNotesPeriod(timeToTest,
                    LocalDateTime.parse("2022-11-25T18:12:40")).get(0);

            Assertions.assertEquals(result.getNote(), note.getNote());

        }

        @Test
        public void findNotesPeriodSubwords() throws IOException {
            List<String> subwords = new ArrayList<>();
            subwords.add("Header");
            LocalDateTime timeToTest = LocalDateTime.now();
            notebook.addNote("Header", "Hello");
            notebook.addNote("Header", "This is the note");
            Note note = new Note("Header", "This is the note");
            Note result = notebook.findNotesPeriodSwords(timeToTest,
                    LocalDateTime.parse("2022-11-25T18:12:40"), subwords).get(0);
            Assertions.assertEquals(result.getNote(), note.getNote());
        }
        }
