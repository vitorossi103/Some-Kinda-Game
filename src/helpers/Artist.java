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
        glEnable(GL_TEXTURE_2D);
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
        glDisable(GL_TEXTURE_2D);
    }

    public static void drawBackground() {
        glPushMatrix();

        //draw sky
        glBegin(GL_QUADS);
        {
            glColor3d(0.7, 0.8, 0.9);
            glVertex2d(0, 0);
            glVertex2d(Game.SCREEN_WIDTH, 0);

            glColor3d(0.6, 0.7, 0.9);
            glVertex2d(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);
            glVertex2d(0, Game.SCREEN_HEIGHT);
        }
        glEnd();

        // Draw grass
        glBegin(GL_QUADS);
        {
            glColor3d(0.2, 0.8, 0.2);
            glVertex2d(0, 0);
            glVertex2d(Game.SCREEN_WIDTH, 0);

            glVertex2d(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT / 2 - 32);
            glVertex2d(0, Game.SCREEN_HEIGHT / 2 - 32);
        }
        glEnd();
        glPopMatrix();
        glColor3d(1, 1, 1);
    }
}

