import java.awt.*;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Unit {
    private Point _position;
    private String _name;

    public Unit(Point _position) {
        this._position = _position;
    }

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point Position) {
        this._position = Position;
    }

    public String getName() {
        return _name;
    }

    public void setName(String Name) {
        this._name = Name;
    }
}
