import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 11/3/16.
 */
public class SlidingPanel extends JPanel {
    private SlidingRectangle _left;
    private SlidingRectangle _right;

    public SlidingPanel() {
        //  set up the rectangles!
        this._left = new SlidingRectangle(-10, 10, Color.red);
        this._right = new SlidingRectangle(490, -10, Color.blue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this._left.move();
        this._right.move();

        g.setColor(this._left.getColor());
        g.fillRect(this._left.getX(), 0, this._left.getWidth(), 100);
        g.setColor(this._right.getColor());
        g.fillRect(this._right.getX(), 0, this._right.getWidth(), 100);

        int x = this._left.getX() - this._right.getX();

        g.setColor(new Color(255, 0, 255));
        if (this._left.getX() <= this._right.getX() &&
                this._left.getX() + this._left.getWidth() >= this._right.getX()) {
            g.fillRect(this._right.getX(), 0, this._left.getWidth() + this._left.getX() - this._right.getX(), 100);
        }
        if (this._right.getX() <= this._left.getX() &&
                this._right.getX() + this._right.getWidth() >= this._left.getX()) {
            g.fillRect(this._left.getX(), 0, this._right.getWidth() + this._right.getX() - this._left.getX(), 100);
        }
    }
}
