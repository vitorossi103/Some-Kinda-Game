package helpers;

import data.Game;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Artist {
    public static Texture loadTexture(String key) {
        try {
            return TextureLoader.getTexture("png", new FileInputStream(new File("res/" + key + ".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void drawTexture(Texture t, float x, float y, float width, float height) {
        t.bind();

        glTranslatef(x, y, 0);

        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 0);
            glVertex2f(0, 0);

            glTexCoord2f(1, 0);
            glVertex2f(width, 0);

            glTexCoord2f(1, 1);
            glVertex2f(width, height);

            glTexCoord2f(0, 1);
            glVertex2f(0, height);

            glLoadIdentity();
        }
        glEnd();
    }

    public static void drawBackground() {
        glBegin(GL_QUADS);
        {
            glColor3d(0.7, 0.8, 0.9);
            glVertex2d(0, 0);
            glVertex2d(640, 0);

            glColor3d(0.6, 0.7, 0.9);
            glVertex2d(640, 480);
            glVertex2d(0, 480);
        }
        glEnd();

        // Draw ground
        glBegin(GL_QUADS);
        {
            glColor3d(0.7, 0.3, 0.2);
            glVertex2d(0, 0);
            glVertex2d(640, 0);
            glVertex2d(640, 32);
            glVertex2d(0, 32);
        }
        glEnd();

        // Draw grass
        glBegin(GL_QUADS);
        {
            glColor3d(0.2, 0.8, 0.2);
            glVertex2d(0, 25);
            glVertex2d(640, 25);

            glVertex2d(640, 32);
            glVertex2d(0, 32);
        }
        glEnd();
        glClearColor(0, 0, 0, 0);
    }
}

