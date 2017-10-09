package mvc;

/*
@dev create a program which register student by name and student id through view.
     create a button which print out the students in alphabetic order by last name.
*/

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        /*
        @dev create view, model and controller.
             set view to visible.
        @variable model holds data.
        @variable view takes a Model in its constructor.
        @variable controller takes View and Model in its constructor.
        */
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);

        /*
        @dev set the controller to the function setStudentListener.
        */
        view.setStudentListener(controller);
    }
}
