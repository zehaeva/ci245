import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by hcanaway on 12/1/2016.
 */
public class Knight extends Unit {
    public Knight(int x, int y, int size, Color color, Point facing) {
        this(x, y, size, 0, 0, color, facing);
    }

    public Knight(int x, int y, int size, int speedX, int speedY, Color color, Point facing) {
        super(x, y, size, speedX, speedY, color, facing);
        this._hit_points = 10;
        this._damage_modifier = 200;

        this._attack_patterns.add(new Point(0, 2));
        this._attack_patterns.add(new Point(0, 3));
        this._attack_patterns.add(new Point(0, 1));
        this._attack_patterns.add(new Point(1, 0));
        this._attack_patterns.add(new Point(0, -1));
        this._attack_patterns.add(new Point(-1, 0));

        this._possible_moves.add(new Point(0, 2));
        this._possible_moves.add(new Point(0, 1));
        this._possible_moves.add(new Point(1, 0));
        this._possible_moves.add(new Point(0, -1));
        this._possible_moves.add(new Point(-1, 0));

    }

    @Override
    public void drawShape() {
//  needs new shape!
        GeneralPath gp = new GeneralPath();

        int x = this._position.x * this._size;
        int y = this._position.y * this._size;

        gp.moveTo(x, y);
        gp.lineTo(x + this._size, y);
        gp.lineTo((x + this._size / 2 ), (y + this._size));
        gp.closePath();

        this._shape = gp;
    }
}
