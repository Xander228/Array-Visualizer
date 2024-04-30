import java.awt.*;

public class Constants {

    public static final int DISPLAY_LOOPS_PER_SECOND = 100;
    public static final int DISPLAY_LOOP_TIME = 1000 / DISPLAY_LOOPS_PER_SECOND;

    public static final int SHUFFLE_TIME = 1000;

    public static final int BOARD_WIDTH = 800; //The visible width of the board, in pixels
    public static final int BOARD_HEIGHT = 400; //The visible width of the board, in pixels
    public static final int BOARD_BORDER_WIDTH = 15;
    public static final int BUTTON_HEIGHT = 100; //The visible width of the board, in pixels

    public static final double BAR_SPACE_RATIO = 2;

    public static final int ARRAY_LENGTH = 50;

    public static enum PanelStates {
        SHUFFLE_PHASE (),
        SORT_PHASE (),
        IDLE_PHASE ();

        PanelStates(){}
    }


    public static final Color BACKGROUND_COLOR = new Color((int)0x212121); //The color used as the background for most panels
    public static final  Color PRIMARY_COLOR = new Color((int)0x555555); //The color used to for headers and text for most panels
    public static final  Color ACCENT_COLOR = new Color((int)0x373737); //The color used to accent the headers and text for some panels
}


