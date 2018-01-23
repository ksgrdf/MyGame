import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Enemies {

    Random random = new Random();
    private final ArrayList<Enemy> enemies = new ArrayList<>();

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy()
    {
        synchronized (enemies)
        {
            if (random.nextInt(7) == 2) enemies.add(new Enemy());
        }


    }

    public void removeEnemy()
    {
        synchronized (enemies) {
            Iterator<Enemy> e = enemies.iterator();
            {
                while (e.hasNext()) {
                    Enemy enemyIter = e.next();
                    if (enemyIter.check) e.remove();
                }
            }
        }
    }



    public void moveEnemies()
    {
        synchronized (enemies) {
            for (Enemy enemy : enemies)
            {
                enemy.moveEnemy();
            }
        }
    }

    public void paint(Graphics2D g2)
    {
        synchronized (enemies) {
           for (Enemy enemy : enemies)
           {
                g2.drawImage(enemy.img, enemy.getX(), enemy.getY(), null);
           }
        }
    }


    public Boolean checkCollisionBullets(Bullet bullet)
    {
        synchronized (enemies) {
            Iterator<Enemy> e = enemies.iterator();
            while (e.hasNext()) {

                Enemy iterEnemy = e.next();

                if(iterEnemy.getRect().intersects(bullet.getRect()))
                {
                    iterEnemy.check = true;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCollisionShip(Ship ship)
    {
        synchronized (enemies) {
            Iterator<Enemy> e = enemies.iterator();
            while (e.hasNext()) {

                Enemy iterEnemy = e.next();

                if(iterEnemy.getRect().intersects(ship.getRectangle()))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
