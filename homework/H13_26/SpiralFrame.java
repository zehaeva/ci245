import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/29/16.
 */
public class SpiralFrame extends JFrame {
    private Spiral _spiral;
    public SpiralFrame() throws HeadlessException {
        this.setTitle("Pie Chart");
        this.setLayout(null);

        this._spiral = new Spiral();
        this.add(this._spiral);
        this._spiral.setPreferredSize(new Dimension(300, 300));
        this._spiral.setBounds(0, 0, 300, 300);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
    }

    private class Spiral extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int[] xvalues = {150, 220, 250, 220, 150, 80,  50,  80, 150, 200, 220, 200, 150, 100,  80, 100, 150, 180, 190};
            int[] yvalues = {250, 220, 150,  80,  50, 80, 150, 200, 220, 200, 150, 100,  80, 100, 150, 180, 190, 180, 150};

            g.drawPolyline(xvalues, yvalues, xvalues.length);
        }
    }
}
