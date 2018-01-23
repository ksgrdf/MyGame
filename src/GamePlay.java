import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Сергей on 14.12.2017.
 */
public class GamePlay extends Thread implements ActionListener{

    public int layer = 0;
    public int layerTwo = -1000;

    boolean isRun = true;
    Timer timer = new Timer(20,this);
    Player player = new Player();
    Ship ship = player.ship;
    Bullets bullets = new Bullets();
    Enemies enemies = new Enemies();
    Asteroids asteroids = new Asteroids();




    public GamePlay()
    {
        this.start();
        timer.start();
    }



    public void moveLayer()
    {

        if (layerTwo + player.getSpeedLayer() >=0)
        {
            layer = 0;
            layerTwo = -1000;
        }
        else {
            layer += player.getSpeedLayer();
            layerTwo += player.getSpeedLayer();
        }
    }



    public  void run()
    {

        while (isRun)
        {
            try {

                bullets.addBullet(ship.getX(),ship.getY());
                bullets.addBullet(ship.getX()+45,ship.getY());
                enemies.addEnemy();
                asteroids.addSteroid();

                Thread.sleep(100);

            }
            catch (InterruptedException e)
            {
                System.out.println("thread sleep error");
            }
        }

    }



    public  void checkCollision()
    {
        bullets.checkCollisionEnemies(enemies);
       if(enemies.checkCollisionShip(ship) ||  asteroids.checkShipCollision(ship))
       {
           isRun = false;
           JOptionPane.showMessageDialog(null, "Очки " + bullets.score);
           System.exit(1);
       }


    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        moveLayer();
        ship.moveShip();
        checkCollision();
        enemies.removeEnemy();
        bullets.removeBullet();
        enemies.moveEnemies();
        bullets.moveBullets();
        asteroids.moveAsteroids();
    }
}
