package mvc;
import java.util.ArrayList;
import java.util.Collections;

/*
@dev create a program which register student by name and student id through view.
     create a button which print out the students in alphabetic order by last name.
*/


public class Model{
    private ArrayList<Student> students = new ArrayList<>();

    /*
    @dev prints out the result. Is activated through the controller.
    */
    public void results() {
        Collections.sort(students, Student.StudentLastNameComparator);
        System.out.println("Here is the sorted list of students according to lastname:\n");
        for(Student student : students) {
            System.out.println(student.getLastname() + " " + student.getFirstname() + ", student number: " + student.getId());
        }
    }

    /*
    @dev prints out information.
    */
    public void added(Student student) {
        System.out.println("The following student has been added to our members:\n" + student.getFirstname() + " " + student.getLastname() + "\n");
    }

    /*
    @dev getter for the arraylist students.
    */
    public ArrayList<Student> getStudents() {
        return students;
    }
}
