import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;


public class ArrayPanel extends JPanel {

    private Timer timer;
    public static volatile MonitoredArray array;
    private int[] writtenIndexes;
    private int[] readIndexes;
    public static volatile Constants.PanelStates panelState;


    ArrayPanel() {
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        setBackground(Constants.BACKGROUND_COLOR);

        panelState = Constants.PanelStates.SHUFFLE_PHASE;
        array = new MonitoredArray(Constants.ARRAY_LENGTH);
        writtenIndexes = new int[Constants.ARRAY_LENGTH];
        readIndexes = new int[Constants.ARRAY_LENGTH];
        for (int x = 0; x < Constants.ARRAY_LENGTH; x++) array.set(x, Constants.ARRAY_LENGTH - x);

        timer = new Timer(Constants.DISPLAY_LOOP_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();
    }

    public void drawArray(Graphics g){
        boolean[] wasWritten = array.getWasWritten();
        boolean[] wasRead = array.getWasRead();
        for(int x = 0; x < Constants.ARRAY_LENGTH; x++) if(wasWritten[x]) writtenIndexes[x] = Constants.HIGHLIGHT_LOOP_TIME;
        for(int x = 0; x < Constants.ARRAY_LENGTH; x++) if(wasRead[x]) readIndexes[x] = Constants.HIGHLIGHT_LOOP_TIME;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int maxValue = 0;
        for(int x = 0; x < array.length; x++) maxValue = Math.max(maxValue, array.getSilently(x));

        double spaceWidth = (Constants.BOARD_WIDTH - (2.0 * Constants.BOARD_BORDER_WIDTH)) / (Constants.BAR_SPACE_RATIO * array.length + array.length - 1);
        double heightRatio = (Constants.BOARD_HEIGHT - (2.0 * Constants.BOARD_BORDER_WIDTH)) / maxValue;
        g.setColor(Constants.PRIMARY_COLOR);
        for(int x = 0; x < array.length; x++) {
            g.setColor(wasWritten[x] ? Constants.WRITTEN_COLOR : wasRead[x] ? Constants.READ_COLOR : Constants.PRIMARY_COLOR);
            if(writtenIndexes[x] >= 0) writtenIndexes[x]--;
            double barHeight = array.getSilently(x) * heightRatio;
            Rectangle2D rect = new Rectangle2D.Double(
                    (Constants.BOARD_BORDER_WIDTH + (x * spaceWidth * (1 + Constants.BAR_SPACE_RATIO))),
                    Constants.BOARD_HEIGHT - barHeight - Constants.BOARD_BORDER_WIDTH,
                    (spaceWidth * Constants.BAR_SPACE_RATIO),
                    barHeight);
            g2.fill(rect);
        }
    }

    public static void resetArray(){
        array = new MonitoredArray(Constants.ARRAY_LENGTH);
        for (int x = 0; x < Constants.ARRAY_LENGTH; x++) array.set(x, Constants.ARRAY_LENGTH - x);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArray(g);
    }
}
