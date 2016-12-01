import java.awt.*;
import java.util.ArrayList;

/**
 * Created by zehaeva on 11/30/2016.
 */
public class Player {
    private ArrayList<Unit> _units;
    private String _name;
    private Color _color;
    private boolean _human;

    public Player(String name, boolean human, Color color) {
        this._name = name;
        this._human = human;
        this._units = new ArrayList<>();
        this._color = color;
    }

    public ArrayList<Unit> getUnits() {
        return this._units;
    }

    public Color getColor() {
        return this._color;
    }

    public void setColor(Color color) {
        this._color = color;
    }

    public boolean isHuman() {
        return this._human;
    }

    public void setHuman(boolean human) {
        this._human = human;
    }

    public boolean executeCommands() {
        return false;
    }

    public void generateUnits(int starting_side, int count, Dimension gridSize) {
        this._units.add(new Unit(0, starting_side * gridSize.width, gridSize.height, 0, 0, this._color));
        for (int i = 1; i < count - 1; i++) {
            this._units.add(new Knight(i * gridSize.height, starting_side * gridSize.width, gridSize.height, 0, 0, this._color));
        }
        this._units.add(new Unit((count - 1) * gridSize.height, starting_side * gridSize.width, gridSize.height, 0, 0, this._color));
    }
}
