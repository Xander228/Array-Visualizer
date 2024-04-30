import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ButtonPanel extends JPanel {
    ButtonPanel(MainFrame frame){
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BUTTON_HEIGHT));
        setBorder(BorderFactory.createMatteBorder(25, 50, 25, 50, Constants.BACKGROUND_COLOR));
        setLayout(new BorderLayout(200, 0));
        setBackground(Constants.BACKGROUND_COLOR);

        class GameButton extends JButton {
            GameButton(String text){
                super(text);
                this.setFocusable(false);
                this.setPreferredSize(new Dimension(100, 30));
                this.setBackground(Constants.PRIMARY_COLOR);
                this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Constants.ACCENT_COLOR));
                this.setFont(new Font("Arial", Font.BOLD, 16));
                this.setForeground(Constants.BACKGROUND_COLOR);
            }
        }

        JButton start = new GameButton("Start");

        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayPanel.panelState = Constants.PanelStates.SORT_PHASE;
                Thread t = new Thread(BubbleSort::sort);
                t.start();
                t.interrupt();
            }
        });

        JButton stop = new GameButton("Stop");
        stop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayPanel.panelState = Constants.PanelStates.IDLE_PHASE;
            }
        });

        JButton shuffle = new GameButton("Shuffle");
        shuffle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayPanel.panelState = Constants.PanelStates.SHUFFLE_PHASE;
                new Thread(Shuffle::run).start();
            }
        });

        add(start, BorderLayout.WEST);
        add(stop);
        add(shuffle, BorderLayout.EAST);
    }
}
