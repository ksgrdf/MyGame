import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by Сергей on 14.12.2017.
 */
public class DrawGame extends JPanel implements ActionListener {



    GamePlay gamePlay;
    Player player;
    Enemies enemies;
    Bullets bullets;
    Asteroids asteroids;

    Image imgLayer = new ImageIcon("resource/star.jpeg").getImage();
    Timer timer = new Timer(5, this);


    private class MyKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
           player.keyPressed(e);
        }

         public void keyReleased(KeyEvent e) {
         player.keyReleased(e);
        }
    }

    public DrawGame() {

        gamePlay = new GamePlay();
        player = gamePlay.player;
        enemies = gamePlay.enemies;
        bullets = gamePlay.bullets;
        asteroids = gamePlay.asteroids;

        addKeyListener(new MyKeyAdapter());
        setFocusable(true);

        timer.start();


    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgLayer, 0, gamePlay.layer, this);
        g2.drawImage(imgLayer, 0, gamePlay.layerTwo, this);

        g2.setColor(Color.YELLOW);
        Font font = new Font("Comic Sans", Font.HANGING_BASELINE, 20);
        g2.setFont(font);
        g2.drawString("Score", 10, 15);
        g2.drawString(String.valueOf(gamePlay.bullets.score), 15, 35);


        g2.drawString("Bullets", 880, 15);

        player.ship.paint(g2);

        gamePlay.enemies.paint(g2);
        gamePlay.bullets.paint(g2);

        gamePlay.asteroids.paint(g2);


    }

    @Override
    public  void actionPerformed(ActionEvent e)
    {
        repaint();
    }

}
