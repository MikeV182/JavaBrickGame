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
        brickCollision();
        screenBordersCollision();

        if (gameLose()) {
            new LoseScreen(Main.gameWindow);
        }
        else if (!gameLose() && Points.getPoints() == POINTS_TOTAL) {
            new WinScreen(Main.gameWindow);
        }
    }

    private boolean gameLose() {
        return (this.getY() + BALL_D >= SCREEN_HEIGHT ? true : false);
    }

    private void screenBordersCollision() {
        if (this.getX() + BALL_D >= SCREEN_WIDTH || this.getX() <= 0) {
            moveX = -moveX;
        }
        if (this.getY() <= 0 || paddleCollision()) {
            moveY = -moveY;
        }
    }

    private boolean paddleCollision() {
        int playerX = GameWindow.getPlayer().getX();
        int playerXEnd = playerX + PADDLE_WIDTH;
        int playerY = GameWindow.getPlayer().getY();
        if (playerX <= this.getX() && this.getX() <= playerXEnd && playerY <= this.getY() + BALL_D) {
            return true;
        }
        return false;
    }

    private void brickCollision() {
        boolean flag = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (this.getBounds().intersects(GameWindow.getBrickLabel(i, j).getBounds()) && GameWindow.getBrick(i, j).isAlive()) {
                    moveX = -moveX;
                    moveY = -moveY;
                    Points.increasePoints(GameWindow.getPoints());
                    GameWindow.deleteBrick(i, j, Main.gameWindow);
                    GameWindow.getBrick(i, j).kill();
                    flag = !flag;
                    break;
                }
            }
            if (flag) break;
        }
    }
}
