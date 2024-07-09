import javax.swing.*;

public class Main {
    public static JFrame gameWindow;

    public Main() {
        gameWindow = new GameWindow("Java Brick Game");
    }

    public static void main(String[] args) {
        new Main();
    }
}
