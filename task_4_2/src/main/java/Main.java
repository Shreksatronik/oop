import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static Notebook notebook = new Notebook();
    public void mainCaller(String[] line) throws ParseException, org.apache.commons.cli.ParseException {
        main(line);
    }

    public static void main(String[] args)throws ParseException{

        try {
            if (Objects.equals(args[0], "-add")) {
                add(args);
            }
            else if(Objects.equals(args[0], "-rm")){
                remove(args);
            }
            else if(Objects.equals(args[0], "-show")){
                show(args);
            }
           }
             catch (IOException e) {
            System.out.println("Wrong command");
        }
    }

    public static void add(String[] args) throws IOException {
        notebook.addNote(args[1], args[2]);
    }

    public static void remove(String[] args) throws IOException {
        notebook.removeNote(args[1]);
    }

    public static void show(String[] args) throws IOException {

        if (args == null) {
            List<Note> notes = notebook.showAllNotes();
            if (notes.size() == 0) {
                System.out.println("You have no notes added");
            } else {
                for (Note i : notes) {
                    System.out.println(i.getTime());
                    System.out.println(i.getHeading());
                    System.out.println(i.getNote());
                }
            }
        } else if (Arrays.stream(args).count() == 2) {
            try {
                List<Note> notes = notebook.showNotesPeriod(LocalDateTime.parse(args[1]),
                        LocalDateTime.parse(args[2]));
                for (Note i : notes) {
                    System.out.println(i.getTime());
                    System.out.println(i.getHeading());
                    System.out.println(i.getNote());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out of bounds show notes period on time");
            }

        } else {
            try {
                List<Note> notes = notebook.findNotesPeriodSwords(LocalDateTime.parse(args[1]),
                        LocalDateTime.parse(args[2]),
                        Arrays.stream(args).toList());

                for (Note i : notes) {
                    System.out.println(i.getTime());
                    System.out.println(i.getHeading());
                    System.out.println(i.getNote());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You have no notes added to fit such params");
            }
        }
    }
}
