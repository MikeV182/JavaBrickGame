import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ball extends JLabel implements ActionListener, Constants {
    Timer timer;

    public Ball() {
        setBounds(BALL_X, BALL_Y, BALL_D, BALL_D);
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.ORANGE);
        g2D.fillOval(0, 0, BALL_D, BALL_D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setLocation(this.getX() + BALL_VELOCITY, this.getY() - BALL_VELOCITY);
        repaint();
    }
}
