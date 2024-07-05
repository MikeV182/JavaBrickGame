import java.awt.*;
import javax.swing.*;

public class Player extends JPanel {
    private static final int PADDLE_WIDTH = 180;
    private static final int PADDLE_HEIGHT = 10;

    public Player(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.YELLOW);
        g2D.fillRect(565, 1000, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
}
