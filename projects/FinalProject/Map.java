import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Map extends JComponent {
    private int _width;
    private int _height;
    private int _grid_width;
    private int _grid_height;
    private ArrayList<Unit> _units;
    private ArrayList<GridSpace> _highlight_space;

    public Map(int width, int height, int gridWidth, int gridHeight) {
        this.initialize(width, height, gridWidth, gridHeight);
    }

    public Map(int width, int height, Dimension gridSize) {
        this.initialize(width, height, gridSize.width, gridSize.height);
    }

    private void initialize(int width, int height, int gridWidth, int gridHeight) {
        this.setLayout(null);
        this._width = width;
        this._height = height;
        this._grid_width = gridWidth;
        this._grid_height = gridHeight;
        this._units = new ArrayList<>();
        this._highlight_space = new ArrayList<>();
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

    public void highlightSpaces(ArrayList<GridSpace> list) {
        for (GridSpace p :list) {
            if (! this._highlight_space.contains(p)) {
                this._highlight_space.add(p);
            }
        }
    }
    public void deHighlightSpaces(ArrayList<GridSpace> list) {
        for (GridSpace p : list) {
            if (this._highlight_space.contains(p)) {
                this._highlight_space.remove(p);
            }
        }
    }

    public void drawUnits(Graphics g) {
        g.clearRect(0,0, this._width, this._height);
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

        //  if there is anything to highlight, highlight it!
        for (GridSpace p : this._highlight_space) {
            g.setColor(p.getBorderColor());
            g.drawRect(p.getPixelPosition().x, p.getPixelPosition().y, p.getSize().width, p.getSize().height);
        }
    }
}
