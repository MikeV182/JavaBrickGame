import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements KeyListener, Constants {
    private static JLabel player;
    private static JLabel[][] map;
    private static JLabel ball;
    private static JLabel currentPoints; 

    public GameWindow(String name) {
        super(name); 
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        addKeyListener(this);

        player = new Player();
        add(player);

        map = new JLabel[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                map[i][j] = new Brick(i*BRICK_SPACE+BRICK_HEIGHT*(i+3), (j+1)*(BRICK_WIDTH+BRICK_SPACE));
                add(map[i][j]);
            }
        }

        ball = new Ball();
        add(ball);

        currentPoints = new Points();
        add(currentPoints);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static Points getPoints() {
        return (Points)currentPoints;
    }

    public static JLabel getPlayer() {
        return player;
    }

    public static JLabel getBrickLabel(int row, int column) {
        return map[row][column];
    }

    public static Brick getBrick(int row, int column) {
        return (Brick)map[row][column];
    }
    
    public static void deleteBrick(int row, int column, JFrame frame) {
        frame.remove(getBrickLabel(row, column));
        frame.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       switch (e.getKeyChar()) {
        case 'z':
            if (player.getX() - VELOCITY >= 0) {
                player.setLocation(player.getX() - VELOCITY, player.getY()); 
            }
            break;
       
        case 'x':
            if (player.getX() + PADDLE_WIDTH + VELOCITY <= SCREEN_WIDTH) {
                player.setLocation(player.getX() + VELOCITY, player.getY());
            }
            break;   
       }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 39:
                if (player.getX() + PADDLE_WIDTH + VELOCITY <= SCREEN_WIDTH) {
                    player.setLocation(player.getX() + VELOCITY, player.getY());
                }
                break;
                
            case 37:
                if (player.getX() - VELOCITY >= 0) {
                    player.setLocation(player.getX() - VELOCITY, player.getY()); 
                }
                break;   
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.getKeyChar());
    }
}