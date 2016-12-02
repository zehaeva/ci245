import javax.swing.*;
import java.awt.*;

/**
 * Created by hcanaway on 11/23/2016.
 */
public class MineSweeperSquare extends JButton {
    private boolean _mine;
    private int _mine_neighbors;

    public MineSweeperSquare() {
        super();
        this._mine = false;
        this._mine_neighbors = 0;
        this.setPreferredSize(new Dimension(20, 20));
    }

    public boolean isMine() {
        return _mine;
    }

    public void setMine(boolean mine) {
        this._mine = mine;
        if (mine) {
            this.setText("*");
        }
    }

    public int getMineNeighbors() {
        return _mine_neighbors;
    }

    public void setMineNeighbors(int mineNeighbors) {
        this._mine_neighbors = mineNeighbors;
        this.setText(String.valueOf(this._mine_neighbors));
    }

    public void addMineNeighbor() {
        this._mine_neighbors++;
        if (!this._mine) {
            this.setText(String.valueOf(this._mine_neighbors));
        }
    }
}
