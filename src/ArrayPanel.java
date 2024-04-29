import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


public class ArrayPanel extends JPanel {

    private JPanel subPanel;
    private int[] array;

    ArrayPanel() {
        setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        setBackground(Constants.BACKGROUND_COLOR);
        array = new int[Constants.ARRAY_LENGTH];
        for (int x = 0; x < Constants.ARRAY_LENGTH; x++) array[x] = x;
        repaint();
    }

    public void drawArray(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arrayLength = array.length;
        int maxValue = 0;
        for(int value : array) maxValue = Math.max(maxValue, value);

        double spaceWidth = (Constants.BOARD_WIDTH - (2.0 * Constants.BOARD_BORDER_WIDTH)) / (Constants.BAR_SPACE_RATIO * arrayLength + arrayLength - 1);
        double lengthRatio = (Constants.BOARD_WIDTH - (2.0 * Constants.BOARD_BORDER_WIDTH)) / arrayLength;
        double heightRatio = (Constants.BOARD_HEIGHT - (2.0 * Constants.BOARD_BORDER_WIDTH)) / maxValue;
        g.setColor(Constants.PRIMARY_COLOR);
        for(int x = 0; x < arrayLength; x++) {
            int barHeight = array[x] * heightRatio;
            System.out.println((Constants.BOARD_BORDER_WIDTH + (x * spaceWidth * (1 + Constants.BAR_SPACE_RATIO))));
            Rectangle2D rect = new Rectangle2D.Double(
                    (Constants.BOARD_BORDER_WIDTH + (x * spaceWidth * (1 + Constants.BAR_SPACE_RATIO))),
                    Constants.BOARD_HEIGHT - barHeight,
                    (spaceWidth * Constants.BAR_SPACE_RATIO),
                    barHeight);
            g2.fill(rect);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArray(g);
    }
}
