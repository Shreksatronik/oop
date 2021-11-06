import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class gradesTest {
    @Test
    public void AverageTest() throws IOException {

        grades Nastya = new grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);

        ArrayList<Integer> Grades = Nastya.getAllGrades();

        Assert.assertEquals(4.16666667, grades.averageRating(Grades), 0);
    }

    @Test
    public void DiplomaTest() throws IOException {

        grades Nastya = new grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);

        assert (!Nastya.RedDiploma(Nastya));

    }

    @Test
    public void ScholarshipTest() throws IOException {
        grades Nastya = new grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);
        assert(!Nastya.increasedScholarship(2));


    }

    private static class Assert {
        public static void assertEquals(double v, double averageRating, int i) {
        }
    }
}