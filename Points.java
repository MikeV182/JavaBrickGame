import java.awt.*;
import javax.swing.*;

public class Points extends JLabel implements Constants {
    private static int currentPoints;

    public Points() {
        currentPoints = 0;
        setBounds(0, 0, 100, 30);
        setForeground(Color.WHITE);
        setFont(new Font("serif", Font.PLAIN, 30));
        setText("" + currentPoints);
    }

    public static void increasePoints(Points points) {
        currentPoints += POINTS_INCREASE;
        points.setText("" + currentPoints);
    }

    public static int getPoints() {
        return currentPoints;
    }
}
