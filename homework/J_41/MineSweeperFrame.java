import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 11/23/2016.
 */
public class MineSweeperFrame extends JFrame {
    private JPanel _p;
    private MineSweeper _ms;

    public MineSweeperFrame() throws HeadlessException {
        this._p = new JPanel();
        this._p.setLayout(new GridLayout(30, 16));
        this._p.setPreferredSize(new Dimension(800, 600));
        this.add(this._p);

        this._ms = new MineSweeper(this._p, 30, 16);

        this.setTitle("Minesweeper By Howard");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
