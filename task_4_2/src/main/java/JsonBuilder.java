import com.google.gson.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
public class JsonBuilder {

       private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                    (json, typeOfT, context) ->
            LocalDateTime.parse(json.getAsString(), dtf.withLocale(Locale.ENGLISH)))
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>)
                    (src, typeOfSrc, context) -> new JsonPrimitive(dtf.format(src))).setPrettyPrinting().create();

        /**
         * @return list of all notes from the file
         * @throws IOException if the file is not exist
         */
        public List<Note> readFromFile() throws IOException {
            try {
                File file = new File("test.json");
                if (file.length() == 0) {
                    FileWriter fileWriter = new FileWriter("test.json");
                    fileWriter.write("[]");
                    fileWriter.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file wasn't found");
            }

            try (FileReader reader = new FileReader("test.json")) {
                return Arrays.stream(gson.fromJson(reader, Note[].class)).toList();
            }
        }

        /**
         * @param notes is a list on notes to write to file
         */
        public void writeToFile(List<Note> notes) throws IOException {
            try  {
                FileWriter fileWriter = new FileWriter("test.json");
                gson.toJson(notes, fileWriter);
                fileWriter.close();

            } catch (FileNotFoundException e) {
                System.out.println("The file hasn't been found");
            }
        }
    }
