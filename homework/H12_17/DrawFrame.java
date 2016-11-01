import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 10/31/2016.
 */
public class DrawFrame extends JFrame {
    public DrawFrame() throws HeadlessException {
        this.setLayout(new BorderLayout());
        JLabel status = new JLabel();
        status.setText("X: 0, Y:0");
        DrawPanel dp = new DrawPanel(status);

        TopPanel tp = new TopPanel();

        this.add(dp, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);
        this.add(tp, BorderLayout.NORTH);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(600, 450);
    }
}
