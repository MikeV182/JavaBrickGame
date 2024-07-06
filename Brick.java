import java.awt.*;
import javax.swing.*;

public class Brick extends JLabel implements Constants {
    public Brick(int row, int column) {
        setBounds(column, row, BRICK_WIDTH, BRICK_HEIGHT);
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}
