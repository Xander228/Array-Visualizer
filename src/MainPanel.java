import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

    private enum PanelStates {
        SHUFFLE_PHASE (),
        SORT_PHASE (),
        IDLE_PHASE ();

        PanelStates(){}
    }


    private PanelStates panelState;
    private MainFrame frame;
    private ButtonPanel buttonPanel;
    private ArrayPanel arrayPanel;
    private int[] array;

    MainPanel(MainFrame frame) {
        this.frame = frame;
        this.panelState = PanelStates.SHUFFLE_PHASE;
        setBorder(BorderFactory.createMatteBorder(10,10,10,10,Constants.ACCENT_COLOR)); //Add a border around the frame
        setBackground(Constants.ACCENT_COLOR); //Set the background color of the panel
        setLayout(new BorderLayout(10,10)); //Sets the edge offset of member panels to properly space them

        array = new int[Constants.ARRAY_LENGTH];
        for (int x = 0; x < Constants.ARRAY_LENGTH; x++) array[x] = x + 1;

        buttonPanel = new ButtonPanel(frame);
        arrayPanel = new ArrayPanel(array);

        add(arrayPanel);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    public void run(){
        switch(this.panelState) {

            case SHUFFLE_PHASE:
                    int index1 = (int)(Math.random() * array.length);
                    int index2 = (int)(Math.random() * array.length);
                    int buffer = array[index1]; //Copy the value of index1
                    array[index1] = array[index2]; //Write index2 to index1
                    array[index2] = buffer; //Write the original value of index1 to index2
                    arrayPanel.repaint();
                break;

            case SORT_PHASE:


                break;

            case IDLE_PHASE:


                break;
        }
    }

    public void setPhaseStart(){
        panelState = PanelStates.SORT_PHASE;
    }

    public void setPhaseStop(){
        panelState = PanelStates.IDLE_PHASE;
    }

    public void setPhaseShuffle(){
        panelState = PanelStates.SHUFFLE_PHASE;
    }
}
