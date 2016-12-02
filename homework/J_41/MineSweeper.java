import javax.swing.*;
import java.util.Random;

/**
 * Created by hcanaway on 11/23/2016.
 */
public class MineSweeper {
    private int _rows;
    private int _cols;
    private MineSweeperSquare[][] _squares;
    private JPanel _panel;

    public MineSweeper(JPanel panel, int rows, int cols) {
        this._panel = panel;
        this._rows = rows;
        this._cols = cols;
        Random rand = new Random();

        this._squares = new MineSweeperSquare[rows][cols];

        int bomb_count = 0;

        MineSweeperSquare temp;

        for (int i=0;i < rows;i++) {
            for (int j = 0; j < cols; j++) {
                temp = new MineSweeperSquare();
                if (bomb_count < 100) {
                    if (rand.nextInt(10) < 2) {
                        bomb_count++;
                        temp.setMine(true);
                    }
                }
                this._squares[i][j] = temp;
                this._panel.add(temp);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this._squares[i][j].isMine()) {
                    if (i > 0) { this._squares[i-1][j].addMineNeighbor(); }
                    if (i < rows - 1) { this._squares[i+1][j].addMineNeighbor(); }
                    if (j > 0) { this._squares[i][j-1].addMineNeighbor(); }
                    if (j < cols - 1) { this._squares[i][j+1].addMineNeighbor(); }
                }
            }
        }
    }
}
