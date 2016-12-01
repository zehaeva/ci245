import javax.swing.*;

/**
 * Created by hcanaway on 11/23/2016.
 */
public class MineSweeper {
    private int _rows;
    private int _cols;
    private MineSweeperSquare[][] _squares;
    private JPanel _panel;

    public MineSweeper(JPanel panel) {
        this._panel = panel;
    }
}
