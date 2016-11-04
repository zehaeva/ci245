import java.awt.*;

/**
 * Created by zehaeva on 11/3/16.
 */
public class SlidingRectangle {
    private int _here;
    private int _direction;
    private Color _color;
    private int _width;

    public SlidingRectangle(int x, int v, Color color) {
        this._here = x;
        this._direction = v;
        this._color = color;
        this._width = 30;
    }

    public Color getColor() {
        return _color;
    }
    public void setColor(Color color) {
        this._color = color;
    }

    public int getX() {
        return _here;
    }
    public void setX(int x) {
        this._here = x;
    }

    public int getWidth() {
        return _width;
    }
    public void setWidth(int x) {
        this._width = x;
    }

    public void setVelocity(int v) {
        this._direction = v;
    }
    public int getVelocity() { return this._direction; }

    public void move(){
        this._here += this._direction;
    }
}
