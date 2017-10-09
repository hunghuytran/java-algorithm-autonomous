package mvc;

/*
@dev create a program which register student by name and student id through view.
     create a button which print out the students in alphabetic order by last name.
*/

public class Controller implements StudentListener{
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void addStudent(Student event) {
        model.getStudents().add(event);
        model.added(event);
    }

    @Override
    public void printList() {
        model.results();
    }

    /*
    @dev interface which takes a class. implement the interface in class.
    */
}
