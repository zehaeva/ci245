import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Created by hcanaway on 12/1/2016.
 */
public class Knight extends Unit {
    public Knight(int x, int y, int size, int speedX, int speedY, Color color) {
        super(x, y, size, speedX, speedY, color);

    //  needs new shape!
        GeneralPath gp = new GeneralPath();

        gp.moveTo(x, y);
        gp.lineTo(x + size, y);
        gp.lineTo((x + size / 2 ), (y + size));
        gp.closePath();

        this.setShape(gp);
    }
}
