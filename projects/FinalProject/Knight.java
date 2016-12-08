import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by hcanaway on 12/1/2016.
 */
public class Knight extends Unit {
    public Knight(int x, int y, int size, Color color) {
        this(x, y, size, 0, 0, color);
    }

    public Knight(int x, int y, int size, int speedX, int speedY, Color color) {
        super(x, y, size, speedX, speedY, color);
    }

    @Override
    public void drawShape() {
//  needs new shape!
        GeneralPath gp = new GeneralPath();

        gp.moveTo(this._position.x, this._position.y);
        gp.lineTo(this._position.x + this._size, this._position.y);
        gp.lineTo((this._position.x + this._size / 2 ), (this._position.y + this._size));
        gp.closePath();

        this._shape = gp;
    }

    @Override
    public ArrayList<GridSpace> getPossibleMoves() {
        Color c = Color.cyan;
        Dimension d = new Dimension(this._size, this._size);
        this._possible_moves.clear();
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x + this._size, this._position.y), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x - this._size, this._position.y), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x, this._position.y + this._size), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x, this._position.y + this._size * 2), d));
        this._possible_moves.add(new GridSpace(c, new Point(this._position.x, this._position.y - this._size), d));

        return this._possible_moves;
    }

    @Override
    public ArrayList<GridSpace> getPossibleAttacks() {
        Color c = Color.red;
        Dimension d = new Dimension(this._size, this._size);
        ArrayList<GridSpace> s = new ArrayList<>();
        s.add(new GridSpace(c, new Point(this._position.x, this._position.y + this._size), d));
        s.add(new GridSpace(c, new Point(this._position.x, this._position.y + this._size), d));
        return s;
    }
}
