import java.awt.*;
import javax.swing.*;

public class Player extends JLabel {
    private static final int PADDLE_WIDTH = 180;
    private static final int PADDLE_HEIGHT = 10;
    private static final int PADDLE_X = 550;
    private static final int PADDLE_Y = 960;

    public Player() {
        setBounds(PADDLE_X, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        setBackground(Color.YELLOW);
        setOpaque(true);
    }
}
