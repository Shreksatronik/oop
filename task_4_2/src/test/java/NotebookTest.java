import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotebookTest {


    @Test
    public void parseTest() throws ParseException, IOException, org.apache.commons.cli.ParseException {
        Main Arguments = new Main();
        Notebook notebook = new Notebook();
        notebook.removeNote("Header");
        String[] args = {"-add", "Header", "Content"};
        Arguments.mainCaller(args);
        Note note = new Note();
        note.setHeading("Header");
        note.setNote("Content");
        Note result = notebook.showAllNotes().get(notebook.showAllNotes().size() - 1);
        Assertions.assertEquals(note.getTime().withNano(0), result.getTime().withNano(0));
        Assertions.assertEquals(note.getHeading(), result.getHeading());
        Assertions.assertEquals(note.getNote(), result.getNote());
    }
}
    class JsonTest {
        Notebook notebook = new Notebook();
        JsonBuilder gson = new JsonBuilder();

        @Test
        public void readFromFile() throws IOException {
            List<Note> notes = new ArrayList<>();
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notebook.addNote("Header", "Content");
            notes.add(note);
            note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
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
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notes.add(note);
            note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notes.add(note);
            gson.writeToFile(notes);
            for (int i = 0; i < notes.size(); i++) {
                Assertions.assertEquals(notes.get(i).getTime().withNano(0), gson.readFromFile().get(i).getTime().withNano(0));
                Assertions.assertEquals(notes.get(i).getHeading(), gson.readFromFile().get(i).getHeading());
                Assertions.assertEquals(notes.get(i).getNote(), gson.readFromFile().get(i).getNote());
            }
        }

           @Test
        public void noteTime() {
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            LocalDateTime time = LocalDateTime.now().withNano(0);
            Assertions.assertEquals(note.getTime().withNano(0), time);
        }



        @Test
        public void noteHeader() {
            Note note = new Note();
            note.setHeading("Heading");
            note.setNote("Content");
            Assertions.assertEquals(note.getHeading(), "Heading");
        }

        @Test
        public void noteContent() {
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            Assertions.assertEquals(note.getNote(), "Content");
        }


        @Test
        public void addTest() throws IOException {
            Notebook notebook = new Notebook();
            notebook.addNote("Header", "Content");
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            Assertions.assertEquals(note.getTime().withNano(0), notebook.showAllNotes().get(0).getTime().withNano(0));
            Assertions.assertEquals(note.getHeading(), notebook.showAllNotes().get(0).getHeading());
            Assertions.assertEquals(note.getNote(), notebook.showAllNotes().get(0).getNote());
        }


        @Test
        public void showAllNotes() throws IOException {
            Notebook notebook = new Notebook();

            List<Note> notes = new ArrayList<>();
            notebook.addNote("Header", "Content");
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notebook.addNote("Header", "Content");
            note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notebook.addNote("Header", "Content");
            note = new Note();
            note.setHeading("Header");
            note.setNote("Hello");
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
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            notebook.addNote("Header", "Content");
            Note result = notebook.showNotesPeriod(timeToTest,
                    LocalDateTime.parse("2022-11-25T18:12:40")).get(0);

            Assertions.assertEquals(result.getNote(), note.getNote());

        }

        @Test
        public void findNotesPeriodSubwords() throws IOException {
            Notebook notebook = new Notebook();

            List<String> subwords = new ArrayList<>();
            subwords.add("Header");
            notebook.addNote("Header", "Content");
            notebook.addNote("Header", "Content");
            notebook.addNote("Header", "Content");
            Note note = new Note();
            note.setHeading("Header");
            note.setNote("Content");
            Note result = notebook.findNotesPeriodSwords(LocalDateTime.parse("2020-11-25T18:12:40"),
                    LocalDateTime.parse("2022-11-25T18:12:40"), subwords).get(0);
            Assertions.assertEquals(result.getNote(), note.getNote());
        }
    }
