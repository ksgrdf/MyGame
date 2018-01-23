import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Asteroids {



    Random random = new Random();
    private final ArrayList<Asteroid> asteroids = new ArrayList<>();


    public  ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }


    public void addSteroid()
    {
        synchronized (asteroids) {
            if (random.nextInt(40) == 2) asteroids.add(new Asteroid());
        }

    }


    public void moveAsteroids()
    {
        synchronized (asteroids) {
           for (Asteroid asteroid : asteroids){

                asteroid.moveAsteroid();

            }
        }
    }

    public void paint(Graphics2D g2)
    {
        synchronized (asteroids) {
            for (Asteroid asteroid : asteroids)
            {
                g2.drawImage(asteroid.img, asteroid.x, asteroid.y, null);
            }
        }
    }

    public boolean checkShipCollision(Ship ship)
    {
        synchronized (asteroids) {
            Iterator<Asteroid> a = asteroids.iterator();
            while (a.hasNext()) {
                Asteroid asteroid = a.next();
                if(asteroid.getRect().intersects(ship.getRectangle()))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
