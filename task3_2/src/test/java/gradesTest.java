import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gradesTest {
    @Test
    public void AverageTest() {
        Grades Nastya = new Grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);

        assertEquals(4.16, Nastya.averageRating(), 0.01);
    }

    @Test
    public void DiplomaTest() {
        Grades Nastya = new Grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);

        assertFalse(Nastya.RedDiploma());
    }

    @Test
    public void ScholarshipTest() {
        Grades Nastya = new Grades(200776, "A.D. Ordina", "Fit", 4);
        Nastya.add("OCT", 5, 1);
        Nastya.add("History", 5, 1);
        Nastya.add("Imperative programming", 4, 2);
        Nastya.add("Declarative programming", 4, 2);
        Nastya.add("Math analysys", 4, 2);
        Nastya.add("English", 3, 2);

        assertFalse(Nastya.increasedScholarship(2));
    }

}