import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Enemy {

    private int x;
    private int y = 0;
    private int speedEnemy = 3;
    public boolean check = false;

    Random random = new Random();
    Image img;

    public Enemy()
    {
        this.x = randomX();
        this.img = randomImageEnemy();
    }

    public Rectangle getRect()
    {
        int width = 75;
        int heigth = 50;
        return new Rectangle(x,y,width,heigth);
    }

    public void moveEnemy() {
        y += speedEnemy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedEnemy() {
        return speedEnemy;
    }

    public void setSpeedEnemy(int speedEnemy) {
        this.speedEnemy = speedEnemy;
    }

    private Image randomImageEnemy()
    {
        random.nextInt(2);
        if(random.nextInt(3)==0)
        {
            return new ImageIcon("resource/enemy.png").getImage();
        }

        if(random.nextInt(3)==1)
        {
            return new ImageIcon("resource/att2.png").getImage();
        }

        if(random.nextInt(3)==2)
        {
            return new ImageIcon("resource/RD2.png").getImage();
        }

        else return new ImageIcon("resource/enemy.png").getImage();
    }

    private int randomX()
    {
        return random.nextInt(800);
    }
}
