package Semester;

import java.util.ArrayList;

public class Subject {
    String discipline;
    int grade;

    /**
     * устанавливает оценку и дисцилину
     * @param discipline
     * @param grade
     */
    public Subject(String discipline, int grade) {
        this.discipline = discipline;
        this.grade = grade;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrades(int grade)
    {
        this.grade = grade;
    }

    }
