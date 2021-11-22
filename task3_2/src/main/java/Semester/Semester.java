package Semester;

import java.util.ArrayList;
import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.stream.Stream;
>>>>>>> Stashed changes

public class Semester {

    private static List<Subject> semester = new ArrayList<>();


    public void setGrade(String discipline,int grade) {
        semester.add(new Subject(discipline, grade));
    }

<<<<<<< Updated upstream
=======
    public void changeGrade(String discipline, int newgrade) {
        for(int i = 0;i<semester.size();i++){
            if(semester.get(i).getDiscipline().equals(discipline)){
                semester.get(i).setGrades(newgrade);
                return;
            }
        }
    }


>>>>>>> Stashed changes
    public List<Integer> getGrades() {
       List<Integer> grades = new ArrayList<>();
       for(Subject i:semester){
           grades.add(i.getGrade());
       }
    return grades;
    }

}

