import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/27/16.
 */
public class CCFrame extends JFrame {
    public CCFrame() throws HeadlessException {
        this.setTitle("Lab 13.6: Concentric Circles");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ConcentricCircles p = new ConcentricCircles();

        this.add(p);
        this.setBackground(Color.white);
        this.setSize(200, 200);
    }
}
