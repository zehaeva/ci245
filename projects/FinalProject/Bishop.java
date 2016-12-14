import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by zehaeva on 12/14/16.
 */
public class Bishop extends Unit {
    public Bishop(int x, int y, int size, Color color, Point facing) {
        super(x, y, size, color, facing);
    }

    public Bishop(int x, int y, int size, int speedX, int speedY, Color color, Point facing) {
        super(x, y, size, speedX, speedY, color, facing);this._hit_points = 5;

        for (int i = 1; i < 4; i++) {
            this._possible_moves.add(new Point(i, i));
            this._possible_moves.add(new Point(i, -i));
            this._possible_moves.add(new Point(-i, -i));
            this._possible_moves.add(new Point(-i, i));
        }

        this._attack_patterns.add(new Point(0, 1));
        this._attack_patterns.add(new Point(0, -1));
        this._attack_patterns.add(new Point(-1,0));
        this._attack_patterns.add(new Point(1,0));
    }

    @Override
    public void drawShape() {
        this._shape = new Rectangle2D.Double(this._position.x * this._size + this._size / 4 ,
                this._position.y * this._size, this._size / 2, this._size);
    }
}
