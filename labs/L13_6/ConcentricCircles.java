import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/27/16.
 */
public class ConcentricCircles extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 1; i <= 10; i++) {
            g.drawArc(100 - (i * 5), 100 - (i * 5), 10 * i, 10 * i, 0, 360);
        }
    }
}
