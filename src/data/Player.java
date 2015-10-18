package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.drawTexture;

public class Player {

    private float x, y, width, height;
    private Texture texture;
    private int speed;

    public Player(Texture texture, float x, float y, float width, float height, int speed) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void getInput() {
        //keyboard input
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            y += speed;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            y -= speed;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            x += speed;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            x -= speed;
        }

        if (Mouse.isButtonDown(0)) {
           //"attack". Will change texture. Some kind of animation eventually.
        }
    }

    public void update() {
        //run logic, other things
        System.out.println("Player y-level: " + y);
        System.out.println("Screen height: " + Game.SCREEN_HEIGHT);
        if (y < 0) {
            y = 0;
        }

        if (y + 64 >= Game.SCREEN_HEIGHT) {
            y = Game.SCREEN_HEIGHT - 64;
        }

    }

    public void render() {
        drawTexture(texture, x, y, width, height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
