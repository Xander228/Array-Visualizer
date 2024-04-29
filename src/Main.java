import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private Timer timer; //Declare to timer

    private MainPanel mainPanel;


    public Main() {
        //Set up the frame properties
        setTitle("Sort"); //Title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Behavior on close, exits the program when the frame is closed
        setResizable(false); //sets the frame to a fixed size, not resizeable by a user

        mainPanel = new MainPanel(this);
        add(mainPanel);
        pack();


        //Set up a Timer to run the game loop
        //Creates a new timer object with a delay equal to LOOP_TIME which is the time it takes for one loop
        timer = new Timer(Constants.LOOP_TIME, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.run();

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