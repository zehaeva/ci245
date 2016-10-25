import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/24/2016.
 */
public class Game extends JFrame {
    public Game() throws HeadlessException {

        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawOval(10, 10 , 5, 5);
            }
        };

        this.setPreferredSize(new Dimension(100, 100));

        this.add(p);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
