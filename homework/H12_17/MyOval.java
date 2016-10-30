import java.awt.*;

/**
 * Created by zehaeva on 10/30/16.
 */
public class MyOval extends MyBoundedShape {
    public MyOval() {
    }

    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(getX1(), getY1(), getWidth(), getHeight());
    }
}
