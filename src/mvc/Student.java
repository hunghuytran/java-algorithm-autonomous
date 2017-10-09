package mvc;

import java.util.Comparator;

public class Student{
    private String firstname;
    private String lastname;
    private int id;

    public Student(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    public static Comparator<Student> StudentLastNameComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getLastname().toUpperCase();
            String StudentName2 = s2.getLastname().toUpperCase();
            return StudentName1.compareTo(StudentName2);
        }};
}
