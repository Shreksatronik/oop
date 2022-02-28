import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Notetest {

    @Test
    public void noteTime() {
        Note note = new Note("Heading", "Note Content");
        LocalDateTime time = LocalDateTime.now().withNano(0);
        Assertions.assertEquals(note.getTime().withNano(0), time);
    }

    @Test
    public void noteHeader() {
        Note note = new Note("Heading", "Note Content");
        Assertions.assertEquals(note.getHeading(), "Heading");
    }

    @Test
    public void noteContent() {
        Note note = new Note("Heading", "Content");
        Assertions.assertEquals(note.getNote(), "Content");
    }

}
