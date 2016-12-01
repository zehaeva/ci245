import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 11/23/2016.
 */
public class MineSweeperFrame extends JFrame {
    private JPanel _p;

    public MineSweeperFrame() throws HeadlessException {
        this._p = new JPanel();
        this._p.setLayout(new GridLayout(30, 16));
        this.add(this._p);

        Insets inset = this._p.getInsets();

        MineSweeperSquare temp;

        for (int i=0;i < 30;i++) {
            for (int j = 0; j < 16; j++) {
                temp = new MineSweeperSquare();
                this._p.add(temp);
            }
        }

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
