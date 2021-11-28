import java.time.LocalDateTime;

public class Note {
    private LocalDateTime time;
    private String heading;
    private String note;


    /**
     * @return the date of note's creation
     */
    public LocalDateTime getTime() {
        return time.now();
    }

    /**
     * @return the heading of the note
     */
    public String getHeading() {
        return this.heading;
    }
    /**
     * @return set heading
     */
    public String setHeading(String title){
        return this.heading  = title;
    }

    /**
     * @return the note content
     */
    public String getNote() {
        return note;
    }

    /**
     * @return set note
     */

    public String setNote(String note){
        return this.note = note;
    }
}
