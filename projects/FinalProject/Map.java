import java.awt.*;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Map {
    private int _width;
    private int _height;
    private ArrayList<Unit> _units;

    public Map(int _width, int _height) {
        this._width = _width;
        this._height = _height;
        this._units = new ArrayList<>();
    }

    public ArrayList<Unit> getUnits() {
        return _units;
    }

    public void setUnits(ArrayList<Unit> Units) {
        this._units = Units;
    }

    public void drawUnits(Graphics g) {
        for (Unit x :
                this._units) {
            g.drawOval((int) x.getPosition().getX(), (int) x.getPosition().getY(), 5, 5);
        }
    }
}
