import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements KeyListener, Constants {
    private JLabel player;
    private JLabel[][] map;
    private JLabel ball;

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

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       switch (e.getKeyChar()) {
        case 'z':
            player.setLocation(player.getX() - VELOCITY, player.getY());
            break;
       
        case 'x':
            player.setLocation(player.getX() + VELOCITY, player.getY());
            break;   
       }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 39:
                player.setLocation(player.getX() + VELOCITY, player.getY());
                break;
                
            case 37:
                player.setLocation(player.getX() - VELOCITY, player.getY());
                break;   
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.getKeyChar());
    }
}