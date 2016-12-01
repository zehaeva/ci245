import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Map extends JComponent implements MouseListener {
    private int _width;
    private int _height;
    private int _grid_width;
    private int _grid_height;
    private ArrayList<Unit> _units;

    public Map(int width, int height, int gridWidth, int gridHeight) {
        this.initialize(width, height, gridWidth, gridHeight);
    }

    public Map(int width, int height, Dimension gridSize) {
        this.initialize(width, height, gridSize.width, gridSize.height);
    }

    private void initialize(int width, int height, int gridWidth, int gridHeight) {
        this._width = width;
        this._height = height;
        this._grid_width = gridWidth;
        this._grid_height = gridHeight;
        this._units = new ArrayList<>();
    }

    public ArrayList<Unit> getUnits() {
        return _units;
    }

    public void setUnits(ArrayList<Unit> Units) {
        this._units = Units;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        this._width = width;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        this._height = height;
    }

    public int getGridWidth() {
        return _grid_width;
    }

    public void setGridWidth(int gridWidth) {
        this._grid_width = gridWidth;
    }

    public int getGridHeight() {
        return _grid_height;
    }

    public void setGridHeight(int gridHeight) {
        this._grid_height = gridHeight;
    }

    public void drawUnits(Graphics g) {
    //  Grid!
        for (int i = 0; i < this._width; i += this._grid_width) {
            g.drawLine(0, i, this._width, i);
        }
        for (int i = 0; i < this._height; i += this._grid_height) {
            g.drawLine(i, 0, i, this._height);
        }

    //  units on the field!
        Graphics2D g2d = (Graphics2D) g;

        for (Unit x :
                this._units) {
            if (this._width >= x.getPosition().getX() && this._height >= x.getPosition().getY()) {
                g2d.setColor(x.getColor());
                g2d.fill(x.getShape());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    // are we clicking on a unit?
        for (Unit x :
                this._units) {
            if (x.getShape().contains(e.getX(), e.getY())) {
                x.select();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
