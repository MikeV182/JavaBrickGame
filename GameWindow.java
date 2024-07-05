import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements KeyListener {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 1024;
    private static final int VELOCITY = 10;
    private JLabel player;

    public GameWindow(String name) {
        super(name); 
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        addKeyListener(this);
        player = new Player();
        add(player);
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