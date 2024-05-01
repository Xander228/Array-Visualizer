import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;


public class ArrayPanel extends JPanel {

    private Timer timer;
    public static volatile int[] array;
    private int[] lastArray;
    private int[] swapedIndexes;
    public static volatile Constants.PanelStates panelState;


    ArrayPanel() {
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        setBackground(Constants.BACKGROUND_COLOR);

        this.panelState = Constants.PanelStates.SHUFFLE_PHASE;
        array = new int[Constants.ARRAY_LENGTH];
        for (int x = 0; x < Constants.ARRAY_LENGTH; x++) array[x] = Constants.ARRAY_LENGTH - x;

        timer = new Timer(Constants.DISPLAY_LOOP_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();
    }

    public void drawArray(Graphics g){
        for(int x = 0; x < Constants.ARRAY_LENGTH; x++){
            if(lastArray[x] != array[x]) swapedIndexes[x] = Constants.HIGHLIGHT_LOOP_TIME;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int maxValue = 0;
        for(int value : array) maxValue = Math.max(maxValue, value);

        double spaceWidth = (Constants.BOARD_WIDTH - (2.0 * Constants.BOARD_BORDER_WIDTH)) / (Constants.BAR_SPACE_RATIO * array.length + array.length - 1);
        double heightRatio = (Constants.BOARD_HEIGHT - (2.0 * Constants.BOARD_BORDER_WIDTH)) / maxValue;
        g.setColor(Constants.PRIMARY_COLOR);
        for(int x = 0; x < array.length; x++) {
            double barHeight = array[x] * heightRatio;
            Rectangle2D rect = new Rectangle2D.Double(
                    (Constants.BOARD_BORDER_WIDTH + (x * spaceWidth * (1 + Constants.BAR_SPACE_RATIO))),
                    Constants.BOARD_HEIGHT - barHeight - Constants.BOARD_BORDER_WIDTH,
                    (spaceWidth * Constants.BAR_SPACE_RATIO),
                    barHeight);
            g2.fill(rect);
        }
        lastArray =  array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArray(g);
    }
}
