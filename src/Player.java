import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Player extends KeyAdapter {

    private int speedLayer = 2;
    Ship ship = new Ship();

    public int getSpeedLayer() {
        return speedLayer;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        ship.moveShip(e,true);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
       ship.moveShip(e, false);
    }

}
