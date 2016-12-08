import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Created by hcanaway on 12/1/2016.
 */
public class Knight extends Pawn {
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
}
