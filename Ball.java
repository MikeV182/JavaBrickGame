import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ball extends JLabel implements ActionListener, Constants {
    Timer timer;
    private int moveX = BALL_VELOCITY;
    private int moveY = -BALL_VELOCITY;

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
        moveBall();
        repaint();
    }

    private void moveBall() {
        setLocation(this.getX() + moveX, this.getY() + moveY);
        if (this.getX() + BALL_D >= SCREEN_WIDTH || this.getX() <= 0) {
            moveX = -moveX;
        }
        //TODO: remove "|| this.getY() >= SCREEN_HEIGHT" condition in final version - only for testing purposes
        if (this.getY() <= 0 || this.getY() >= SCREEN_HEIGHT || paddleCollision()) {
            moveY = -moveY;
        }
    }

    private boolean paddleCollision() {
        if (GameWindow.getPlayer().getX() <= this.getX() && 
            this.getX() <= GameWindow.getPlayer().getX() + PADDLE_WIDTH && 
            GameWindow.getPlayer().getY() <= this.getY() + BALL_D) {
            return true;
        }
        return false;
    }

}
