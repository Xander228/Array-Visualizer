import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private Timer timer; //Declare to timer

    private JPanel mainPanel;
    private ButtonPanel buttonPanel;
    private ArrayPanel arrayPanel;

    public Main() {
        //Set up the frame properties
        setTitle("Sort"); //Title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Behavior on close, exits the program when the frame is closed
        setResizable(false); //sets the frame to a fixed size, not resizeable by a user

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Constants.PRIMARY_COLOR)); //Add a border around the frame
        mainPanel.setBackground(Constants.PRIMARY_COLOR); //Set the background color of the panel
        mainPanel.setLayout(new BorderLayout(10, 10)); //Sets the edge offset of member panels to properly space them

        buttonPanel = new ButtonPanel(this);
        arrayPanel = new ArrayPanel();

        mainPanel.add(arrayPanel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
        pack();


        //Set up a Timer to run the game loop
        //Creates a new timer object with a delay equal to LOOP_TIME which is the time it takes for one loop
        timer = new Timer(Constants.LOOP_TIME, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                    }
                }
        );


        setFocusable(true);

        //Start the timer
        timer.start();

        //Set the frame visible
        setVisible(true);
    }


    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Main();
            }
        });
    }
}