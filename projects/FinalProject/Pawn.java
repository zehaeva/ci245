import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by zehaeva on 12/7/2016.
 */
public class Pawn extends Unit {
    public Pawn(int x, int y, int size, Color color) {
        this(x, y, size, 0, 0, color);
    }

    public Pawn(int x, int y, int size, int speedX, int speedY, Color color) {
        super(x, y, size, speedX, speedY, color);
        this._hit_points = 5;
    }

    @Override
    public void drawShape() {
        this._shape = new Ellipse2D.Double(this._position.x * this._size, this._position.y * this._size, this._size, this._size);
    }

    @Override
    public ArrayList<GridSpace> getPossibleMoves() {
        Color c = Color.cyan;
        Dimension d = new Dimension(this._size, this._size);
        this._possible_moves.clear();
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x + 1, this._position.y), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x - 1, this._position.y), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x, this._position.y + 1), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x, this._position.y - 1), d));
        return this._possible_moves;
    }

    @Override
    public ArrayList<GridSpace> getPossibleAttacks() {
        Color c = Color.red;
        Dimension d = new Dimension(this._size, this._size);
        ArrayList<GridSpace> s = new ArrayList<>();
        s.add(new GridSpace(c, new Point(this._position.x + 1, this._position.y + 1), d));
        s.add(new GridSpace(c, new Point(this._position.x - 1, this._position.y + 1), d));
        return s;
    }
}
