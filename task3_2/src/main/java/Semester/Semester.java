package Semester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Semester {

    private static List<Subject> semester = new ArrayList<>();

    /**
     * setGrade - добавляет дисциплину и оценку
     * @param discipline
     * @param grade
     */


    public void setGrade(String discipline,int grade) {
        semester.add(new Subject(discipline, grade));
    }

    /**
     * changeGrade - меняет оценку за предмет
     * @param discipline
     * @param newgrade - новая оценка
     */
    public void changeGrade(String discipline, int newgrade) {
        for(int i = 0;i<semester.size();i++){
            if(semester.get(i).getDiscipline().equals(discipline)){
                semester.get(i).setGrades(newgrade);
                return;
            }
        }
    }

    /**
     * выдает список оуенок
     * @return
     */
    public List<Integer> getGrades() {
       List<Integer> grades = new ArrayList<>();
       for(Subject i:semester){
           grades.add(i.getGrade());
       }
    return grades;
    }

}

