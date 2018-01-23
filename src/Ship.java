import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Ship {



    private  int x = 400;
    private  int y = 600;
    private int speedShip = 20;

    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;




    Image img = new ImageIcon("resource/space5.png").getImage();

    //field size for ship
    private static  final int MAX_RIGHT = 800;
    private static  final int MAX_LEFT = 10;
    private static  final int MAX_DOWN = 600;
    private static  final int MAX_UP = 0;



    public Rectangle getRectangle()
    {
        int widgth = 55;
        int heigth = 70;
        return new Rectangle(x,y,widgth,heigth);
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        if (x>=MAX_RIGHT) x=MAX_RIGHT;
        if (x<=MAX_LEFT) x=MAX_LEFT;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y)
    {
        if (y<=MAX_UP) y=MAX_UP;
        if (y>=MAX_DOWN) y=MAX_DOWN;
        this.y = y;
    }

    public int getSpeedShip() {
        return speedShip;
    }

    public void setSpeedShip(int speedShip) {
        this.speedShip = speedShip;
    }



    public void moveShip()
    {
        if(right) x+= speedShip;
        if(left) x-= speedShip;
        if(up) y-= speedShip;
        if(down) y+= speedShip;

        //field boundary control
        if (x>=MAX_RIGHT) x=MAX_RIGHT;
        if (x<=MAX_LEFT) x=MAX_LEFT;
        if (y<=MAX_UP) y=MAX_UP;
        if (y>=MAX_DOWN) y=MAX_DOWN;
    }

    public void moveShip(KeyEvent keyEvent, boolean b) {
        int key = keyEvent.getKeyCode();

        if (b) {
            switch (key) {
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
            }
        } else {
            switch (key) {
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
            }

        }
    }

    public void paint(Graphics2D g2)
    {
        g2.drawImage(img, x, y, null);
    }


}




