import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by zehaeva on 12/7/2016.
 */
public class Pawn extends Unit {
    public Pawn(int x, int y, int size, Color color, Point facing) {
        this(x, y, size, 0, 0, color, facing);
    }

    public Pawn(int x, int y, int size, int speedX, int speedY, Color color, Point facing) {
        super(x, y, size, speedX, speedY, color, facing);
        this._hit_points = 5;
        this._possible_moves.add(new Point(0, 1));
        this._possible_moves.add(new Point(1, 0));
        this._possible_moves.add(new Point(0, -1));
        this._possible_moves.add(new Point(-1, 0));
        this._attack_patterns.add(new Point(1, 1));
        this._attack_patterns.add(new Point(-1,1));
    }

    @Override
    public void drawShape() {
        this._shape = new Ellipse2D.Double(this._position.x * this._size, this._position.y * this._size, this._size, this._size);
    }
}
