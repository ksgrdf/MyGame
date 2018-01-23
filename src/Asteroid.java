import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Asteroid {

    Image img = new ImageIcon("resource/asteroid.png").getImage();
    int x;
    int y;
    private int speed = 2;
    Random random = new Random();

    public Asteroid()
    {
        x = randomX();

    }
    public Rectangle getRect()
    {
        int width = 40;
        int heigth = 40;
        return new Rectangle(x,y,width,heigth);
    }

    public void moveAsteroid() {
        y += speed;
    }

    private int randomX()
    {
        return random.nextInt(800);
    }
}
