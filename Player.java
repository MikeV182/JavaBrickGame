import java.awt.*;
import javax.swing.*;

public class Player extends JLabel implements Constants {
    public Player() {
        setBounds(PADDLE_X, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        setBackground(Color.YELLOW);
        setOpaque(true);
    }
}
