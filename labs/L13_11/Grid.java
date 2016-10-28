import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/27/16.
 */
public class Grid extends JFrame {
    public Grid() throws HeadlessException {
        GridPanel p = new GridPanel();

        this.add(p);
        this.pack();
        this.setTitle("8x8 Grid");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(200, 200);
    }

    private class GridPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);

            int offset;

            for (int i = 1; i < 8; i++) {

                offset = this.getHeight() * i / 8;
                g.drawLine(offset, 0, offset, this.getHeight());
                offset = this.getWidth() * i / 8;
                g.drawLine(0, offset, this.getWidth(), offset);
            }
        }
    }
}
