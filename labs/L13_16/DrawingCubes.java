import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by zehaeva on 10/27/16.
 */
public class DrawingCubes extends JFrame {
    public DrawingCubes() throws HeadlessException {
        CubePanel p = new CubePanel();

        this.add(p);
        this.pack();
        this.setTitle("Drawing Cubes");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
    }

    private class CubePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            GeneralPath gp = new GeneralPath();

            gp.moveTo(10, 10);
            gp.lineTo(10, 110);
            gp.lineTo(110, 110);
            gp.lineTo(110, 10);
            gp.closePath();

            gp.moveTo(10, 110);
            gp.lineTo(30, 130);
            gp.lineTo(130, 130);
            gp.lineTo(130, 30);
            gp.lineTo(110, 10);

            gp.moveTo(110, 110);
            gp.lineTo(130, 130);

            g2d.setColor(Color.black);
            g2d.draw(gp);

        }
    }
}
