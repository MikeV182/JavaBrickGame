public interface Constants {
    int SCREEN_WIDTH = 1280;
    int SCREEN_HEIGHT = 1024;
    int VELOCITY = 10;
    int ROWS = 4;
    int COLUMNS = 8;
    int BRICK_SPACE = 5;
    int BRICK_WIDTH = SCREEN_WIDTH / (COLUMNS + 2) - BRICK_SPACE;
    int BRICK_HEIGHT = (SCREEN_HEIGHT / 6) / ROWS;
    int PADDLE_WIDTH = 180;
    int PADDLE_HEIGHT = 10;
    int PADDLE_X = 550;
    int PADDLE_Y = 960;
}