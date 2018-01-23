import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергей on 14.12.2017.
 */
public class Main {

    public static void main(String[] args) {


        Color color = new Color(255, 251, 243);
        Color color1 = new Color(178, 25, 14);
        JFrame jFrame = new JFrame("Menu");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jFrame.setBackground(color);
        jFrame.setBounds(300, 200, 800, 500);

        Button button = new Button("Go");
        Font font = new Font("Comic Sans", Font.HANGING_BASELINE, 20);
        button.setFont(font);
        button.setBackground(color);
        button.setSize(50, 150);
        button.setLocation(370, 0);
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());
        jFrame.add(button);
        jFrame.add(panel);


        button.addActionListener(e -> {
            JFrame frame = new JFrame("Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //new GamePlay().start();
                frame.add(new DrawGame());

            frame.setVisible(true);
            frame.setSize(1000, 1000);
            jFrame.setVisible(false);

        });
    }


public  static class Panel extends JPanel
{
    public void paint(Graphics g)
    {
        Image img = new ImageIcon("resource/batle.jpg").getImage();
        g.drawImage(img,0,0,this);
    }

}
}
