import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Bullets {


    int score = 0;
    private final ArrayList<Bullet> bullets = new ArrayList<>();



    public void addBullet(int x, int y)
    {
        synchronized (bullets)
        {
            bullets.add(new Bullet(x, y));
        }

    }

    public void removeBullet()
    {
        synchronized (bullets)
        {
            Iterator<Bullet> b = bullets.iterator();
            {
                while (b.hasNext()) {
                    Bullet bulletIter = b.next();
                    if (bulletIter.check) b.remove();
                }
            }
        }

    }

    public ArrayList<Bullet> getBullets() {

        synchronized (bullets)
        {
        return bullets;
        }
    }

    public void moveBullets()
    {
        synchronized (bullets) {
           for(Bullet bullet : bullets)
           {
                bullet.moveBullet();
           }
        }
    }

    public void paint(Graphics2D g2)
    {
        synchronized (bullets) {
            for (Bullet bullet : bullets)
            {
                g2.drawImage(bullet.img, bullet.getX(), bullet.getY(), null);
            }
        }
    }

   public void checkCollisionEnemies(Enemies enemies)
   {
       synchronized (bullets)
       {
           for (Bullet bullet : bullets)
           {
               if (enemies.checkCollisionBullets(bullet))
               {
                   bullet.check = true;
                   score++;
               }
           }
       }

   }

}
