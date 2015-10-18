package data;

import static helpers.Artist.drawBackground;
import static helpers.Artist.loadTexture;

public class Game {
    public static final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    private Player player;

    public Game() {
        player = new Player(loadTexture("player"), SCREEN_WIDTH / 2 - 128, SCREEN_HEIGHT / 2, 64, 64, 6);
    }

    public void getInput() {
        player.getInput();
    }

    public void update() {
        player.update();
    }

    public void render() {
        drawBackground();
        player.render();
    }
}
