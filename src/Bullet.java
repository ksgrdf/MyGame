import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Bullet {

    private int x;
    private int y;
    private int speedBullet = 20;
    public boolean check = false;
    Image img = new ImageIcon("resource/blas1.png").getImage();


    public Bullet(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Rectangle getRect()
    {
        int weidgth = 5;
        int heigth = 5;
        return new Rectangle(x,y,weidgth,heigth);
    }

    public void moveBullet()
    {
        y = y - speedBullet;
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

    public int getSpeedBullet() {
        return speedBullet;
    }

    public void setSpeedBullet(int speedBullet) {
        this.speedBullet = speedBullet;
    }

}
