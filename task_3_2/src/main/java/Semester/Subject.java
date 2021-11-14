package Semester;

public class Subject {
    String discipline;
    int grade;

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

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
