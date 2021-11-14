package Semester;

import java.util.ArrayList;
import java.util.List;

public class Semester {

    private static List<Subject> semester = new ArrayList<>();


    public void setGrade(String discipline,int grade) {
        semester.add(new Subject(discipline, grade));
    }

    public List<Integer> getGrades() {
       List<Integer> grades = new ArrayList<>();
       for(Subject i:semester){
           grades.add(i.getGrade());
       }
    return grades;
    }

}

