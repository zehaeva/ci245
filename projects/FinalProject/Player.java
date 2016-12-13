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
    private int _max_actions;
    private int _actions_left;

    public Player(String name, boolean human, Color color) {
        this._name = name;
        this._human = human;
        this._units = new ArrayList<>();
        this._color = color;
        this._max_actions = 3;
        this._actions_left = 3;
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

    public int getActionsLeft() {
        return this._actions_left;
    }

    public int getMaxActions() {
        return this._max_actions;
    }

    public void newTurn() {
        this._actions_left = this._max_actions;
    }

    public void useAction() {
        this._actions_left--;
    }

    public void removeUnit(Unit unit) {
        try {
            this._units.remove(unit);
        }
        catch (Exception ex) {
            System.out.println("Error Removing Unit");
        }
    }

    public boolean executeCommands() {
        if (this._actions_left == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void generateUnits(int starting_side, int count, Dimension gridSize) {
        this._units.add(new Pawn(0, starting_side, gridSize.height, 0, 0, this._color));
        for (int i = 1; i < count - 1; i++) {
            this._units.add(new Knight(i,  starting_side, gridSize.height, 0, 0, this._color));
        }
        this._units.add(new Pawn((count - 1), starting_side, gridSize.height, 0, 0, this._color));
    }
}
