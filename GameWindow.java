import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(String name) {
        super(name); 
        setSize(1280, 1024);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}