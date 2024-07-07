import java.awt.*;
import javax.swing.*;

public class Ball extends JLabel implements Constants {
    public Ball() {
        setBounds(BALL_X, BALL_Y, BALL_D, BALL_D);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.ORANGE);
        g2D.fillOval(0, 0, BALL_D, BALL_D);
    }
}
