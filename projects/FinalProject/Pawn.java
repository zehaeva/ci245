import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by zehaeva on 12/7/2016.
 */
public class Pawn extends Unit {
    public Pawn(Point position) {
        super(position);
    }

    public Pawn(Point position, int size) {
        super(position, size);
    }

    public Pawn(int x, int y) {
        super(x, y);
    }

    public Pawn(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    public Pawn(int x, int y, int size, int speedX, int speedY, Color color) {
        super(x, y, size, speedX, speedY, color);
        this.drawShape();
    }

    @Override
    public void drawShape() {
        this._shape = new Ellipse2D.Double(this._position.x, this._position.y, this._size, this._size);
    }
}
