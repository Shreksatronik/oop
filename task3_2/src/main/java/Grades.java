import Semester.Semester;

import java.util.*;
public class Grades {

    private int id;
    private String fullname;
    private String faculty;
    private final Semester[] semesters = new Semester[9];
    private int qualifyingWorkGrade;

    /**
     * тело зачетной книжки
     * @param id
     * @param fullname
     * @param faculty
     * @param qualifyingWorkGrade
     */
    public Grades(int id, String fullname, String faculty, int qualifyingWorkGrade) {
        this.id = id;
        this.fullname = fullname;
        this.faculty = faculty;
        this.qualifyingWorkGrade = qualifyingWorkGrade;
        for (int i = 1; i < 9; i++) {
            Semester s = new Semester();
            semesters[i] = s;
        }
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setFullName(int id) {
        this.fullname = fullname;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFaculty(int id) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setQualifyingWorkGrade(int qualifyingWorkGrade) {
        this.qualifyingWorkGrade = qualifyingWorkGrade;
    }

    public int getQualifyingWorkGrade() {
        return qualifyingWorkGrade;
    }

    /**
     * добавляет предмет и оценку за него
     * @param discipline
     * @param grade
     * @param semester
     */
    public void add (String discipline,int grade, int semester) {
        this.semesters[semester].setGrade(discipline,grade);
    }


    /**
     * выдает все оценки за выбранный семестр
     * @param sem
     * @return
     */

    public Collection<Integer> getSemesterGrades(int sem) {
        return semesters[sem].getGrades();
    }

    /**
     * будет ли повышенная стипендия
     * @param sem
     * @return
     */
    public boolean increasedScholarship(int sem) {
        Collection<Integer> marks = getSemesterGrades(sem);
        boolean result = true;
        for (int mark : marks) {
            if (mark < 4) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * выдает все оценки
     * @return
     */
    public ArrayList<Integer> getAllGrades() {
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            grades.addAll(semesters[i].getGrades());
        }
        return grades;
    }

    /**
     * меняет оценку
     * @param discipline
     * @param mark - новая оценка
     * @param cnt - номер семестра
     */
    public void ch(String discipline, int mark, int cnt) {
        semesters[cnt].changeGrade(discipline, mark);

    }

    /**
     * средняя оценка
     * @return
     */
    public double averageRating() {
        ArrayList<Integer> marks = getAllGrades();
        double result = 0.0;

        for (int mark : marks) {
            result += mark;
        }

        result /= marks.size();
        return result;

    }

    /**
     * будет ли красный диплом
     * @return
     */
    public boolean RedDiploma() {
        List<Integer> Grades = getAllGrades();
        long fives = 0;
        fives = Grades.stream().filter(g -> g == 5).count();
        double fivesCondition = (double) fives / Grades.size();
        return fivesCondition >= 0.75 && getQualifyingWorkGrade() == 5;
    }

}
