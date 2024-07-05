import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 1024;
    private Player player;

    public GameWindow(String name) {
        super(name); 
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        player = new Player(WIDTH, HEIGHT);
        add(player);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}