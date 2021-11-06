package Semester;

import java.util.Collection;
import java.util.HashMap;

public class Semester {

        private HashMap<String, Integer> semester = new HashMap<String, Integer>();

        public void setGrade(String discipline, int grade) {
            this.semester.put(discipline, grade);
        }
        public Collection<Integer> getGrades() {
            return this.semester.values();
        }
}
