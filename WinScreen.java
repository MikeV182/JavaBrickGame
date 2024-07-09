import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class WinScreen extends JLabel implements Constants {
    public WinScreen(JFrame frame) {
        setBounds(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 300, 300);
        setForeground(Color.RED);
        setOpaque(true);
        setFont(new Font("serif", Font.PLAIN, 40));
        setText("YOU WIN");
        frame.add(this); //TODO: not printing information on the screen
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

