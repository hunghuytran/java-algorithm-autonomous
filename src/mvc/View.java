package mvc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
@dev create a program which register student by firstname and student id through view.
     create a button which print out the students in alphabetic order by last firstname.
*/


public class View extends JFrame implements ActionListener{
    /*
    @dev display the view.
    */
    private Model model;
    private JTextField firstname;
    private JTextField lastname;
    private JButton register;
    private JButton print;
    private GridBagConstraints grids = new GridBagConstraints();
    private int studentid = 0;
    private StudentListener studentListener;

    /*
    @dev constructor for the view, which designs the button and creates them.

    @param model the model class input.
    */
    public View(Model model) {
        super("Student Registration");
        this.model = model;

        int size = 10;
        firstname = new JTextField(size);
        lastname = new JTextField(size);
        register = new JButton("Register");
        print = new JButton("Print");

        /*
        @dev define and set type of grids that we will be using.
             add components to the grid. setup function creates element in
             JFrame based on the grids.
        */
        setLayout(new GridBagLayout());
        setup(0, 0, 1, 1, "Name: ");
        setup(1, 0, 1, 1, firstname);
        setup(0, 1, 1, 1, "Lastname: ");
        setup(1, 1, 1, 1, lastname);
        setup(1, 2, 1, 1, register);
        setup(2, 2, 1, 1, print);

        register.addActionListener(this);
        print.addActionListener(this);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
    @dev gets activated if the addActionListener is executed.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            String fname = firstname.getText();
            String lname = lastname.getText();
            Student student = new Student(fname, lname, studentid);
            studentid++;
            fire(student);
        }
        if (e.getSource() == print) {
            print();
        }
    }

    /*
    @dev setup the columns in grid.

    @param gridx x position.
    @param gridy y position.
    @param weightx weight x position.
    @param weighty weight y position.
    @param last param can either be a text, JButton or JFieldText
    */
    private void setup(int gridx, int gridy, int weightx, int weighty, String text) {
        grids.anchor = GridBagConstraints.LAST_LINE_END;
        grids.gridx = gridx;
        grids.gridy = gridy;
        grids.weightx = weightx;
        grids.weighty = weighty;
        grids.fill = GridBagConstraints.NONE;
        add(new JLabel (text), grids);
    }

    private void setup(int gridx, int gridy, int weightx, int weighty, JButton button) {
        grids.anchor = GridBagConstraints.LAST_LINE_START;
        grids.gridx = gridx;
        grids.gridy = gridy;
        grids.weightx = weightx;
        grids.weighty = weighty;
        grids.fill = GridBagConstraints.NONE;
        add(button, grids);
    }

    private void setup(int gridx, int gridy, int weightx, int weighty, JTextField field) {
        grids.anchor = GridBagConstraints.LAST_LINE_START;
        grids.gridx = gridx;
        grids.gridy = gridy;
        grids.weightx = weightx;
        grids.weighty = weighty;
        grids.fill = GridBagConstraints.NONE;
        add(field, grids);
    }

    /*
    @dev takes contact with the controller if the studentListener is not equal with null, in this case never.
         send information to an interface which the controller has implemented so the controller can read.
    */
    public void fire (Student event) {
        if (studentListener != null) {
            studentListener.addStudent(event);
        }
    }

    public void print() {
        if (studentListener != null) {
            studentListener.printList();
        }
    }

    /*
    @dev setup the controller, define which controller to use.
    */
    public void setStudentListener(StudentListener studentListener) {
        this.studentListener = studentListener;
    }
}
