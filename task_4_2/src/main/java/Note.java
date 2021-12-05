import java.time.LocalDateTime;

public class Note {
    private LocalDateTime time;
    private String heading;
    private String note;

    Note(String heading, String note) {
        this.time = LocalDateTime.now();
        this.heading = heading;
        this.note = note;
    }

    public LocalDateTime getTime() {
        return time;
    }

    /**
     * @return the heading of the note
     */
    public String getHeading() {
        return this.heading;
    }

    /**
     * @return the note content
     */
    public String getNote() {
        return note;
    }
}
